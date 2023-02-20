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

    @Test
    void oldTicketAgain(){
        Vehicle vehicle = new Vehicle(2, VehicleType.CAR);
        ParkingLot parkingLot = new ParkingLot(100);
        ParkingTicket ticket = parkingLot.parkVehicle(vehicle);
        parkingLot.unParkVehicle(ticket, LocalDateTime.now().plusHours(13));

        ParkingReceipt receipt = parkingLot.unParkVehicle(ticket, LocalDateTime.now().plusHours(13));

        assertNull(receipt);

    }

    @Test
    void oldTicketGivenForAlreadyParkedCar(){
        Vehicle firstVehicle = new Vehicle(2, VehicleType.CAR);
        Vehicle secondVehicle = new Vehicle(3, VehicleType.CAR);
        ParkingLot parkingLot = new ParkingLot(100);
        ParkingTicket ticket = parkingLot.parkVehicle(firstVehicle);
        parkingLot.unParkVehicle(ticket, LocalDateTime.now().plusHours(13));
        parkingLot.parkVehicle(secondVehicle);

        ParkingReceipt receipt = parkingLot.unParkVehicle(ticket, LocalDateTime.now().plusHours(13));

        assertNull(receipt);

    }

}