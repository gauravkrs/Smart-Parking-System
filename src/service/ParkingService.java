package service;

import entity.*;

import java.util.UUID;

public class ParkingService {

    private final SpotAllocationService spotAllocationService = new SpotAllocationService();

    private final PaymentService paymentService = new PaymentService();

    public ParkingTicket checkIn(Vehicle vehicle){
        ParkingSpot spot = spotAllocationService.findSpot(vehicle);
        return new ParkingTicket(UUID.randomUUID().toString(), vehicle, spot);
    }

    public Payment checkOut(ParkingTicket ticket){
        ticket.closeTicket();
        ParkingLot.getInstance().releaseSpot(ticket.getSpot());

        double amount = paymentService.calculateAmount(ticket);
        Payment payment = new Payment(UUID.randomUUID().toString(), ticket, amount);
        payment.processPayment();

        return payment;
    }
}
