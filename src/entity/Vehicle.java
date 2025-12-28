package entity;

import enums.VehicleType;

public class Vehicle {
    private String vehicleNumber;
    private VehicleType VehicleType;

    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        VehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }


    public VehicleType getVehicleType() {
        return VehicleType;
    }
}
