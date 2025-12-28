package entity;

import enums.ParkingSpotStatus;
import enums.ParkingSpotType;
import enums.VehicleType;
import exception.NoSpotAvailableException;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String parkingLotId;
    private List<ParkingFloor> floors;
    private static ParkingLot instance;

    private ParkingLot(){
        this.floors = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance(){
        if(instance == null){
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }

    public ParkingSpot assignSpot(Vehicle vehicle){
        for(ParkingFloor floor : floors){
            ParkingSpot spot = floor.getAvailableSpot(vehicle.getVehicleType());
            if(spot != null){
                spot.assignVehicle(vehicle);
                return spot;
            }
        }
        throw new NoSpotAvailableException("No spot available for vehicle");
    }

    public void releaseSpot(ParkingSpot spot){
        spot.removeVehicle();
    }
}
