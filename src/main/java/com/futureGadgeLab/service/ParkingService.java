package com.futureGadgeLab.service;

import com.futureGadgeLab.app.Parking;

import java.util.List;

public interface ParkingService {

    Parking createParking();
    Parking readParking(int ticketId);
    List<Parking> readAllParkings();

    Parking saveParking(Parking parking);
    void updateParking(Parking parking);
}
