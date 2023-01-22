package me.escoffier.workshop.fight;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@RegisterRestClient(configKey = "supes-hero")
@Produces(MediaType.TEXT_PLAIN)
public interface HeroService {

    @Path("/hero")
    @GET
    Hero getHero();

}