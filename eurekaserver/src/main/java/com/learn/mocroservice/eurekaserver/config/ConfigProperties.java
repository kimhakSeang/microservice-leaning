package com.learn.mocroservice.eurekaserver.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "eureka")
@Data
public class ConfigProperties {
//    @Value("${server.port}")
//    private String port;
//    @Value("${eureka.instance.hostname}")
//    private String hostname;

      @Value("${server.port}")
      private String port;
      private Map<String, String > instance;
      private Map<String, String > client;

//    private Instance instance;
//    private Client client;
//    private Map<String, String> serverPort;
//
//    @Data
//    public static class Instance {
//        private String hostname;
//    }
//
//    @Data
//    public static class Client {
//        private boolean registerWithEureka;
//        private boolean fetchRegistry;
//        private Map<String, String>  serviceUrl;
//    }

//    private String msg;
//    private String buildVersion;
//    private Map<String, String> mailDetails;
//    private List<String> activeBranches;
}
