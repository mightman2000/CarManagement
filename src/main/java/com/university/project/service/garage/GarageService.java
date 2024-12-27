package com.university.project.service.garage;

import com.university.project.dto.garage.CreateGarageDto;
import com.university.project.dto.garage.ResponseGarageDTO;
import com.university.project.dto.garage.UpdateGarageDTO;
import com.university.project.dto.report.GarageDailyAvailabilityReportDTO;
import com.university.project.model.Garage;

import java.util.List;

public interface GarageService {

    Garage updateGarage(int id, UpdateGarageDTO updateGarageDTO);

    Garage saveGarage(CreateGarageDto createGarageDto);

    List<ResponseGarageDTO> getAllGarages();

    List<ResponseGarageDTO> findById(int theId);

    Garage save(Garage theGarage);

    void deleteById(int theId);

    List<ResponseGarageDTO> findGarageByCity(String city);
}
