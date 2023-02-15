package org.example;

import java.util.List;

public class ParkingLot {
    private final List<Building> buildings;

    public ParkingLot(List<Building> buildings) {
        this.buildings = buildings;
    }

    ParkingSpot parkVehichle(Vehicle vehicle) {
        ParkingSpot parkingSpot = null;
        for (Building building : buildings) {

            if (building.allowsParkingTo(vehicle) && building.hasSlotAvailabe(vehicle)) {
                parkingSpot = building.parkVehichle(vehicle);
                break;
            }
        }
        return parkingSpot;
    }

    Vehicle unParkVehichle(ParkingSpot parkingSpot) {
        Vehicle vehicle = null;
        for (Building building : buildings) {
            vehicle = building.unParkVehicle(parkingSpot);
            if (vehicle != null) break;
        }
        return vehicle;
    }

}
