package org.example;

import java.time.LocalDateTime;

public class ParkingAttendant {
    private final int id;
    private final BuildingType location;

    ParkingAttendant(int id, BuildingType location) {
        this.id = id;
        this.location = location;
    }

    ParkingTicket generateTicket(Vehicle vehicle) {
        return new ParkingTicket(LocalDateTime.now(), vehicle.getType(), location);
    }

    ParkingReceipt generateReceipt(ParkingTicket parkingTicket) {
        return new ParkingReceipt(parkingTicket);
    }
}
