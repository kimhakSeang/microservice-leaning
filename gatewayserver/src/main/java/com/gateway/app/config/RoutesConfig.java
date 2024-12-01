package com.gateway.app.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class RoutesConfig {

    @Bean
    public RouteLocator routes(
            RouteLocatorBuilder builder
    ) {
        return builder.routes()
                .route( p -> p.path("/learn/account/**")
                        .filters(f -> f.rewritePath("/learn/account/(?<segment>/?.*)", "/${segment}")
                                .addResponseHeader("X-RESPONSE-TIME", "")
                        )
                        .uri("lb://ACCOUNT")
                )
                .route( p -> p.path("/learn/loan/**")
                        .filters(f -> f.rewritePath("/learn/loan/(?<segment>/?.*)", "/${segment}"))
                        .uri("lb://LOAN")
                ).build();
    }
}
