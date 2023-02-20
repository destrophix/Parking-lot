package org.example.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingReceipt {
    private Vehicle vehicle;
    private int amount;

    public ParkingReceipt(Vehicle vehicle, int amount) {
        this.vehicle = vehicle;
        this.amount = amount;
    }

    public int getFees() {
        return amount;
    }


}
