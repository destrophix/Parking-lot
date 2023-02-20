package org.example;

import org.example.model.ParkingReceipt;
import org.example.model.ParkingTicket;
import org.example.model.Vehicle;
import org.example.model.VehicleType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ParkingReceiptTest {

    @Test
    void calculateFeeForCar(){
        Vehicle vehicle = new Vehicle(1, VehicleType.CAR);
        ParkingTicket ticket = new ParkingTicket(vehicle,1);

        ParkingReceipt receipt = new ParkingReceipt(ticket, LocalDateTime.now().plusHours(10));

        assertEquals(100, receipt.getFees());
    }


}