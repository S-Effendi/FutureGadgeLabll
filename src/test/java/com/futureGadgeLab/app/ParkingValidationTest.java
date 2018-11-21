package com.futureGadgeLab.app;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ParkingValidationTest {

    private Parking parking;
    private ParkingValidation parkingValidation;

    /**
     *
     * @throws Exception
     * Tickets Issued must be true in order for spaceAvailability test to pass
     */

    @Before
    public void setUp() throws Exception {
        parking = new Parking();
        parkingValidation = new ParkingValidation(parking);
    }

    @Test
    public void testParkingAvailability() {
        Boolean result = parkingValidation.getSpaceAvailability();

        assertTrue("There are no parking spaces available", result);
    }


    @Test
    public void testAvailableLots(){
        int result = parkingValidation.getAvailableLots();

        assertEquals(1, result);
    }

    @Test
    public void testAvailableSpaces(){
        int result = parkingValidation.getAvailableSpaces();

        assertEquals(49, result);
    }

    @Test
    public void testNumberOfParkingSpaces(){
        int parkingSpaces;

        parkingSpaces = parkingValidation.getAvailableSpaces();

        assertEquals(parkingSpaces, parkingValidation.getAvailableSpaces());
    }
}
