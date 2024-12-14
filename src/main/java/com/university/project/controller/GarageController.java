package com.university.project.controller;

import com.university.project.dto.ResponseGarageDTO;
import com.university.project.model.Car;
import com.university.project.model.Garage;
import com.university.project.service.GarageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
