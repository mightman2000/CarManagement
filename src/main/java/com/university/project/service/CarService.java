package com.university.project.service;

import com.university.project.dto.ResponseCarDTO;
import com.university.project.model.Car;

import java.util.List;

public interface CarService {

    public List<ResponseCarDTO> getAllCars();

    Car findById(int theId);

    Car save(Car theCar);

    void deleteById(int theId);

}

