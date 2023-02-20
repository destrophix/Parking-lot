package org.example;

import org.example.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FlatFeeTest {

    @Test
    void calculateFeeForCar() {
        LocalDateTime entryTime = LocalDateTime.now().minusHours(10);
        LocalDateTime exitTime = LocalDateTime.now();

        int amount = FlatFee.calculateFee(entryTime, exitTime);

        assertEquals(100, amount);
    }
}