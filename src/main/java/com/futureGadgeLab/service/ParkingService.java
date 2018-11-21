package com.futureGadgeLab.service;

import com.futureGadgeLab.app.Parking;
import java.util.List;

public interface ParkingService {

    Parking createParking(int ticketId);
    Parking readParking(int ticketId);
    List<Parking> readAllParkings();

    Parking saveParking(Parking parking);
    Parking updateParking(Integer ticketId);
}
