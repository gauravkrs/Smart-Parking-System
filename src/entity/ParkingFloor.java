package entity;

import enums.ParkingSpotStatus;
import enums.ParkingSpotType;
import enums.VehicleType;

import java.util.*;

public class ParkingFloor {
    private int floorId;
    private Map<ParkingSpotType, Set<ParkingSpot>> parkingSpot;
    private boolean underMaintenance;

    public ParkingFloor(int floorId) {
        this.floorId = floorId;
        this.parkingSpot = new EnumMap<>(ParkingSpotType.class);
        for(ParkingSpotType type: ParkingSpotType.values()){
            parkingSpot.put(type, new HashSet<>());
        }
    }

    public int getFloorId() {
        return floorId;
    }

    public ParkingSpot getAvailableSpot(VehicleType type){
        if(underMaintenance){
            return null;
        }
        for (Map.Entry<ParkingSpotType, Set<ParkingSpot>> entry : parkingSpot.entrySet()) {
            for (ParkingSpot spot : entry.getValue()) {
                if(spot.canFitVehicle(type)){
                    return spot;
                }
            }
        }
        return null;

    }

    public Set<ParkingSpot> getAllSpots(){
        Set<ParkingSpot> allSpots = new HashSet<>();
        for (Set<ParkingSpot> set : parkingSpot.values()) {
            allSpots.addAll(set);
        }
        return allSpots;
    }

    public boolean isUnderMaintenance() {
        return underMaintenance;
    }

    public void setUnderMaintenance(boolean underMaintenance) {
        this.underMaintenance = underMaintenance;
    }
}
