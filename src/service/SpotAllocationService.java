package service;

import entity.ParkingLot;
import entity.ParkingSpot;
import entity.Vehicle;

public class SpotAllocationService {

    public ParkingSpot findSpot(Vehicle vehicle){
        return ParkingLot.getInstance().assignSpot(vehicle);
    }

}
