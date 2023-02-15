package org.example;

public class ParkingSpot {
    private int id;
    Vehicle vehicle;

    void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    void unParkVehicle() {
        this.vehicle = null;
    }

    boolean isEmpty() {
        return vehicle == null;
    }
}
