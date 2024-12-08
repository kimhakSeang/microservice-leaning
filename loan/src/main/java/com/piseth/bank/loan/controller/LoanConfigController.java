package com.piseth.bank.loan.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.piseth.bank.loan.config.LoanServiceConfig;
import com.piseth.bank.loan.property.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/config")
public class LoanConfigController {
	
	@Autowired
	private LoanServiceConfig serviceConfig;
	
	@GetMapping("/properties")
	public String getProperties() throws JsonProcessingException {
		Properties properties= new Properties( serviceConfig.getMsg(),
				                               serviceConfig.getBuildVersion(),
				                               serviceConfig.getMailDetails(),
				                               serviceConfig.getActiveBranches());
		
		ObjectWriter objectWriter  = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = objectWriter.writeValueAsString(properties);
		return json;
	}
}
