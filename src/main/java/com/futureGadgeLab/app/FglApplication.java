package com.futureGadgeLab.app;

import com.futureGadgeLab.dao.JdbcParkingDAO;
import com.futureGadgeLab.rest.FglRestService;
import com.futureGadgeLab.service.Implementaion.ParkingServiceImplementation;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Sets and instance of a object which will be reused by the rest service
 */

public class FglApplication  extends Application{
    private Set<Object> s_instance = new HashSet<Object>();

    public FglApplication() {


//        List<String> myList = new ArrayList<>();
//        new ArrayList<String>() myList;

        s_instance.add(new FglRestService(new ParkingServiceImplementation(new JdbcParkingDAO())));
    }

    @Override
    public Set<Object> getSingletons() {
        return s_instance;
    }
}
