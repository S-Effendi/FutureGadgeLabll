package com.futureGadgeLab.service.Implementaion;

import com.futureGadgeLab.app.Parking;
import com.futureGadgeLab.dao.JdbcParkingDAO;
import com.futureGadgeLab.service.ParkingService;

import java.util.List;

public class ParkingServiceImplementation implements ParkingService {

    private JdbcParkingDAO jdbcParkingDAO;

    public ParkingServiceImplementation(JdbcParkingDAO jdbcParkingDAO) {
        this.jdbcParkingDAO = jdbcParkingDAO;
    }

    @Override
    public Parking createParking(int ticketId) {
        return jdbcParkingDAO.createParking(ticketId);
    }

    @Override
    public Parking readParking(int ticketId) {
        return this.jdbcParkingDAO.readParking(ticketId);
    }

    @Override
    public List<Parking> readAllParkings() {
        return jdbcParkingDAO.readAllParkings();
    }

    @Override
    public Parking saveParking(Parking parking) {
        return jdbcParkingDAO.saveParking(parking);
    }

    @Override
    public Parking updateParking(Integer ticketId) {
        return jdbcParkingDAO.updateParking(ticketId);
    }

}
