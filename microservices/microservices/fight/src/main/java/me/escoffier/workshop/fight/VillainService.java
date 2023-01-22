package me.escoffier.workshop.fight;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "supes-vilain")
@Produces(MediaType.APPLICATION_JSON)
public interface VillainService {

    @Path("/villain")
    @GET
    Personnage getVillain();

}