package org.example.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingReceipt {
    private final LocalDateTime exitTime;
    private int amount = 0;

    public ParkingReceipt(LocalDateTime entryTime, LocalDateTime exitTime) {
        this.exitTime = exitTime;
        calculateFee(entryTime);
    }

    public int getFees() {
        return amount;
    }

    private void calculateFee(LocalDateTime entryTime) {
        int hours = (int) Duration.between(entryTime, exitTime).toHours();
        amount = hours * 10;
    }


}
