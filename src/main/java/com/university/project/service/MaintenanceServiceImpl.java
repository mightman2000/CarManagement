package com.university.project.service;

import com.university.project.dto.maintenance.ResponseMaintenanceDTO;
import com.university.project.model.Maintenance;
import com.university.project.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaintenanceServiceImpl implements MaintenanceService{

    private MaintenanceRepository maintenanceRepository;

    @Autowired
    public MaintenanceServiceImpl(MaintenanceRepository theMaintenanceRepository) {
        maintenanceRepository = theMaintenanceRepository;
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


}
