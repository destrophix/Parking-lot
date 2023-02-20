package org.example.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class FlatFee {
    static public int calculateFee(LocalDateTime entryTime, LocalDateTime exitTime) {
        int hours = (int) Duration.between(entryTime, exitTime).toHours();
        return hours * 10;
    }
}
