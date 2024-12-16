package com.university.project.service;

import com.university.project.dto.garage.ResponseGarageDTO;
import com.university.project.model.Garage;

import java.util.List;

public interface GarageService {

    public List<ResponseGarageDTO> getAllGarages();

    Garage findById(int theId);

    Garage save(Garage theGarage);

    void deleteById(int theId);
}
