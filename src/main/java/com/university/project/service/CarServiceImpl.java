package com.university.project.service;

import com.university.project.dto.ResponseCarDTO;
import com.university.project.dto.ResponseGarageDTO;
import com.university.project.model.Car;
import com.university.project.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository theCarRepository) {
        carRepository = theCarRepository;
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
        return carRepository.save(theCar);
    }

    @Override
    public void deleteById(int theId) {
        carRepository.deleteById(theId);
    }
}
