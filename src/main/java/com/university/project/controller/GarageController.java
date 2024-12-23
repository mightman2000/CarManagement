package com.university.project.controller;

import com.university.project.dto.garage.CreateGarageDto;
import com.university.project.dto.garage.ResponseGarageDTO;
import com.university.project.dto.garage.UpdateGarageDTO;
import com.university.project.dto.report.GarageDailyAvailabilityReportDTO;
import com.university.project.model.Garage;
import com.university.project.service.garage.GarageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/garages")
public class GarageController {

    private GarageService garageService;

    public GarageController(GarageService theGarageService) {
        garageService = theGarageService;
    }

    @GetMapping("/{id}")
    public Garage getGarageById(@PathVariable int id){

        return garageService.findById(id);
    }

    @PostMapping
    public Garage addGarage(@RequestBody CreateGarageDto createGarageDto){

       return garageService.saveGarage(createGarageDto);
    }

    @PutMapping ("/{id}")
    public Garage updateGarage(@PathVariable int id, @RequestBody UpdateGarageDTO updateGarageDTO){
         return garageService.updateGarage(id, updateGarageDTO);
    }

    @DeleteMapping("/{id}")
    public void removeGarage(@PathVariable int id){
        garageService.deleteById(id);
    }

    @GetMapping
    public List<ResponseGarageDTO> getAllGarages(@RequestParam(required = false, name = "city") String city) {

        if (city != null && !city.isEmpty()) {
            return garageService.findGarageByCity(city);
        }

        return garageService.getAllGarages();

    }

    //@GetMapping ("/dailyAvailabilityReport")
    //public List<GarageDailyAvailabilityReportDTO> getDailyAvailabilityReport(@RequestParam Long garageId,
    //                                                                         @RequestParam String startDate,
    //                                                                         @RequestParam String endDate){
    //
    //    return garageService.getDailyAvailabilityReport(garageId, startDate, endDate);
    //}
}
