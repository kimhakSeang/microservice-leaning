package com.piseth.bank.account.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.piseth.bank.account.dto.CustomerDetailDTO;
import com.piseth.bank.account.dto.LoanDTO;
import com.piseth.bank.account.mapper.CustomerMapper;
import com.piseth.bank.account.service.LoanService;
import org.springframework.stereotype.Service;

import com.piseth.bank.account.entity.Customer;
import com.piseth.bank.account.repository.CustomerRepository;
import com.piseth.bank.account.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
	private final CustomerRepository customerRepository;
	private final LoanService loanService;
	private final CustomerMapper customerMapper;

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getById(Integer id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Customer not found"));
	}

	@Override
	public CustomerDetailDTO getCustomerDetail(Integer customerId) {

		Optional<Customer> customer = customerRepository.findById(customerId);
		if(customer.isEmpty()){
//			throw new RuntimeException("Customer Not Found");
			customer.orElse(new Customer());
		}
		List<LoanDTO> loanList = loanService.getLoanInfoByCustomerId(customerId);

		CustomerDetailDTO customerDetail = new CustomerDetailDTO();
		customerDetail.setCustomer(customerMapper.toCustomerDTO(customer.get()));
        customerDetail.setLoanDTOList(loanList);

		return customerDetail;
	}

	@Override
	public CustomerDetailDTO getCustomerDetailDefault(Integer customerId) {

		Optional<Customer> customer = customerRepository.findById(customerId);
		if(customer.isEmpty()){
			throw new RuntimeException("Customer Not Found");
		}
//		List<LoanDTO> loanList = loanService.getLoanInfoByCustomerId(customerId);

		CustomerDetailDTO customerDetail = new CustomerDetailDTO();
		customerDetail.setCustomer(customerMapper.toCustomerDTO(customer.get()));
		customerDetail.setLoanDTOList(null);

		return customerDetail;
	}

}
