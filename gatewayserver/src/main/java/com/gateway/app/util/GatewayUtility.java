package com.gateway.app.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class GatewayUtility {

    private static final Logger log = LoggerFactory.getLogger(GatewayUtility.class);

    public final static String CONNECTOR_ID = "connector-id";

    public String generateUUID(){
        return UUID.randomUUID().toString();
    }

    public void checkConnectorId(ServerWebExchange serverWebExchange){

        HttpHeaders headers = serverWebExchange.getRequest().getHeaders();
        if(getConnectorId(serverWebExchange).isEmpty()){
            String generateUUID = generateUUID();
            log.info("GatewayUtility: generate connector-id: {}", generateUUID);
            serverWebExchange.getRequest().mutate().header(CONNECTOR_ID, generateUUID );
        }else {
            log.info("GatewayUtility: found connector-id: {}", serverWebExchange.getRequest().getHeaders().get(CONNECTOR_ID));
        }

    }

    public String getConnectorId(ServerWebExchange serverWebExchange){
        return serverWebExchange.getRequest().getHeaders().getOrEmpty(CONNECTOR_ID).stream().findFirst().orElse("");
    }

}
