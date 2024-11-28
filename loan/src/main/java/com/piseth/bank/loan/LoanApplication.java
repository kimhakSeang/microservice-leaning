package com.piseth.bank.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.piseth.bank.loan")
public class LoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

}
