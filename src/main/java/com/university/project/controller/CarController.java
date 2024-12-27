package com.university.project.controller;

import com.university.project.dto.car.CreateCarDTO;
import com.university.project.dto.car.ResponseCarDTO;
import com.university.project.dto.car.UpdateCarDTO;
import com.university.project.model.Car;
import com.university.project.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService theCarService) {
        carService = theCarService;
    }

    @GetMapping("/{id}")
    public List<ResponseCarDTO> getCarById(@PathVariable int id){

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
        List<ResponseCarDTO> cars = carService.getAllCars();

       if (carMake != null && !carMake.isEmpty()) {
           List<ResponseCarDTO> filteredCars = carService.findCarsByMake(carMake);
           cars.retainAll(filteredCars);
       }

       if (garageId != null && garageId != 0) {
           List<ResponseCarDTO> filteredCars = carService.findCarByGarageId(garageId);
           cars.retainAll(filteredCars);
       }

       if (fromYear != null && fromYear >= 0 ) {
           List<ResponseCarDTO> filteredCars = carService.findCarByFromYear(fromYear);
           cars.retainAll(filteredCars);
       }

       if (toYear != null && toYear > 0 ) {
           List<ResponseCarDTO> filteredCars = carService.findCarByToYear(toYear);
           cars.retainAll(filteredCars);
       }

       return cars;
   }



}
