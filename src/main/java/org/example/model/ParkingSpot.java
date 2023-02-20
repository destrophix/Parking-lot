package org.example.model;

public class ParkingSpot {
    private Vehicle vehicle;
    private final int spotNumber;
    private int floorNumber;

    public ParkingSpot(int floorNumber){
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

    void unReserve() {
        if (isEmpty()) return;
        this.vehicle = null;
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
