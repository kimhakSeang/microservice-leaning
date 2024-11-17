package com.piseth.bank.account.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "account")
@Data
public class AccountServiceConfig {
		private String msg;
		private String buildVersion;
		private Map<String, String> mailDetail;
		private List<String> activeBranchs; 
}
