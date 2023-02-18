package org.example.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingReceipt {
    private final LocalDateTime exitTime;
    private int amount = 0;

    public ParkingReceipt(ParkingTicket parkingTicket, LocalDateTime exitTime) {
        this.exitTime = exitTime;
        calculateFee(parkingTicket);
    }

    public int getFees() {
        return amount;
    }

    private void calculateFee(ParkingTicket parkingTicket) {
        int hours = (int) Duration.between(parkingTicket.getEntryTime(), exitTime).toHours();
        amount = hours * 10;
    }


}
