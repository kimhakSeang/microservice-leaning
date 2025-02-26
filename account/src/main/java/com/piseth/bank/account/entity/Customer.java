package com.piseth.bank.account.entity;

import java.time.LocalDate;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "customer")
@Data
public class Customer {
	@Id
	private Integer id;
	private String name;
	private String email;
	private String mobileNumber;
	private LocalDate createDate;
	private boolean isAlreadySent;
}
