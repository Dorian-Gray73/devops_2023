package me.escoffier.workshop.supes;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness // Contribute to the liveness check
public class HealthCheckVillain implements HealthCheck { // Implement health check
    @Override
    public HealthCheckResponse call() { // Implementation of the check
        return HealthCheckResponse.up("Tout va bien");
    }
}