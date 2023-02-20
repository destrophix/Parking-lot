package org.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final List<ParkingSpot> parkingSpots;

    public ParkingLot(List<Integer> floorList) {
        parkingSpots = new ArrayList<>();
        for (int floorNumber = 0; floorNumber < floorList.size(); floorNumber++) {
            int numberOfSpots = floorList.get(floorNumber);
            for(int index = 0; index < numberOfSpots; index++){
                parkingSpots.add(new ParkingSpot(floorNumber));
            }
        }
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        if (!ifSpotAvailable()) {
            return null;
        }
        ParkingSpot spot = reserveSpot(vehicle);
        return new ParkingTicket(vehicle, spot);

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

    ParkingSpot getAvailableSpot() {
        for (ParkingSpot spot: parkingSpots) {
            if (spot.isEmpty()) return spot;
        }
        return null;
    }

    ParkingSpot reserveSpot(Vehicle vehicle) {
        ParkingSpot spot = getAvailableSpot();
        spot.reserve(vehicle);
        return spot;
    }

    Vehicle unReserveSpot(ParkingTicket ticket) {
        ParkingSpot spot = parkingSpots.get(ticket.getSpotNumber());
        Vehicle vehicleParkedAtSpot = spot.getVehicle();
        Vehicle vehicleMentionedInTicket = ticket.getVehicle();
        if (spot.isEmpty() || vehicleParkedAtSpot.getId() != vehicleMentionedInTicket.getId()) return null;
        spot.unReserve();
        return vehicleParkedAtSpot;
    }

}
