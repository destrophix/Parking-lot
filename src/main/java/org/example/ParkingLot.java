package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingLot {
    private final List<ParkingSpot> parkingSpots;

    ParkingLot(int numberOfSpots){
        parkingSpots = new ArrayList<>(100);
        for(int index = 0; index< 100; index++){
            parkingSpots.add(new ParkingSpot());
        }
    }

    ParkingTicket parkVehicle(Vehicle vehicle) {
        System.out.println(parkingSpots.size());
        if(!ifSpotAvailable()){
            return null;
        }

        int spotNumber = reserveSpot(vehicle);
        return new ParkingTicket(vehicle, spotNumber);

    }


    ParkingReceipt unparkVehicle(ParkingTicket ticket, LocalDateTime exitTime) {
        unreserveSpot(ticket.getSpotId());
        return new ParkingReceipt(ticket, exitTime);
    }

    boolean ifSpotAvailable(){
        for(ParkingSpot spot: parkingSpots){
            if(spot.isEmpty()){
                return true;
            }
        }
        return false;
    }

    int getAvailableSpot(){
        for(int spotNumber = 0; spotNumber< parkingSpots.size(); spotNumber++){
            if(parkingSpots.get(spotNumber).isEmpty()){
                return spotNumber;
            }
        }
        return -1;
    }

    int reserveSpot(Vehicle vehicle){
        int spotNumber = getAvailableSpot();
        parkingSpots.get(spotNumber).reserve(vehicle);
        return spotNumber;
    }

    void unreserveSpot(int spotNumber){
        parkingSpots.get(spotNumber).unreserve();
    }

}
