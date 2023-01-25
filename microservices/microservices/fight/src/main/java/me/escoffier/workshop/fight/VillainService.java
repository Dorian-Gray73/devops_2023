package me.escoffier.workshop.fight;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@RegisterRestClient(configKey = "supes-villain")
@Produces(MediaType.APPLICATION_JSON)
public interface VillainService {

    @CircuitBreaker(successThreshold = 10, requestVolumeThreshold = 4, failureRatio = 0.75, delay = 1000)
    @Timeout(value = 500)
    @Fallback(fallbackMethod = "getFallbackVillain")
    @Path("/villain")
    @GET
    Villain getVillain();

    default Villain getFallbackVillain() {
        Villain villain = new Villain();
        villain.name = "Hannibal Lecter";
        villain.otherName = "Hannibal the Cannibal";
        villain.level = 45;
        villain.id = (long) 15151;
        villain.picture = "pathToPicture";
        return villain;
    }
}