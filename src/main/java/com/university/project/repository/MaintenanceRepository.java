package com.university.project.repository;

import com.university.project.model.Car;
import com.university.project.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {

    List<Maintenance> findByGarageId(int garageId);

    List<Maintenance> findByCarId(int carId);


}
