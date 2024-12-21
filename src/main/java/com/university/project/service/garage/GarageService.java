package com.university.project.service.garage;

import com.university.project.dto.garage.CreateGarageDto;
import com.university.project.dto.garage.ResponseGarageDTO;
import com.university.project.dto.garage.UpdateGarageDTO;
import com.university.project.model.Garage;

import java.util.List;

public interface GarageService {

    public Garage updateGarage(int id, UpdateGarageDTO updateGarageDTO);

    public Garage saveGarage(CreateGarageDto createGarageDto);

    public List<ResponseGarageDTO> getAllGarages();

    Garage findById(int theId);

    Garage save(Garage theGarage);

    void deleteById(int theId);

    public List<ResponseGarageDTO> findGarageByCity(String city);
}
