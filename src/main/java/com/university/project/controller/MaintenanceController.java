package com.university.project.controller;

import com.university.project.dto.maintenance.CreateMaintenanceDTO;
import com.university.project.dto.maintenance.ResponseMaintenanceDTO;
import com.university.project.dto.maintenance.UpdateMaintenanceDTO;
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

    //@GetMapping
    //public List<ResponseMaintenanceDTO> getAllMaintenances(){
    //     return maintenanceService.findAllMaintenances();
    //    }

    @PostMapping
    public Maintenance addMaintenance(@RequestBody CreateMaintenanceDTO createMaintenanceDTO){

       return maintenanceService.saveMaintenance(createMaintenanceDTO);

    }


    @PutMapping("/{id}")
    Maintenance updateMaintenance(@PathVariable int id, @RequestBody UpdateMaintenanceDTO updateMaintenanceDTO){

        return maintenanceService.updateMaintenance(id, updateMaintenanceDTO);
    }

    @DeleteMapping("/{id}")
    public void removeMaintenance(@PathVariable int id){
        maintenanceService.deleteById(id);
    }

    @GetMapping
    public List<ResponseMaintenanceDTO> getAllMaintenances(@RequestParam(required = false, name = "garageId") Integer garageId,
                                                           @RequestParam(required = false, name = "carId") Integer carId){

        if (garageId != null && garageId != 0) {
            return maintenanceService.findMaintenanceByGarageId(garageId);
        }

        if(carId !=null && carId !=0){
            return maintenanceService.findMaintenanceByCarId(carId);
        }



        return maintenanceService.findAllMaintenances();
    }



}
