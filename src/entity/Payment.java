package entity;

import java.time.LocalDateTime;

public class Payment {
    private String paymentId;
    private ParkingTicket ticket;
    private double amount;
    private LocalDateTime paymentTime;

    public Payment(String paymentId, ParkingTicket ticket, double amount) {
        this.paymentId = paymentId;
        this.ticket = ticket;
        this.amount = amount;
        this.paymentTime = LocalDateTime.now();
    }


    public void processPayment() {
        System.out.println("Payment processed: ₹" + amount);
    }
}
