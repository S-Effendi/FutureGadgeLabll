package com.futureGadgeLab.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class FglRestService {
    @GET
    @Path("/fgl")
    public Response fgl() {
        return Response.status(200).entity("Future Gadget Lab").build();
    }
}
