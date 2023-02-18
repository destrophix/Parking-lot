package org.example;

import java.time.LocalDateTime;

public class ParkingTicket {
    private final LocalDateTime entryTime;
    private final Vehicle vehicle;
    public int spotId;

    public ParkingTicket(Vehicle vehicle, int spotId) {
        this.entryTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.spotId = spotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public int getSpotId() {
        return spotId;
    }

}
