package me.escoffier.workshop.fight;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
        villain.level = 50;
        villain.id = (long) 15151;
        villain.picture = "https://github.com/Dorian-Gray73/devops_2023/blob/liveness/microservices/microservices/fight/src/main/resources/images/Hannibal_Lecter_in_Silence_of_the_Lambs.jpg?raw=true";
        return villain;
    }
}