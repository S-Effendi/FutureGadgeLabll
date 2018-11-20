package com.futureGadgeLab.app;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingValidation
{

    private Boolean spaceAvailability = false;
    private int availableSpaces, currentLotId = 1;

    private AtomicInteger parkingLots = new AtomicInteger (5);

    Parking parking;

    public ParkingValidation(Parking parking) {
        this.parking = parking;
    }


    public Boolean getSpaceAvailability() {
        if(getAvailableLots() == 1 && availableSpaces == 50)
            spaceAvailability = true;
        return spaceAvailability;
    }

    public int getAvailableLots() {

        currentLotId = parking.getLotId(currentLotId);

        if (currentLotId == 1) {
            availableSpaces = 50;
        } else if (currentLotId == 1 && availableSpaces == 0) {

            currentLotId++;
            availableSpaces = 50;
            parking.getLotId(currentLotId);
        } else {
            currentLotId = parkingLots.getAndIncrement();
        }
        parking.setLotId(currentLotId);
        return currentLotId;
    }

    public int getAvailableSpaces () {

        if(getSpaceAvailability()== true && availableSpaces == 50) {
            if (parking.ticketIssued == true){
                availableSpaces--;
            }
        }
        return availableSpaces;
    }
}