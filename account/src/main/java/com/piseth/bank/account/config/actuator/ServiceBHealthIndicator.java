package com.piseth.bank.account.config.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

//@Component
public class ServiceBHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // Custom health check logic for Service B
        boolean isHealthy = checkServiceB();
        if (isHealthy) {
            return Health.up().withDetail("status", "Service B is up").build();
        } else {
            return Health.down().withDetail("status", "Service B is down").build();
        }
    }

    private boolean checkServiceB() {
        // Implement your custom logic to determine the health of Service B
        return true; // Example: return true if healthy, false otherwise
    }
}