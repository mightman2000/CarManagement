package com.university.project.controller;

import com.university.project.dto.maintenance.ResponseMaintenanceDTO;
import com.university.project.service.MaintenanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    private MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping
    public List<ResponseMaintenanceDTO> getAllMaintenances(){
         return maintenanceService.findAllMaintenances();
        }
}
