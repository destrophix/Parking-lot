package org.example;

import org.example.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ParkingReceiptTest {

    @Test
    void calculateFeeForCar() {
        Vehicle vehicle = new Vehicle(1, VehicleType.CAR);
        ParkingTicket ticket = new ParkingTicket(vehicle, new ParkingSpot(0));

        ParkingReceipt receipt = new ParkingReceipt(ticket.getEntryTime(), LocalDateTime.now().plusHours(10));

        assertEquals(100, receipt.getFees());
    }


}