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

    public FglRestService() {

    }

    public FglRestService(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    public void setParkingService(String parkingService) {
    }

    @Path("/parking")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Parking createParking(int ticketId) {
        return parkingService.createParking(ticketId);
    }

    @Path("/parking/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Parking readParking(@PathParam("id") int ticketId){
        return parkingService.readParking(ticketId);
    }

    @Path("/parking")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Parking> readAllParkings(){
        return parkingService.readAllParkings();
    }

    @Path("/parking")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Parking saveParking(Parking parking) {
        return parkingService.saveParking(parking);
    }

    @Path("/parking")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Parking updateParking(int ticketId) {
        return parkingService.updateParking(ticketId);
    }

//    @Path("/fgl")
//    @GET
//    public Response fgl() {
//        return Response.status(200).entity("Future Gadget Lab").build();
//    }

}
