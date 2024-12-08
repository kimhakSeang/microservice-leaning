package com.piseth.bank.loan.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "loan")
@Data
public class LoanServiceConfig {
		private String msg;
		private String buildVersion;
		private Map<String, String> mailDetails;
		private List<String> activeBranches;
}
