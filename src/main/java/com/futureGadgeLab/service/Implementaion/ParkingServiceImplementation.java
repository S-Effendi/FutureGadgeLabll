package com.futureGadgeLab.service.Implementaion;

import com.futureGadgeLab.app.Parking;
import com.futureGadgeLab.app.ParkingFee;
import com.futureGadgeLab.dao.JdbcParkingDAO;
import com.futureGadgeLab.service.ParkingService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class ParkingServiceImplementation implements ParkingService {

    private JdbcParkingDAO jdbcParkingDAO;

    private ParkingFee parkingFee;

    public ParkingServiceImplementation() {
    }

    public ParkingServiceImplementation(JdbcParkingDAO jdbcParkingDAO) {
        this.jdbcParkingDAO = jdbcParkingDAO;
    }

    public void setJdbcParkingDao(JdbcParkingDAO jdbcParkingDao) {
    }

    public void setParkingFee(ParkingFee parkingFee) {
        this.parkingFee = parkingFee;
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
    public void updateParking(Parking parking) {
        BigDecimal fee = parkingFee.getTariff();
        Timestamp exitTime = new Timestamp(parking.getExitTime().getTime());
        jdbcParkingDAO.updateParking(parking.getTicketId(), exitTime, fee);
    }
}
