package com.university.project.repository;

import com.university.project.dto.report.GarageDailyAvailabilityReportDTO;
import com.university.project.model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GarageRepository extends JpaRepository<Garage, Integer> {

    List<Garage> findByCityContainingIgnoreCase(String city);

}
