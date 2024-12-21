package com.university.project.dto.car;

import com.university.project.dto.garage.ResponseGarageDTO;

import java.util.List;
import java.util.Objects;

public class ResponseCarDTO {

    private int id;
    private String make;
    private String model;
    private int productionYear;
    private String licensePlate;
    private List<ResponseGarageDTO> garages;

    public ResponseCarDTO() {
    }

    public ResponseCarDTO(int id, String make, String model, int productionYear, String licensePlate, List<ResponseGarageDTO> garages) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.productionYear = productionYear;
        this.licensePlate = licensePlate;
        this.garages = garages;
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

    public List<ResponseGarageDTO> getGarages() {
        return garages;
    }

    public void setGarages(List<ResponseGarageDTO> garages) {
        this.garages = garages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseCarDTO that = (ResponseCarDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
