package com.university.project.dto.maintenance;

public class CreateMaintenanceDTO {

    private int garageId;
    private int carId;
    private String serviceType;
    private String scheduledDate;

    public CreateMaintenanceDTO() {
    }

    public CreateMaintenanceDTO(int garageId, int carId, String serviceType, String scheduledDate) {
        this.garageId = garageId;
        this.carId = carId;
        this.serviceType = serviceType;
        this.scheduledDate = scheduledDate;
    }

    public int getGarageId() {
        return garageId;
    }

    public void setGarageId(int garageId) {
        this.garageId = garageId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }
}
