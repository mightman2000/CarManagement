package com.university.project.service.maintenance;

import com.university.project.dto.maintenance.CreateMaintenanceDTO;
import com.university.project.dto.maintenance.ResponseMaintenanceDTO;
import com.university.project.dto.maintenance.UpdateMaintenanceDTO;
import com.university.project.model.Maintenance;

import java.util.List;

public interface MaintenanceService {

    public List<ResponseMaintenanceDTO> findAllMaintenances();

    public Maintenance saveMaintenance(CreateMaintenanceDTO createMaintenanceDTO);

    public Maintenance updateMaintenance(int id, UpdateMaintenanceDTO updateMaintenanceDTO);

    void deleteById(int theId);

    public List<ResponseMaintenanceDTO> findMaintenanceByGarageId(int garageId);

    public List<ResponseMaintenanceDTO> findMaintenanceByCarId(int carId);



}
