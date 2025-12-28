package entity;

import enums.TicketStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ParkingTicket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private TicketStatus status;

    public ParkingTicket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.ACTIVE;
    }

    public void closeTicket(){
        this.exitTime = LocalDateTime.now();
        this.status = TicketStatus.CLOSED;
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime  getEntryTime() {
        return entryTime;
    }

    public LocalDateTime  getExitTime() {
        return exitTime;
    }
}
