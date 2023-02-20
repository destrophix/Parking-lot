package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;

class ParkingSpotTest {

    @BeforeEach
    void setup() {
        Counter.reset();
    }

    @Test
    void reserveAlreadyReservedSpot() {
        Vehicle firstVehicle = new Vehicle(12, VehicleType.CAR);
        Vehicle secondVehicle = new Vehicle(13, VehicleType.CAR);
        ParkingLot parkingLot = new ParkingLot(List.of(1));
        parkingLot.parkVehicle(firstVehicle);

        ParkingTicket ticket = parkingLot.parkVehicle(secondVehicle);

        assertNull(ticket);
    }

}