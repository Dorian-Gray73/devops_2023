package me.escoffier.workshop.fight;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class FightResource {

    private static final Logger LOGGER = Logger.getLogger(FightResource.class);
    @Inject
    @RestClient
    HeroService heroService;
    @Inject
    @RestClient
    VillainService villainService;

    public Hero getRandomHero() {
        Hero hero = heroService.getHero();
        LOGGER.debug("Found random hero " + hero);
        return hero;
    }

    public Villain getRandomVillain() {
        Villain villain = villainService.getVillain();
        LOGGER.debug("Found random villain " + villain);
        return villain;
    }

    @GET
    @Counted("supes-fight.fight.invocations")
    @Timed("supes-fight.fight.time")
    @Path("/fight")
    public Fight fight() {
        return fight(
                getRandomHero(),
                getRandomVillain());
    }

    private final Random random = new Random();

    private Fight fight(Hero hero, Villain villain) {
        int heroAdjust = random.nextInt(20);
        int villainAdjust = random.nextInt(20);

        if ((hero.level + heroAdjust) >= (villain.level + villainAdjust)) {
            return new Fight(hero, villain, hero.name);
        } else {
            return new Fight(hero, villain, villain.name);
        }
    }
}
