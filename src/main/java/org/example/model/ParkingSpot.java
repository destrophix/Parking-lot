package org.example.model;

public class ParkingSpot {
    private Vehicle vehicle;

    boolean isEmpty() {
        return vehicle == null;
    }

    void reserve(Vehicle vehicle) {
        if (!isEmpty()) return;
        this.vehicle = vehicle;
    }

    void unReserve() {
        if (isEmpty()) return;
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
