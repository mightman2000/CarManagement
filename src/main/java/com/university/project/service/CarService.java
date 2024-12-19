package com.university.project.service;

import com.university.project.dto.car.CreateCarDTO;
import com.university.project.dto.car.ResponseCarDTO;
import com.university.project.dto.car.UpdateCarDTO;
import com.university.project.model.Car;

import java.util.List;

public interface CarService {

    public Car saveCar(CreateCarDTO createCarDTO);

   // public List<ResponseCarDTO> getFilteredCars(String carMake, Integer garageId, Integer fromYear, Integer toYear);

    public List<ResponseCarDTO> getAllCars();

    Car findById(int theId);

    Car save(Car theCar);

    void deleteById(int theId);

    public Car updateCar(Integer id, UpdateCarDTO updateCarDTO);

    public List<ResponseCarDTO> findCarsByMake(String make);

    public List<ResponseCarDTO> findCarByGarageId(int garageId);

    public List<ResponseCarDTO> findCarByFromYear(int fromYear);

    public List<ResponseCarDTO> findCarByToYear(int fromYear);
}

