package com.university.project.service.maintenance;

import com.university.project.dto.car.ResponseCarDTO;
import com.university.project.dto.maintenance.CreateMaintenanceDTO;
import com.university.project.dto.maintenance.ResponseMaintenanceDTO;
import com.university.project.dto.maintenance.UpdateMaintenanceDTO;
import com.university.project.model.Car;
import com.university.project.model.Garage;
import com.university.project.model.Maintenance;
import com.university.project.repository.CarRepository;
import com.university.project.repository.GarageRepository;
import com.university.project.repository.MaintenanceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private MaintenanceRepository maintenanceRepository;
    private GarageRepository garageRepository;
    private CarRepository carRepository;

    @Autowired
    public MaintenanceServiceImpl(MaintenanceRepository theMaintenanceRepository, GarageRepository theGarageRepository, CarRepository theCarRepository) {
        maintenanceRepository = theMaintenanceRepository;
        garageRepository = theGarageRepository;
        carRepository = theCarRepository;
    }

    public List<ResponseMaintenanceDTO> findAllMaintenances() {
        List<Maintenance> maintenances = maintenanceRepository.findAll();
        return maintenances.stream()
                .map(this::convertToDTO) // Map each Garage to ResponseGarageDTO
                .collect(Collectors.toList());
    }

    private ResponseMaintenanceDTO convertToDTO(Maintenance maintenance) {
        return new ResponseMaintenanceDTO(
                maintenance.getId(),
                maintenance.getCar().getId(),
                maintenance.getCarName(),
                maintenance.getServiceType(),
                maintenance.getScheduledDate(),
                maintenance.getGarage().getId(),
                maintenance.getGarageName()
        );
    }
    @Override
    public Maintenance saveMaintenance(CreateMaintenanceDTO createMaintenanceDTO) {
        // Find the related Garage entity
        Optional<Garage> optionalGarage = garageRepository.findById(createMaintenanceDTO.getGarageId());
        if (!optionalGarage.isPresent()) {
            throw new EntityNotFoundException("Garage with ID " + createMaintenanceDTO.getGarageId() + " not found");
        }

        // Find the related Car entity
        Optional<Car> optionalCar = carRepository.findById(createMaintenanceDTO.getCarId());
        if (!optionalCar.isPresent()) {
            throw new EntityNotFoundException("Car with ID " + createMaintenanceDTO.getCarId() + " not found");
        }

        // Map DTO to Entity
        Maintenance maintenance = new Maintenance();
        maintenance.setGarage(optionalGarage.get());
        maintenance.setCar(optionalCar.get());
        maintenance.setServiceType(createMaintenanceDTO.getServiceType());

        // Parse and set the scheduled date
        maintenance.setScheduledDate(createMaintenanceDTO.getScheduledDate());

        // Save to database
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance updateMaintenance(int id, UpdateMaintenanceDTO updateMaintenanceDTO) {
        Optional<Maintenance> optionalMaintenance = maintenanceRepository.findById(id);

        if (optionalMaintenance.isPresent()) {
            Maintenance maintenance = optionalMaintenance.get();

            if (updateMaintenanceDTO.getServiceType() != null) maintenance.setServiceType(updateMaintenanceDTO.getServiceType());
            if (updateMaintenanceDTO.getScheduledDate() != null) maintenance.setScheduledDate(updateMaintenanceDTO.getScheduledDate());

            // Fetch and set Garage and Car if IDs are provided
            if (updateMaintenanceDTO.getGarageId() != 0) {
                Optional<Garage> garageOpt = garageRepository.findById(updateMaintenanceDTO.getGarageId());
                if (garageOpt.isPresent()) {
                    maintenance.setGarage(garageOpt.get());
                }
            }

            if (updateMaintenanceDTO.getCarId() != 0) {
                Optional<Car> carOpt = carRepository.findById(updateMaintenanceDTO.getCarId());
                if (carOpt.isPresent()) {
                    maintenance.setCar(carOpt.get());
                }
            }

            return maintenanceRepository.save(maintenance);
        } else {
            throw new RuntimeException("Maintenance not found with id: " + id);
        }
    }

    @Override
    public void deleteById(int theId) {
        maintenanceRepository.deleteById(theId);
    }

    public List<ResponseMaintenanceDTO> findMaintenanceByGarageId(int garageId){

        List<Maintenance> maintenances = maintenanceRepository.findByGarageId(garageId);

        return maintenances.stream()
                .map(this::convertToDTO) // Convert each car to DTO
                .collect(Collectors.toList());
    }


    public List<ResponseMaintenanceDTO> findMaintenanceByCarId(int carId){

        List<Maintenance> maintenances = maintenanceRepository.findByCarId(carId);

        return maintenances.stream()
                .map(this::convertToDTO) // Convert each car to DTO
                .collect(Collectors.toList());
    }

}
