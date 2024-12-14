package com.university.project.service;

import com.university.project.model.Car;
import com.university.project.model.Garage;

import java.util.List;

public interface GarageService {
    List<Garage> findAll();

    Garage findById(int theId);

    Garage save(Garage theGarage);

    void deleteById(int theId);
}
