package com.university.project.controller;

import com.university.project.dto.maintenance.CreateMaintenanceDTO;
import com.university.project.dto.maintenance.ResponseMaintenanceDTO;
import com.university.project.dto.maintenance.UpdateMaintenanceDTO;
import com.university.project.dto.report.GarageDailyAvailabilityReportDTO;
import com.university.project.dto.report.MonthlyRequestsReportDTO;
import com.university.project.model.Garage;
import com.university.project.model.Maintenance;
import com.university.project.service.maintenance.MaintenanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    private MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PostMapping
    public Maintenance addMaintenance(@RequestBody CreateMaintenanceDTO createMaintenanceDTO){

       return maintenanceService.saveMaintenance(createMaintenanceDTO);

    }

    @GetMapping("/{id}")
    public List<ResponseMaintenanceDTO> getMaintenanceById(@PathVariable int id){
        return maintenanceService.findById(id);
    }

    @PutMapping("/{id}")
    public Maintenance updateMaintenance(@PathVariable int id, @RequestBody UpdateMaintenanceDTO updateMaintenanceDTO){

        return maintenanceService.updateMaintenance(id, updateMaintenanceDTO);
    }

    @DeleteMapping("/{id}")
    public void removeMaintenance(@PathVariable int id){
        maintenanceService.deleteById(id);
    }

    @GetMapping
    public List<ResponseMaintenanceDTO> getAllMaintenances(@RequestParam(required = false, name = "garageId") Integer garageId,
                                                           @RequestParam(required = false, name = "carId") Integer carId,
                                                           @RequestParam(required = false, name = "carId") String startDate,
                                                           @RequestParam(required = false, name = "carId") String endDate){

        List<ResponseMaintenanceDTO> maintenances= maintenanceService.findAllMaintenances();

        if (garageId != null && garageId != 0) {
            List<ResponseMaintenanceDTO> filterMaintenances = maintenanceService.findMaintenanceByGarageId(garageId);
            maintenances.retainAll(filterMaintenances);
        }

        if (carId != null && carId != 0){
            List<ResponseMaintenanceDTO> filterMaintenances = maintenanceService.findMaintenanceByCarId(carId);
            maintenances.retainAll(filterMaintenances);
        }

        if (startDate != null && endDate != null) {
            List<ResponseMaintenanceDTO> filterMaintenances = maintenanceService.findMaintenanceBetweenDate(startDate, endDate);
            maintenances.retainAll(filterMaintenances); // Retain only the ones within the date range
        }

        return maintenances;
    }

    //report
    //@GetMapping("/monthlyRequestReport")
    //public MonthlyRequestsReportDTO getReport(){
    //
    //
    //
    //
    //}
}
