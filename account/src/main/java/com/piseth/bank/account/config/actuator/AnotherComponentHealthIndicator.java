package com.piseth.bank.account.config.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class AnotherComponentHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // Custom health check logic for another component
        boolean error = checkForErrors();
        if (error) {
            return Health.down().withDetail("Error Code", 5678).build();
        }
        return Health.up().build();
    }

    private boolean checkForErrors() {
        // Implement your custom logic to determine health status
        return false; // return true if there's an error
    }
}