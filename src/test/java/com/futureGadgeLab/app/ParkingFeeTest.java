package com.futureGadgeLab.app;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class ParkingFeeTest {

    private Parking parking;
    private ParkingFee parkingFee;

    @Before
    public void setUp() throws Exception {
        parking = new Parking();
        parkingFee = new ParkingFee(parking);
    }

    @Ignore
    @Test
    public void testDuration(){
        int result = parkingFee.getDuration();
        Assert.assertEquals(" ", result);
    }

    @Test
    public void testCategoryOneCharge(){

        BigDecimal result = parkingFee.getTariff();

        assertEquals(result, parking.getFee()); //50(duration)
    }
}