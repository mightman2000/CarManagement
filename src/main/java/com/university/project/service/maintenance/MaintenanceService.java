package com.university.project.service.maintenance;

import com.university.project.dto.maintenance.CreateMaintenanceDTO;
import com.university.project.dto.maintenance.ResponseMaintenanceDTO;
import com.university.project.dto.maintenance.UpdateMaintenanceDTO;
import com.university.project.model.Maintenance;

import java.util.List;

public interface MaintenanceService {

    List<ResponseMaintenanceDTO> findAllMaintenances();

    Maintenance saveMaintenance(CreateMaintenanceDTO createMaintenanceDTO);

    Maintenance updateMaintenance(int id, UpdateMaintenanceDTO updateMaintenanceDTO);

    void deleteById(int theId);

    List<ResponseMaintenanceDTO> findById(int theId);

    List<ResponseMaintenanceDTO> findMaintenanceByGarageId(int garageId);

    List<ResponseMaintenanceDTO> findMaintenanceByCarId(int carId);

    List<ResponseMaintenanceDTO> findMaintenanceBetweenDate(String startDate, String endDate);


}
