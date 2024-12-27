package com.university.project.service.car;

import com.university.project.dto.car.CreateCarDTO;
import com.university.project.dto.car.ResponseCarDTO;
import com.university.project.dto.car.UpdateCarDTO;
import com.university.project.model.Car;

import java.util.List;

public interface CarService {

    Car saveCar(CreateCarDTO createCarDTO);

    List<ResponseCarDTO> getAllCars();

    List<ResponseCarDTO> findById(int theId);

    Car save(Car theCar);

    void deleteById(int theId);

    Car updateCar(Integer id, UpdateCarDTO updateCarDTO);

    List<ResponseCarDTO> findCarsByMake(String make);

    List<ResponseCarDTO> findCarByGarageId(int garageId);

    List<ResponseCarDTO> findCarByFromYear(int fromYear);

    List<ResponseCarDTO> findCarByToYear(int fromYear);
}

