package com.university.project.service;

import com.university.project.dto.car.ResponseCarDTO;
import com.university.project.dto.garage.CreateGarageDto;
import com.university.project.dto.garage.ResponseGarageDTO;
import com.university.project.dto.garage.UpdateGarageDTO;
import com.university.project.model.Car;
import com.university.project.model.Garage;
import com.university.project.repository.GarageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GarageServiceImpl implements GarageService{

    private GarageRepository garageRepository;

    @Autowired
    public GarageServiceImpl(GarageRepository theGarageRepository) {
        garageRepository = theGarageRepository;
    }


    public List<ResponseGarageDTO> getAllGarages() {
        List<Garage> garages = garageRepository.findAll();
        return garages.stream()
                .map(this::convertToDTO) // Map each Garage to ResponseGarageDTO
                .collect(Collectors.toList());
    }

    private ResponseGarageDTO convertToDTO(Garage garage) {
        return new ResponseGarageDTO(
                garage.getId(),
                garage.getName(),
                garage.getLocation(),
                garage.getCity(),
                garage.getCapacity()
        );
    }

    @Override
    public Garage findById(int theId) {
        Optional<Garage> result = garageRepository.findById(theId);

        Garage theGarage = null;

        if (result.isPresent()) {
            theGarage = result.get();
        } else {
            throw new RuntimeException("Did not find car with id - " + theId);
        }

        return theGarage;
    }

    @Override
    public Garage save(Garage theGarage) {
        return garageRepository.save(theGarage);
    }

    @Override
    public void deleteById(int theId) {
        garageRepository.deleteById(theId);
    }


    @Override
    public Garage saveGarage(CreateGarageDto createGarageDto) {
        Garage garage = new Garage();
        garage.setName(createGarageDto.getName());
        garage.setLocation(createGarageDto.getLocation());
        garage.setCity(createGarageDto.getCity());
        garage.setCapacity(createGarageDto.getCapacity());

        return garageRepository.save(garage);
    }

    @Override
    public Garage updateGarage(int id, UpdateGarageDTO updateGarageDTO) {
        Optional<Garage> optionalGarage = garageRepository.findById(id);

        if (optionalGarage.isPresent()) {
            Garage garage = optionalGarage.get();

            if (updateGarageDTO.getName() != null) garage.setName(updateGarageDTO.getName());
            if (updateGarageDTO.getLocation() != null) garage.setLocation(updateGarageDTO.getLocation());
            if (updateGarageDTO.getCapacity() != 0) garage.setCapacity(updateGarageDTO.getCapacity());
            if (updateGarageDTO.getCity() != null) garage.setCity(updateGarageDTO.getCity());

            return garageRepository.save(garage);
        } else {
            throw new EntityNotFoundException("Garage with id " + id + " not found");
        }
    }

    public List<ResponseGarageDTO> findGarageByCity(String city) {
        List<Garage> garage = garageRepository.findByCityContainingIgnoreCase(city); // Fetch cars by make
        return garage.stream()
                .map(this::convertToDTO) // Convert each car to DTO
                .collect(Collectors.toList());
    }

}
