package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @AfterEach
    void setup(){

    }


    @Test
    void parkCar(){
        Vehicle vehicle = new Vehicle(1, VehicleType.CAR);
        ParkingLot parkingLot = new ParkingLot(100);

        ParkingTicket ticket = parkingLot.parkVehicle(vehicle);

        assertEquals(0, ticket.getSpotId());
        assertEquals(vehicle, ticket.getVehicle());
    }

    void unparkCar(){
        Vehicle vehicle = new Vehicle(2, VehicleType.CAR);
        ParkingLot parkingLot = new ParkingLot(100);
        ParkingTicket ticket = parkingLot.parkVehicle(vehicle);

        ParkingReceipt receipt = parkingLot.unparkVehicle(ticket, LocalDateTime.now().plusHours(13));

        assertEquals(130, receipt.getFees());

    }

}