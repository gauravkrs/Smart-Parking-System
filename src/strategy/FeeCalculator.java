package strategy;

import enums.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;

public class FeeCalculator {

    public double calculateFee(VehicleType vehicleType, LocalDateTime entry, LocalDateTime exit){
        long hours = Math.max(1, Duration.between(entry, exit).toHours());

        return switch (vehicleType){
            case MOTORCYCLE -> hours * 20;
            case CAR -> hours * 50;
            case BUS -> hours * 90;
        };
    } 
}
