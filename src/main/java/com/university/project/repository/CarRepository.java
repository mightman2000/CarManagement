package com.university.project.repository;

import com.university.project.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    List<Car> findByMakeContainingIgnoreCase(String make);

    List<Car> findByGarageId(int garageId);

    List<Car> findByProductionYearGreaterThanEqual(int fromYear);

    List<Car> findByProductionYearLessThanEqual(int toYear);

}
