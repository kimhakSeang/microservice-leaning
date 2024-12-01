package com.gateway.app.config;

import com.gateway.app.util.GatewayUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Order(1)
@Component
public class PreFilterGateway implements GlobalFilter {

    private static final Logger log = LoggerFactory.getLogger(PreFilterGateway.class);
    @Autowired
    private GatewayUtility gatewayUtility;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("PreFilterGateway: Start filter");
        gatewayUtility.checkConnectorId(exchange);
        log.debug("PreFilterGateway: End filter");
        return chain.filter(exchange);
    }
}
