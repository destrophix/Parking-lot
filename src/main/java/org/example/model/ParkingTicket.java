package org.example.model;

import java.time.LocalDateTime;

public class ParkingTicket {
    private final LocalDateTime entryTime;
    private final Vehicle vehicle;
    public int spotNumber;
    public int floorNumber;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot) {
        this.entryTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.spotNumber = spot.getSpotNumber();
        this.floorNumber = spot.getFloorNumber();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

}
