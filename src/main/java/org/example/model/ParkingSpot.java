package org.example.model;

public class ParkingSpot {
    private Vehicle vehicle;
    boolean isEmpty(){
        return vehicle == null;
    }

    void reserve(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    Vehicle unReserve(){
        this.vehicle = null;
        return null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
