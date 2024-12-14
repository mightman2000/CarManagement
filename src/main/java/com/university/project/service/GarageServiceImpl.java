package com.university.project.service;

import com.university.project.model.Car;
import com.university.project.model.Garage;
import com.university.project.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarageServiceImpl implements GarageService{

    private GarageRepository garageRepository;

    @Autowired
    public GarageServiceImpl(GarageRepository theGarageRepository) {
        garageRepository = theGarageRepository;
    }

    @Override
    public List<Garage> findAll() {
        return garageRepository.findAll();
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
}