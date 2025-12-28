package service;

import entity.ParkingTicket;
import strategy.FeeCalculator;

public class PaymentService {

    private final FeeCalculator feeCalculator = new FeeCalculator();

    public double calculateAmount(ParkingTicket ticket){
        return feeCalculator.calculateFee(
                ticket.getVehicle().getVehicleType(),
                ticket.getEntryTime(),
                ticket.getExitTime()
        );
    }
}
