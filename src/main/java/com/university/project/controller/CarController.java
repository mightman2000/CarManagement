package com.university.project.controller;

import com.university.project.dto.car.CreateCarDTO;
import com.university.project.dto.car.ResponseCarDTO;
import com.university.project.dto.car.UpdateCarDTO;
import com.university.project.model.Car;
import com.university.project.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService theCarService) {
        carService = theCarService;
    }

    @GetMapping
    public List<ResponseCarDTO> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id){

        return carService.findById(id);
    }

   @PostMapping
   public Car createCar(@RequestBody CreateCarDTO carDTO) {

        return carService.saveCar(carDTO);
   }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Integer id, @RequestBody UpdateCarDTO updateCarDTO) {
        return carService.updateCar(id, updateCarDTO);
    }

}
