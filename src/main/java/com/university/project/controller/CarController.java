package com.university.project.controller;

import com.university.project.model.Car;
import com.university.project.service.CarService;
import com.university.project.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService theCarService) {
        carService = theCarService;
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id){

        return carService.findById(id);
    }

    @GetMapping("")
    public List<Car> getAllCars(){

        return carService.findAll();
    }

}
