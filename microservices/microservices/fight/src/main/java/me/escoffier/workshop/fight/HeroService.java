package me.escoffier.workshop.fight;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "supes-hero")
@Produces(MediaType.APPLICATION_JSON)
public interface HeroService {

    @Path("/hero")
    @GET
    Personnage getHero();

}