package com.university.project.dto.maintenance;

public class UpdateMaintenanceDTO {

    private int carId;
    private String serviceType;
    private String scheduledDate;
    private int garageId;

    public UpdateMaintenanceDTO() {
    }

    public UpdateMaintenanceDTO(int carId, String serviceType, String scheduledDate, int garageId) {
        this.carId = carId;
        this.serviceType = serviceType;
        this.scheduledDate = scheduledDate;
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

    public int getGarageId() {
        return garageId;
    }

    public void setGarageId(int garageId) {
        this.garageId = garageId;
    }
}
