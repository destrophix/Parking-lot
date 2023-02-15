package org.example;

import java.time.LocalDateTime;

public class ParkingTicket {
    private final LocalDateTime entryTime;
    private final VehicleType vehicleType;
    private final BuildingType buildingType;

    public ParkingTicket(LocalDateTime entryTime, VehicleType vehicleType, BuildingType buildingType) {
        this.entryTime = entryTime;
        this.vehicleType = vehicleType;
        this.buildingType = buildingType;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public LocalDateTime getEntryTime(){
        return entryTime;
    }

    public BuildingType getBuildingType(){
        return buildingType;
    }
}
