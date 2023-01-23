package me.escoffier.workshop.fight;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@RegisterRestClient(configKey = "supes-villain")
@Produces(MediaType.APPLICATION_JSON)
public interface VillainService {

    @Path("/villain")
    @GET
    Villain getVillain();

}