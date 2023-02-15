package org.example;

import java.util.List;

public class Building {
    private final List<ParkingFloor> floors;
    private final BuildingType buildingType;

    public Building(List<ParkingFloor> floors, BuildingType buildingType) {
        this.floors = floors;
        this.buildingType = buildingType;
    }

    public boolean hasSlotAvailabe(Vehicle vehicle) {
        for (ParkingFloor parkingFloor : floors) {

            if (parkingFloor.hasSlotAvailable(vehicle)) return true;
        }
        return false;
    }

    public ParkingSpot parkVehichle(Vehicle vehicle) {
        ParkingSpot parkingSpot = null;
        for (ParkingFloor floor : floors) {
            parkingSpot = floor.parkVehicle(vehicle);
            break;
        }
        return parkingSpot;
    }

    public Vehicle unParkVehicle(ParkingSpot parkingSpot) {
        Vehicle vehicle = null;
        for (ParkingFloor floor : floors) {
            vehicle = floor.unParkVehicle(parkingSpot);
            break;
        }
        return vehicle;
    }

    public boolean allowsParkingTo(Vehicle vehicle) {
        return !vehicle.getType().equals(VehicleType.BUS) || buildingType.equals(BuildingType.MALL);
    }


}
