package org.example.model;

public class ParkingSpot {
    private Vehicle vehicle;
    private final int spotNumber;
    private final int floorNumber;

    public ParkingSpot(int floorNumber) {
        this.floorNumber = floorNumber;
        spotNumber = Counter.generateId();
    }

    boolean isEmpty() {
        return vehicle == null;
    }

    void reserve(Vehicle vehicle) {
        if (!isEmpty()) return;
        this.vehicle = vehicle;
    }

    Vehicle unReserve() {
        Vehicle vehicle = getVehicle();
        this.vehicle = null;
        return vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
