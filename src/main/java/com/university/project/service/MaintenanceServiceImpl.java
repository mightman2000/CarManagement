package com.university.project.service;

import com.university.project.dto.ResponseGarageDTO;
import com.university.project.dto.ResponseMaintenanceDTO;
import com.university.project.model.Maintenance;
import com.university.project.repository.MaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaintenanceServiceImpl {

    private MaintenanceRepository maintenanceRepository;

    public MaintenanceServiceImpl(MaintenanceRepository theMaintenanceRepository) {
        maintenanceRepository = theMaintenanceRepository;
    }

}
