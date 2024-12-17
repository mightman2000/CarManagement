package com.university.project.service;

import com.university.project.dto.garage.CreateGarageDto;
import com.university.project.dto.garage.UpdateGarageDTO;
import com.university.project.dto.maintenance.CreateMaintenanceDTO;
import com.university.project.dto.maintenance.ResponseMaintenanceDTO;
import com.university.project.dto.maintenance.UpdateMaintenanceDTO;
import com.university.project.model.Garage;
import com.university.project.model.Maintenance;

import java.util.List;

public interface MaintenanceService {

    public List<ResponseMaintenanceDTO> findAllMaintenances();

    public Maintenance saveMaintenance(CreateMaintenanceDTO createMaintenanceDTO);

    public Maintenance updateMaintenance(int id, UpdateMaintenanceDTO updateMaintenanceDTO);

    void deleteById(int theId);

}
