package com.piseth.bank.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.piseth.bank.account.config.AccountServiceConfig;
import com.piseth.bank.account.property.Properties;

@RestController
@RequestMapping("/api/v1/config")
public class AccountConfigController {
	
	@Autowired
	private AccountServiceConfig serviceConfig;
	
	@GetMapping("/properties")
	public String getProperties() throws JsonProcessingException {
		Properties properties= new Properties(
				serviceConfig.getMsg(), 
				serviceConfig.getBuildVersion(),
				serviceConfig.getMailDetail(),
				serviceConfig.getActiveBranchs()
				);
		
		ObjectWriter objectWriter  = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = objectWriter.writeValueAsString(properties);
		return json;
	}
}
