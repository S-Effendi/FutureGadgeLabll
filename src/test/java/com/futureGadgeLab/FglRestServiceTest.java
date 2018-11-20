package com.futureGadgeLab;

import com.futureGadgeLab.rest.FglRestService;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.jboss.resteasy.plugins.server.resourcefactory.POJOResourceFactory;
import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

public class FglRestServiceTest {
    private static Dispatcher dispatcher;
    private static POJOResourceFactory noDefaults;

    @BeforeClass
    public static void setup() {
        dispatcher = MockDispatcherFactory.createDispatcher();
        noDefaults = new POJOResourceFactory(FglRestService.class);
        dispatcher.getRegistry().addResourceFactory(noDefaults);
    }

    @Test
    public void fglTest(){
        try {
            MockHttpRequest request = MockHttpRequest.get("/Future Gadget Laboratory");
            MockHttpResponse response = new MockHttpResponse();

            dispatcher.invoke(request, response);

            Assert.assertEquals(Response.Status.OK.getStatusCode(),
                    response.getStatus());
            Assert.assertEquals("hello", response.getContentAsString());
        }
        catch (URISyntaxException e){
            e.printStackTrace();
        }
    }
}