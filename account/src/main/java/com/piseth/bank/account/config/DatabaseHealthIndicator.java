package com.piseth.bank.account.config;

import com.mongodb.client.MongoDatabase;
import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.transport.EurekaHttpResponse;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DatabaseHealthIndicator implements HealthIndicator {
//    private final MongoClient mongoClient;
    private final EurekaClient eurekaClient;

    @Override
    public Health health() {
        try {
            // Simulate database health check
            boolean dbUp = checkDatabaseConnection();
            return dbUp ? Health.up().build() : Health.down().withDetail("error", "Database unreachable").build();
        } catch (Exception e) {
            return Health.down(e).build();
        }
    }

    private boolean checkDatabaseConnection() {
//        MongoDatabase database = mongoClient.getDatabase("mydatabase");
//        database.runCommand(new org.bson.Document("ping", 1));  // Test connectivity
//        return Health.up().withDetail("database", "MongoDB").build();
        try {
            // Attempt to make a heartbeat or test connection to Eureka server
            ApplicationInfoManager applicationInfoManager = eurekaClient.getApplicationInfoManager();

            if (applicationInfoManager.getInfo().getStatus().equals(InstanceInfo.InstanceStatus.UP)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
