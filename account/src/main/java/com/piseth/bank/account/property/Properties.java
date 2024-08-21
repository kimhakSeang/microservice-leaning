package com.piseth.bank.account.property;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Properties {
	private String msg;
	private String buildVersion;
	private Map<String, String> mailDetail;
	private List<String> activeBranch; 
}
