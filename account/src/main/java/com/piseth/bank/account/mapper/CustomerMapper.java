package com.piseth.bank.account.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.piseth.bank.account.dto.CustomerDTO;
import com.piseth.bank.account.entity.Customer;

@Component
public class CustomerMapper {

	public Customer toCustomer(CustomerDTO dto) {
		Customer customer = new Customer();
		customer.setCustomerId(dto.getCustomerId());
		customer.setName(dto.getName());
		customer.setEmail(dto.getEmail());
		customer.setMobileNumber(dto.getMobileNumber());
		customer.setCreateDate(LocalDate.parse(dto.getCreateDate()));
		return customer;
	}

	public CustomerDTO toCustomerDTO(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setName(customer.getName());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setMobileNumber(customer.getMobileNumber());
		customerDTO.setCreateDate(String.valueOf(customer.getCreateDate()));
		return customerDTO;
	}
}
