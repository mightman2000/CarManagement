package com.university.project.dto.garage;

import java.time.LocalDate;

public class ResponseGarageDTO {
    private int id;
    private String name;
    private String location;
    private String city;
    private int capacity;

    public ResponseGarageDTO() {
    }

    public ResponseGarageDTO(int id, String name, String location, String city, int capacity) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.city = city;
        this.capacity = capacity;
    }

    public ResponseGarageDTO(int id, int id1, String carName, String serviceType, LocalDate scheduledDate, int id2, String garageName) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}