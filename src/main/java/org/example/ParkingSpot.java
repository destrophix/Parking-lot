package org.example;

public class ParkingSpot {
    Vehicle vehicle;
    boolean isEmpty(){
        if(vehicle == null) return true;
        return false;
    }

    void reserve(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    void unreserve(){
        this.vehicle = null;
    }
}
