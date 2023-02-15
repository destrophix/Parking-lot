package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
public class ParkingReceipt {
    private final ParkingTicket parkingTicket;
    private final LocalDateTime exitTime;
    private int amount = 0;
    public ParkingReceipt(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
        this.exitTime = LocalDateTime.now();
        calculateFee(parkingTicket.getBuildingType());
    }

    public int getFees(){
        return amount;
    }

    private void calculateFee(BuildingType buildingType){
        VehicleType type = parkingTicket.getVehicleType();
        int hours = (int) Duration.between(parkingTicket.getEntryTime(), exitTime).toHours();
        if(buildingType.equals(BuildingType.MALL)) {
            calculateFeeForMallParking(type, hours);
        } else if(buildingType.equals(BuildingType.STADIUM)) {
            calculateFeeForStadiumParking(type, hours);
        } else {
            calculateFeeForAirportParking(type, hours);
        }
    }

    private void calculateFeeForMallParking(VehicleType type, int hours){
        if(type.equals(VehicleType.MOTORCYCLE)){
            amount = hours * 10;
        }else if(type.equals(VehicleType.CAR)){
            amount = hours * 20;
        }else {
            amount = hours * 50;
        }

    }

    private void calculateFeeForStadiumParking(VehicleType type, int hours){
        if(type.equals(VehicleType.MOTORCYCLE)){
            System.out.println("motorcycle in stadium "+ hours);
            if(hours <= 4){
                amount = hours * 30;
            }else if(hours <= 12){
                amount = 4 * 30 + (hours-4)*60;
            }else{
                amount = 4 * 30 + 8 * 60 + (hours - 12)*100;
            }
        }else if(type.equals(VehicleType.CAR)){
            if(hours <= 4){
                amount = hours * 60;
            }else if(hours <= 12){
                amount = 4 * 60 + (hours-4)*120;
            }else{
                amount = 4 * 60 + 8 * 120 + (hours - 12)*200;
            }

        }
    }

    private void calculateFeeForAirportParking(VehicleType type, int hours){
        if(hours <= 1) return;

        if(type.equals(VehicleType.MOTORCYCLE)){
            if(hours <= 8){
                amount = hours * 40;
            }else if(hours <= 24){
                amount = hours * 60;
            }else{
                amount = (int)Math.ceil((double)hours/24)*80 - 20;
            }
        }else if(type.equals(VehicleType.CAR)){
            if(hours <= 12){
                amount = hours * 60;
            }else if(hours <= 24){
                amount = hours * 80;
            }else{
                amount = (int)Math.ceil((double)hours/24)*100 - 20;
            }
        }

    }
}
