import entity.*;
import enums.ParkingSpotType;
import enums.VehicleType;
import service.ParkingService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance();

        Map<ParkingSpotType, Set<ParkingSpot>> floor1Spots = new HashMap<>();
        Map<ParkingSpotType, Set<ParkingSpot>> floor2Spots = new HashMap<>();

        // Add Parking Spots to Floor 1
        floor1Spots.put(ParkingSpotType.SMALL, Set.of(new ParkingSpot("GR-1999", ParkingSpotType.SMALL, 1)));
        floor1Spots.put(ParkingSpotType.MEDIUM, Set.of(new ParkingSpot("HR-2005", ParkingSpotType.MEDIUM, 1)));
        floor1Spots.put(ParkingSpotType.LARGE, Set.of(new ParkingSpot("MH-2365", ParkingSpotType.LARGE, 1)));

        // Add Parking Spots to Floor 2
        floor2Spots.put(ParkingSpotType.SMALL, Set.of(new ParkingSpot("BH1-1999", ParkingSpotType.SMALL, 2)));
        floor2Spots.put(ParkingSpotType.MEDIUM, Set.of(new ParkingSpot("BH1-2005", ParkingSpotType.MEDIUM, 2)));

        ParkingFloor floor1 = new ParkingFloor(1);
        ParkingFloor floor2 = new ParkingFloor(2);

        parkingLot.addFloor(floor1);
        
        parkingLot.addFloor(floor2);

        ParkingService parkingService = new ParkingService();

        Vehicle bike = new Vehicle("Bike", VehicleType.MOTORCYCLE);
        Vehicle car = new Vehicle("Car", VehicleType.CAR);
        Vehicle bus = new Vehicle("Bus", VehicleType.BUS);

        ParkingTicket ticket = parkingService.checkIn(car);
        System.out.println("Car parked at spot: "
                + ticket.getSpot().getSpotId()
                + " | Entry Time: " + ticket.getEntryTime());

        System.out.println("\n Car is parked...");
//        TimeUnit.SECONDS.sleep(3);

        System.out.println("\nCar exiting parking lot...");
        Payment payment = parkingService.checkOut(ticket);
    }
}