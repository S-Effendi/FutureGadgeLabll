package com.futureGadgeLab.dao;

import com.futureGadgeLab.app.Parking;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * This defines the methods which be used to interact with the database access objectsS
 */

public interface ParkingDAO {

    public Parking createParking();
    public Parking readParking(Integer ticketId);
    public List<Parking> readAllParkings();
    public Parking saveParking(Parking parking);
    public Parking updateParking(Integer ticketId, Timestamp exitTime, BigDecimal fee);
    public int deleteParking(Integer ticketId);
    public void deleteAllParking();
}
