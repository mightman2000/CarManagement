package com.university.project.controller;

import com.university.project.dto.car.CreateCarDTO;
import com.university.project.dto.car.ResponseCarDTO;
import com.university.project.dto.car.UpdateCarDTO;
import com.university.project.model.Car;
import com.university.project.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
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

    //@GetMapping
    //public List<ResponseCarDTO> getAllCars() {
    //    return carService.getAllCars();
    //}

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

    @DeleteMapping("/{id}")
    public void removeCar(@PathVariable int id){
        carService.deleteById(id);
    }

    //filtering
   @GetMapping
   public List<ResponseCarDTO> getCars(@RequestParam(required = false, name = "carMake") String carMake,
                                       @RequestParam(required = false, name = "garageId") Integer garageId,
                                       @RequestParam(required = false, name = "fromYear") Integer fromYear,
                                       @RequestParam(required = false, name = "toYear") Integer toYear) {
       if (carMake != null && !carMake.isEmpty()) {
           return carService.findCarsByMake(carMake);
       }

       if (garageId != null && garageId != 0) {
           return carService.findCarByGarageId(garageId);
       }

       if (fromYear !=null && fromYear >= 0 ){
           return carService.findCarByFromYear(fromYear);
       }

       if (toYear !=null && toYear > 0 ){
           return carService.findCarByToYear(toYear);
       }

       return carService.getAllCars(); // Return all cars
   }



}
