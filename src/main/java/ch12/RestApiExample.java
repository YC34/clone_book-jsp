package ch12;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/test")
public class RestApiExample {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(){
        return "Hello Api Service";
    }

    @POST
    public String sayHello(@QueryParam("msg") String msg){
        return msg+" API Service";
    }

}
