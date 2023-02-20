package org.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final List<ParkingSpot> parkingSpots;

    public ParkingLot(int numberOfSpots) {
        parkingSpots = new ArrayList<>(numberOfSpots);
        for (int index = 0; index < numberOfSpots; index++) {
            parkingSpots.add(new ParkingSpot());
        }
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        if (!ifSpotAvailable()) {
            return null;
        }
        int spotNumber = reserveSpot(vehicle);
        return new ParkingTicket(vehicle, spotNumber);

    }


    public ParkingReceipt unParkVehicle(ParkingTicket ticket, LocalDateTime exitTime) {
        Vehicle vehicle = unReserveSpot(ticket);
        if (vehicle == null) return null;
        return new ParkingReceipt(ticket, exitTime);
    }

    boolean ifSpotAvailable() {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isEmpty()) return true;
        }
        return false;
    }

    int getAvailableSpot() {
        for (int spotNumber = 0; spotNumber < parkingSpots.size(); spotNumber++) {
            if (parkingSpots.get(spotNumber).isEmpty()) return spotNumber;
        }
        return -1;
    }

    int reserveSpot(Vehicle vehicle) {
        int spotNumber = getAvailableSpot();
        parkingSpots.get(spotNumber).reserve(vehicle);
        return spotNumber;
    }

    Vehicle unReserveSpot(ParkingTicket ticket) {
        ParkingSpot spot = parkingSpots.get(ticket.getSpotId());
        Vehicle vehicleParkedAtSpot = spot.getVehicle();
        Vehicle vehicleMentionedInTicket = ticket.getVehicle();
        if (spot.isEmpty() || vehicleParkedAtSpot.getId() != vehicleMentionedInTicket.getId()) return null;
        spot.unReserve();
        return vehicleParkedAtSpot;
    }

}
