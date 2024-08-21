package com.piseth.bank.account.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.piseth.bank.account.config.actuator.ServiceAHealthIndicator;
import com.piseth.bank.account.config.actuator.ServiceBHealthIndicator;

@Component
@Endpoint(id = "customHealth")
public class CustomHealthEndpoint {

    private final HealthIndicator serviceAHealthIndicator;
    private final HealthIndicator serviceBHealthIndicator;

    public CustomHealthEndpoint(ServiceAHealthIndicator serviceAHealthIndicator, ServiceBHealthIndicator serviceBHealthIndicator) {
        this.serviceAHealthIndicator = serviceAHealthIndicator;
        this.serviceBHealthIndicator = serviceBHealthIndicator;
    }

    @ReadOperation
    public Map<String, Object> health() {
        Map<String, Object> response = new HashMap<>();
        response.put("version", 1); // Version number of the deploy

        Health serviceAHealth = serviceAHealthIndicator.health();
        Health serviceBHealth = serviceBHealthIndicator.health();

        Map<String, Object> services = new HashMap<>();
        services.put("serviceA", createServiceStatus(serviceAHealth));
        services.put("serviceB", createServiceStatus(serviceBHealth));

        response.put("services", services);

        return response;
    }

    private Map<String, Object> createServiceStatus(Health health) {
        Map<String, Object> status = new HashMap<>();
        status.put("status", health.getStatus().getCode());
        status.put("code", health.getStatus().equals(org.springframework.boot.actuate.health.Status.UP) ? 200 : 503);
        return status;
    }
}