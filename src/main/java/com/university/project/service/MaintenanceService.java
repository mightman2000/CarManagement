package com.university.project.service;

import com.university.project.dto.maintenance.ResponseMaintenanceDTO;

import java.util.List;

public interface MaintenanceService {

    public List<ResponseMaintenanceDTO> findAllMaintenances();

}
