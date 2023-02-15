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
    void testMotorcycleParkingAtMall(){
        Map<VehicleType, List<ParkingSpot>> spots= new HashMap<>();
        spots.put(VehicleType.MOTORCYCLE, List.of(new ParkingSpot()));
        ParkingFloor parkingFloor = new ParkingFloor(spots);
        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(parkingFloor);
        Building building = new Building(floors, BuildingType.MALL);
        List<Building> buildings = new ArrayList<>();
        buildings.add(building);
        ParkingLot parkingLot = new ParkingLot(buildings);

        Vehicle vehicle = new Vehicle(1, VehicleType.MOTORCYCLE);

        ParkingSpot parkingSpot = parkingLot.parkVehichle(vehicle);

        assertNotNull(parkingSpot);
    }

    @Test
    void testMotorcycleParkingAtStadium(){
        Map<VehicleType, List<ParkingSpot>> spots= new HashMap<>();
        spots.put(VehicleType.MOTORCYCLE, List.of(new ParkingSpot()));
        ParkingFloor parkingFloor = new ParkingFloor(spots);
        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(parkingFloor);
        Building building = new Building(floors, BuildingType.STADIUM);
        List<Building> buildings = new ArrayList<>();
        buildings.add(building);
        ParkingLot parkingLot = new ParkingLot(buildings);

        Vehicle vehicle = new Vehicle(1, VehicleType.MOTORCYCLE);

        ParkingSpot parkingSpot = parkingLot.parkVehichle(vehicle);

        assertNotNull(parkingSpot);
    }

    @Test
    void testMotorcycleParkingAtAirport(){
        Map<VehicleType, List<ParkingSpot>> spots= new HashMap<>();
        spots.put(VehicleType.MOTORCYCLE, List.of(new ParkingSpot()));
        ParkingFloor parkingFloor = new ParkingFloor(spots);
        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(parkingFloor);
        Building building = new Building(floors, BuildingType.AIRPORT);
        List<Building> buildings = new ArrayList<>();
        buildings.add(building);
        ParkingLot parkingLot = new ParkingLot(buildings);

        Vehicle vehicle = new Vehicle(1, VehicleType.MOTORCYCLE);

        ParkingSpot parkingSpot = parkingLot.parkVehichle(vehicle);

        assertNotNull(parkingSpot);
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

        ParkingSpot parkingSpot = parkingLot.parkVehichle(vehicle);

        assertNotNull(parkingSpot);
    }

    @Test
    void testBusParkingAtMall(){
        Map<VehicleType, List<ParkingSpot>> spots= new HashMap<>();
        spots.put(VehicleType.BUS, List.of(new ParkingSpot()));
        ParkingFloor parkingFloor = new ParkingFloor(spots);
        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(parkingFloor);
        Building building = new Building(floors, BuildingType.MALL);
        List<Building> buildings = new ArrayList<>();
        buildings.add(building);
        ParkingLot parkingLot = new ParkingLot(buildings);

        Vehicle vehicle = new Vehicle(1, VehicleType.BUS);

        ParkingSpot parkingSpot = parkingLot.parkVehichle(vehicle);

        assertNotNull(parkingSpot);
    }

}