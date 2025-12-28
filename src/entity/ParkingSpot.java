package entity;

import enums.ParkingSpotStatus;
import enums.ParkingSpotType;
import enums.VehicleType;

public class ParkingSpot {
    private String spotId;
    private ParkingSpotType spotType;
    private ParkingSpotStatus status;
    private int floorNumber;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, ParkingSpotType spotType, int floorNumber) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.floorNumber = floorNumber;
        this.status = ParkingSpotStatus.AVAILABLE;
    }

    public synchronized boolean canFitVehicle(VehicleType type){
        if(status == ParkingSpotStatus.OCCUPIED){
            return false;
        }
        return switch(type){
            case MOTORCYCLE -> spotType == ParkingSpotType.SMALL || spotType == ParkingSpotType.MEDIUM || spotType == ParkingSpotType.LARGE;
            case CAR -> spotType == ParkingSpotType.MEDIUM || spotType == ParkingSpotType.LARGE;
            case BUS -> spotType == ParkingSpotType.LARGE;
        };
    }

    public synchronized void assignVehicle(Vehicle vehicle){
        if(!canFitVehicle(vehicle.getVehicleType())){
            throw new IllegalStateException("Vehicle cannot fit in this parking spot");
        }
        this.parkedVehicle = vehicle;
        this.status = ParkingSpotStatus.OCCUPIED;
    }

    public synchronized void removeVehicle(){
        if(status == ParkingSpotStatus.AVAILABLE){
            throw new IllegalStateException("Parking spot is already empty");
        }
        this.parkedVehicle = null;
        this.status = ParkingSpotStatus.AVAILABLE;
    }

    public String getSpotId() {
        return spotId;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public ParkingSpotStatus getSpotStatus() {
        return status;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
