package com.learn.mocroservice.eurekaserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigEntity {
    private String port;
    private Map<String, String > instance;
    private Map<String, String> client;
}