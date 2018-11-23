package com.futureGadgeLab.dao;

import com.futureGadgeLab.app.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * An implementation of crud methods which connect the database, with the use of a Spring JdbcTemplate.
 * Dependency Injection has been used to establish a connection between the database and the data access object.
 * Used to store and retrieve data from the database
 */

public class JdbcParkingDAO implements ParkingDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public JdbcParkingDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void executeStatement() {
        this.jdbcTemplate.execute("CREATE table Ticket(ticketId integer)");
    }

    @Override
    public Parking createParking(int ticketId) {
        this.jdbcTemplate.update("INSERT INTO Ticket(ticketId, entryTime) VALUES (?, ?)", new Object[]{});
        return new Parking();
    }

    @Override
    public Parking readParking(Integer ticketId) {
        return this.jdbcTemplate.queryForObject("SELECT ticketId, lotId, entryTime, exitTime, fee FROM Ticket WHERE ticketId = ?",
                new Object[]{ticketId}, new ParkingMapper());
    }

    @Override
    public List<Parking> readAllParkings() {
        return this.jdbcTemplate.query("SELECT ticketId, entryTime, exitTime, fee FROM Ticket",
                new ParkingMapper());
    }

    @Override
    public Parking saveParking(Parking parking) {
        this.jdbcTemplate.update("INSERT INTO Ticket(ticketId, entryTime, exitTime, fee) VALUES (?, ?, ?, ?)", new Object[]{});
        return new Parking();
    }

    @Override
    public Parking updateParking(Integer ticketId, Timestamp exitTime, BigDecimal fee) {
        this.jdbcTemplate.update("UPDATE Ticket SET exitTime = ?, fee = ? WHERE ticketId = ?",exitTime ,fee, ticketId) ;
        return new Parking();
    }

    @Override
    public int deleteParking(Integer ticketId) {
        return this.jdbcTemplate.update("DELETE from Ticket WHERE ticketId = ?", new Object[]{});
    }

    @Override
    public void deleteAllParking() {
        this.jdbcTemplate.update("DELETE from Ticket");

    }

    /**
     * An inner-class which has been used to map variables in accordance with ParkingDAO methods
     * ParkingMapper maps the resultSet to a domain object per row
     */

    public class ParkingMapper implements RowMapper<Parking> {

        public Parking mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            Parking result = new Parking();
            result.setTicketId(resultSet.getInt("ticketId"));
            result.setLotId(resultSet.getInt("lotId"));
            result.setEntryTime(resultSet.getTimestamp("entryTime"));
            result.setExitTime(resultSet.getTimestamp("exitTime"));
            result.setFee(resultSet.getBigDecimal("fee"));

            return result;
        }
    }
}