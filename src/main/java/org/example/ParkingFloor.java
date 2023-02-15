package org.example;

import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private final Map<VehicleType, List<ParkingSpot>> spots;

    public ParkingFloor(Map<VehicleType, List<ParkingSpot>> spots) {
        this.spots = spots;
    }


    public boolean hasSlotAvailable(Vehicle vehicle) {
        System.out.println(spots.toString());
        for (ParkingSpot spot : spots.get(vehicle.getType())) {
            if (spot.isEmpty()) return true;
        }
        return false;
    }

    ParkingSpot parkVehicle(Vehicle vehicle) {

        for (ParkingSpot spot : spots.get(vehicle.getType())) {
            if (spot.isEmpty()) {
                spot.parkVehicle(vehicle);
                return spot;
            }
        }
        return null;
    }

    Vehicle unParkVehicle(ParkingSpot parkingSpot) {
        Vehicle vehicle = parkingSpot.vehicle;
        for (ParkingSpot spot : spots.get(vehicle.getType())) {
            if (spot == parkingSpot) {
                spot.unParkVehicle();
                return vehicle;
            }
        }
        return null;
    }
}
