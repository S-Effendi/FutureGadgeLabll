package com.futureGadgeLab.app;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParkingFee {

    private int ticketId, duration;

    Parking parking;
    Map<Integer, BigDecimal> tariffCategory = new HashMap<>();

    public ParkingFee(Parking parking) {
        this();
        this.parking = parking;
    }

    public ParkingFee(){
        tariffCategory.put(1, BigDecimal.TEN);
        tariffCategory.put(2, BigDecimal.valueOf(20));
        tariffCategory.put(3, BigDecimal.valueOf(30));
        tariffCategory.put(4, BigDecimal.valueOf(50));
        tariffCategory.put(5, BigDecimal.valueOf(100));
    }

    public boolean getTicketId() {

        if (ticketId == parking.getTicketId()){
            return true;
        }
        return false;
    }

    public int getDuration(){

        if (parking.ticketIssued) {

            int entryTimeHour = parking.getEntryTime().getHours();
            int entryTimeMinutes = parking.getEntryTime().getMinutes();
            int exitTimeHour = parking.getExitTime().getHours();
            int exitTimeMinutes = parking.getExitTime().getMinutes();

            entryTimeHour = entryTimeHour * 60;
            exitTimeHour = exitTimeHour * 60;

            int entryTime = entryTimeHour + entryTimeMinutes;
            int exitTime = exitTimeHour + exitTimeMinutes;

            duration = (exitTime - entryTime);
        }
        return duration;
    }

    public BigDecimal getTariff() {

        BigDecimal result;

        if(getDuration() <= 30 && getDuration() > 0) {
            result = tariffCategory.get(1);
        }
        else if(getDuration() <= 60 && getDuration() > 30){
            result = tariffCategory.get(2);
        }
        else if(getDuration() <= 120 && getDuration() > 60) {
            result = tariffCategory.get(3);
        }
        else if(getDuration() <= 240 && getDuration() > 120) {
            result = tariffCategory.get(4);
        }
        else{
            result = tariffCategory.get(5);
        }
        parking.setFee(result);
        return result;
    }
}
