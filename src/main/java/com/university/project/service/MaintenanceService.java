package com.university.project.service;

import com.university.project.dto.ResponseMaintenanceDTO;

import java.util.List;

public interface MaintenanceService {

    public List<ResponseMaintenanceDTO> findAllMaintenances();

}
