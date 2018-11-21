package com.futureGadgeLab.rest;

import com.futureGadgeLab.app.Parking;
import com.futureGadgeLab.dao.JdbcParkingDAO;
import com.futureGadgeLab.service.ParkingService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class FglRestService {

    private ParkingService parkingService;
    private JdbcParkingDAO jdbcParkingDAO;

    public FglRestService(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Parking createParking(int ticketId) {
        return parkingService.createParking(ticketId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Parking readParking(int ticketId){
        return parkingService.readParking(ticketId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Parking> readAllParkings(){
        return parkingService.readAllParkings();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Parking saveParking(Parking parking) {
        return parkingService.saveParking(parking);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Parking updateParking(int ticketId) {
        return parkingService.updateParking(ticketId);
    }

//    @Path("/fgl")
//    @GET
//    public Response fgl() {
//        return Response.status(200).entity("Future Gadget Lab").build();
//    }

}
