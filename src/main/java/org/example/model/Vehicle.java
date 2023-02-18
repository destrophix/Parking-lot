package org.example.model;

public class Vehicle {
    private final int id;
    private final VehicleType type;

    public Vehicle(int id, VehicleType type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }
}
