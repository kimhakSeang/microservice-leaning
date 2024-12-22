package com.learn.mocroservice.eurekaserver.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.learn.mocroservice.eurekaserver.config.ConfigProperties;
import com.learn.mocroservice.eurekaserver.entity.ConfigEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    private static final Logger log = LoggerFactory.getLogger(ConfigController.class);
    @Autowired
    private ConfigProperties configProperties;

    @GetMapping("/properties")
    public ResponseEntity<?> getProperties() throws JsonProcessingException {

        ConfigEntity properties= new ConfigEntity(
                configProperties.getPort(),
                configProperties.getInstance(),
                configProperties.getClient()
        );

        return ResponseEntity.ok(properties);
    }
}
