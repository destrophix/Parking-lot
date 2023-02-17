package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ParkingReceiptTest {

    @Test
    void testMallParkingReceipt (){
        ParkingTicket ticket = new ParkingTicket(LocalDateTime.now().minusHours(5), VehicleType.MOTORCYCLE, BuildingType.MALL);

        ParkingReceipt parkingReceipt = new ParkingReceipt(ticket);

        assertEquals(10, parkingReceipt.getFees());
    }

    @Test
    void testStadiumParkingReceipt (){
        ParkingTicket ticket = new ParkingTicket(LocalDateTime.now().minusDays(1), VehicleType.MOTORCYCLE, BuildingType.STADIUM);

        ParkingReceipt parkingReceipt = new ParkingReceipt(ticket);

        assertEquals(1800, parkingReceipt.getFees());
    }

    @Test
    void testAirportParkingReceipt (){
        ParkingTicket ticket = new ParkingTicket(LocalDateTime.now().minusDays(1), VehicleType.MOTORCYCLE, BuildingType.AIRPORT);

        ParkingReceipt parkingReceipt = new ParkingReceipt(ticket);

        assertEquals(1440, parkingReceipt.getFees());
    }
}