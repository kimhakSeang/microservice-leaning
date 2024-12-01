package com.gateway.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

//	@Bean
//	public RouteLocator routes(
//			RouteLocatorBuilder builder
//	) {
//		return builder.routes()
//				.route( p -> p.path("/learn/**")
//						.filters(f -> f.rewritePath("/account/(?<segment>/?.*)", "/${segment}")
//								.addResponseHeader("X-RESPONSE-TIME", "")
//						)
//						.uri("lb://ACCOUNT")
//				)
//				.route( p -> p.path("/learn/loan/**")
//						.filters(f -> f.rewritePath("/learn/loan/(?<segment>/?.*)", "/${segment}"))
//						.uri("lb://LOAN")
//				).build();
//	}

}
