package com.university.project.service;

import com.university.project.dto.car.CreateCarDTO;
import com.university.project.dto.car.ResponseCarDTO;
import com.university.project.dto.car.UpdateCarDTO;
import com.university.project.dto.garage.ResponseGarageDTO;
import com.university.project.model.Car;
import com.university.project.model.Garage;
import com.university.project.repository.CarRepository;
import com.university.project.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{

    private CarRepository carRepository;
    private GarageRepository garageRepository;


    @Autowired
    public CarServiceImpl(CarRepository theCarRepository, GarageRepository theGarageRepository) {
        carRepository = theCarRepository;
        garageRepository = theGarageRepository;
    }

    public List<ResponseCarDTO> getAllCars() {
        List<Car> cars = carRepository.findAll(); // Fetch all cars
        return cars.stream()
                .map(this::convertToCarDTO) // Convert each car to DTO
                .collect(Collectors.toList());
    }

    private ResponseCarDTO convertToCarDTO(Car car) {
        // Map the nested garages to ResponseGarageDTO
        ResponseGarageDTO garageDTO = new ResponseGarageDTO(
                car.getGarage().getId(),
                car.getGarage().getName(),
                car.getGarage().getLocation(),
                car.getGarage().getCity(),
                car.getGarage().getCapacity()
        );

        // Map the car itself
        return new ResponseCarDTO(
                car.getId(),
                car.getMake(),
                car.getModel(),
                car.getProductionYear(),
                car.getLicensePlate(),
                Collections.singletonList(garageDTO)
        );
    }

    @Override
    public Car findById(int theId) {
        Optional<Car> result = carRepository.findById(theId);

        Car theCar = null;

        if (result.isPresent()) {
            theCar = result.get();
        } else {
            throw new RuntimeException("Did not find car with id - " + theId);
        }

        return theCar;
    }

    @Override
    public Car save(Car theCar) {
        return null;
    }

    @Override
    public Car saveCar(CreateCarDTO createCarDTO) {
        Car car = new Car();
        car.setMake(createCarDTO.getMake());
        car.setModel(createCarDTO.getModel());
        car.setProductionYear(createCarDTO.getProductionYear());
        car.setLicensePlate(createCarDTO.getLicensePlate());

        Optional<Garage> garageOpt = garageRepository.findById(createCarDTO.getGarageIds().get(0));
        if (garageOpt.isPresent()) {
            car.setGarage(garageOpt.get());
        }

        return carRepository.save(car);
    }

    @Override
    public void deleteById(int theId) {
        carRepository.deleteById(theId);
    }

    @Override
    public Car updateCar(Integer id, UpdateCarDTO updateCarDTO) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();

            if (updateCarDTO.getMake() != null) car.setMake(updateCarDTO.getMake());
            if (updateCarDTO.getModel() != null) car.setModel(updateCarDTO.getModel());
            if (updateCarDTO.getProductionYear() != 0) car.setProductionYear(updateCarDTO.getProductionYear());
            if (updateCarDTO.getLicensePlate() != null) car.setLicensePlate(updateCarDTO.getLicensePlate());

            if (updateCarDTO.getGarageIds() != null && !updateCarDTO.getGarageIds().isEmpty()) {
                Integer garageId = updateCarDTO.getGarageIds().get(0);
                Optional<Garage> garageOpt = garageRepository.findById(garageId);
                if (garageOpt.isPresent()) {
                    car.setGarage(garageOpt.get());
                }
            }

            return carRepository.save(car);
        } else {
            throw new RuntimeException("Car not found");
        }
    }
}


