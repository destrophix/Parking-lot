package org.example;

import org.example.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void parkCar(){
        Vehicle vehicle = new Vehicle(1, VehicleType.CAR);
        ParkingLot parkingLot = new ParkingLot(100);

        ParkingTicket ticket = parkingLot.parkVehicle(vehicle);

        assertEquals(0, ticket.getSpotId());
        assertEquals(vehicle, ticket.getVehicle());
    }
    @Test
    void unParkCar(){
        Vehicle vehicle = new Vehicle(2, VehicleType.CAR);
        ParkingLot parkingLot = new ParkingLot(100);
        ParkingTicket ticket = parkingLot.parkVehicle(vehicle);

        ParkingReceipt receipt = parkingLot.unParkVehicle(ticket, LocalDateTime.now().plusHours(13));

        assertEquals(130, receipt.getFees());

    }

}