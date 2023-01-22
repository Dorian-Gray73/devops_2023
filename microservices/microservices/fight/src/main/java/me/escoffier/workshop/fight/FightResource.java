package me.escoffier.workshop.fight;

import org.jboss.logging.Logger;
import org.eclipse.microprofile.rest.client.inject.RestClient;

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
    @Inject @RestClient HeroService heroService;
    @Inject @RestClient VillainService villainService;
    @GET
    @Path("/heroes/random")
    public Personnage getRandomHero() {
        Personnage hero = heroService.getHero();
        LOGGER.debug("Found random hero " + hero);
        return hero;
    }

    @GET
    @Path("/villains/random")
    public Personnage getRandomVillain() {
        Personnage villain = villainService.getVillain();
        LOGGER.debug("Found random villain " + villain);
        return villain;
    }

    @GET
    @Path("/fight")
    public Fight fight() {
        System.out.println("Un truc");
        return fight(
                getRandomHero(),
                getRandomVillain()
        );
    }

    private final Random random = new Random();

    private Fight fight(Personnage hero, Personnage villain) {
        int heroAdjust = random.nextInt(20);
        int villainAdjust = random.nextInt(20);

        if ((hero.realStreng(heroAdjust)) >= (villain.realStreng(villainAdjust))) {
            return new Fight(hero, villain, hero.getName());
        } else {
            return new Fight(hero, villain, villain.getName());
        }
    }

}
