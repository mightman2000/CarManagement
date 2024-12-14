package com.university.project.service;

import com.university.project.model.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    Car findById(int theId);

    Car save(Car theCar);

    void deleteById(int theId);

}

