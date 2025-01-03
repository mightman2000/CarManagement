package com.university.project.dto.car;

import java.util.List;

public class UpdateCarDTO {
    private String make;
    private String model;
    private int productionYear;
    private String licensePlate;
    private List<Integer> garageIds;

    public UpdateCarDTO() {
    }

    public UpdateCarDTO(String make, String model, int productionYear, String licensePlate, List<Integer> garageIds) {
        this.make = make;
        this.model = model;
        this.productionYear = productionYear;
        this.licensePlate = licensePlate;
        this.garageIds = garageIds;
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

    public List<Integer> getGarageIds() {
        return garageIds;
    }

    public void setGarageIds(List<Integer> garageIds) {
        this.garageIds = garageIds;
    }
}