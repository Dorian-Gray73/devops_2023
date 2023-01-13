package me.escoffier.workshop.fight;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.temporal.ChronoUnit;

@RegisterRestClient(configKey = "villain-service")
@Produces(MediaType.TEXT_PLAIN)
public interface VillainService {

    @Path("/villain")
    @GET
    Villain getVillain();

}