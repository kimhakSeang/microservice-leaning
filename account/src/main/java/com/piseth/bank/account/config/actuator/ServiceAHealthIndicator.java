package com.piseth.bank.account.config.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

//@Component
public class ServiceAHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // Custom health check logic for Service A
        boolean isHealthy = checkServiceA();
        if (isHealthy) {
            return Health.up().withDetail("status", "Service A is up").build();
        } else {
            return Health.down().withDetail("status", "Service A is down").build();
        }
    }

    private boolean checkServiceA() {
        // Implement your custom logic to determine the health of Service A
        return false; // Example: return true if healthy, false otherwise
    }
}