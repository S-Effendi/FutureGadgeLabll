package com.futureGadgeLab.app;

import com.futureGadgeLab.rest.FglRestService;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Sets and instance of a object which will be reused by the rest service
 */

public class FglApplication  extends Application{
    private Set<Object> s_instance = new HashSet<Object>();

    public FglApplication() {
        s_instance.add(new FglRestService());
    }

    @Override
    public Set<Object> getSingletons() {
        return s_instance;
    }
}
