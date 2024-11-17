package com.piseth.bank.account.entity;

import java.time.LocalDate;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "account")
@Data
public class Account {
	@Id
	private Long accountNumber;
	private Customer customer;
	private String accountType;
	private String branchAddress;
	private LocalDate createDate;
}
