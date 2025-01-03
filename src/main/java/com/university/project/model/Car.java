package com.university.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String make;
    private String model;
    private int productionYear;
    private String licensePlate;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "garage_id", nullable = false)
   private Garage garage;

   @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Maintenance> maintenances;

    public Car() {
    }

    public Car(String make, String model, int productionYear, String licensePlate, List<Garage> garages) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }
}
