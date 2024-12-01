package com.gateway.app.config;

import com.gateway.app.util.GatewayUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class PostFilterGateway {

    @Autowired
    private GatewayUtility gatewayUtility;

    @Bean
    public GlobalFilter postFilter(){
        return ( exchange, chain) -> chain.filter(exchange).then(
                Mono.fromRunnable(()->{
                    String connectorId = gatewayUtility.getConnectorId(exchange);
//                    exchange.getRequest().getHeaders().add(gatewayUtility.CONNECTOR_ID, connectorId);
                    exchange.getRequest().mutate().header(gatewayUtility.CONNECTOR_ID, connectorId);
                })
        );
    }
}
