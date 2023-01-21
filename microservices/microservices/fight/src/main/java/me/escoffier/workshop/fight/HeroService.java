package me.escoffier.workshop.fight;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "hero-service")
@Produces(MediaType.TEXT_PLAIN)
public interface HeroService {

    @Path("/hero")
    @GET
    Personnage getHero();

}