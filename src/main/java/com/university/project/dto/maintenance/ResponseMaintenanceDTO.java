package com.university.project.dto.maintenance;

import java.time.LocalDate;

public class ResponseMaintenanceDTO {

    private int id;
    private int carId;
    private String carName;
    private String serviceType;
    private String scheduleDate;
    private int garageId;
    private String garageName;


    public ResponseMaintenanceDTO() {
    }

    public ResponseMaintenanceDTO(int id, int carId, String carName, String serviceType, String scheduleDate, int garageId, String garageName) {
        this.id = id;
        this.carId = carId;
        this.carName = carName;
        this.serviceType = serviceType;
        this.scheduleDate = scheduleDate;
        this.garageId = garageId;
        this.garageName = garageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public int getGarageId() {
        return garageId;
    }

    public void setGarageId(int garageId) {
        this.garageId = garageId;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }
}