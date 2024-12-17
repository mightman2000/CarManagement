package com.university.project.controller;

import com.university.project.dto.car.UpdateCarDTO;
import com.university.project.dto.garage.CreateGarageDto;
import com.university.project.dto.garage.ResponseGarageDTO;
import com.university.project.dto.garage.UpdateGarageDTO;
import com.university.project.model.Garage;
import com.university.project.service.GarageService;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<List<ResponseGarageDTO>> getAllGarages() {
        List<ResponseGarageDTO> garages = garageService.getAllGarages();
        return ResponseEntity.ok(garages);
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

}
