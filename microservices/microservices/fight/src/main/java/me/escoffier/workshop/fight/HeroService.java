package me.escoffier.workshop.fight;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "supes-hero")
@Produces(MediaType.APPLICATION_JSON)
public interface HeroService {

    @CircuitBreaker(successThreshold = 10, requestVolumeThreshold = 4, failureRatio = 0.75, delay = 1000)
    @Timeout(value = 500)
    @Fallback(fallbackMethod = "getFallbackHero")
    @Path("/hero")
    @GET
    Hero getHero();

    default Hero getFallbackHero() {
        Hero hero = new Hero();
        hero.name = "Elizabeth Keen";
        hero.otherName = "Elizabeth Keen";
        hero.level = 45;
        hero.id = (long) 56548;
        hero.picture = "https://github.com/Dorian-Gray73/devops_2023/blob/liveness/microservices/microservices/fight/src/main/resources/images/Liz.jpg?raw=true";
        return hero;
    }
}