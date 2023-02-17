package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @BeforeEach
    void setup(){

    }

    @Test
    void testCarParkingAtMall(){
        Map<VehicleType, List<ParkingSpot>> spots= new HashMap<>();
        spots.put(VehicleType.CAR, List.of(new ParkingSpot()));
        ParkingFloor parkingFloor = new ParkingFloor(spots);
        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(parkingFloor);
        Building building = new Building(floors, BuildingType.MALL);
        List<Building> buildings = new ArrayList<>();
        buildings.add(building);
        ParkingLot parkingLot = new ParkingLot(buildings);

        Vehicle vehicle = new Vehicle(1, VehicleType.CAR);

        ParkingSpot parkingSpot = parkingLot.parkVehicle(vehicle);

        assertNotNull(parkingSpot);
    }

    @Test
    void unParkCarAtMall(){
        Map<VehicleType, List<ParkingSpot>> spots= new HashMap<>();
        spots.put(VehicleType.CAR, List.of(new ParkingSpot()));
        ParkingFloor parkingFloor = new ParkingFloor(spots);
        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(parkingFloor);
        Building building = new Building(floors, BuildingType.MALL);
        List<Building> buildings = new ArrayList<>();
        buildings.add(building);
        ParkingLot parkingLot = new ParkingLot(buildings);

        Vehicle vehicle = new Vehicle(1, VehicleType.CAR);

        ParkingSpot parkingSpot = parkingLot.parkVehicle(vehicle);
        parkingLot.unParkVehicle(parkingSpot);

        assertTrue(parkingSpot.isEmpty());
    }

}