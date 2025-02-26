package com.piseth.bank.account.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.piseth.bank.account.kafka.KafkaTopic;
import com.piseth.bank.account.dto.CustomerDetailDTO;
import com.piseth.bank.account.dto.LoanDTO;
import com.piseth.bank.account.exception.APIException;
import com.piseth.bank.account.exception.ErrorDetial;
import com.piseth.bank.account.mapper.CustomerMapper;
import com.piseth.bank.account.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.piseth.bank.account.entity.Customer;
import com.piseth.bank.account.repository.CustomerRepository;
import com.piseth.bank.account.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	private final CustomerRepository customerRepository;
	private final LoanService loanService;
	private final CustomerMapper customerMapper;
	private final KafkaTopic kafkaTopic;

	@Override
	public Customer save(Customer customer) {
		Customer result = customerRepository.save(customer);
		// Send Topic
		 kafkaTopic.sendCommunication(result);

		 return result;
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getById(Integer id) {
		return customerRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Customer not found"));
	}

	@Override
	public CustomerDetailDTO getCustomerDetail(String connectorId, Integer customerId) {

		Customer resultCustomerDetail = new Customer();
		Optional<Customer> customer = customerRepository.findById(customerId);
        resultCustomerDetail = customer
									.orElseThrow(()->
											new APIException(
													ErrorDetial.NOT_FOUND,
													HttpStatus.NOT_FOUND,
													"Customer Detail not found: "+ customerId
											)
									);

		List<LoanDTO> loanList = new ArrayList<>();
		try{
			loanList = loanService.getLoanInfoByCustomerId(connectorId, customerId);
		} catch (Exception e){
			log.error(">>>>>>>>>>>>> Loan Service Unavailable");
		}


		CustomerDetailDTO customerDetail = new CustomerDetailDTO();
		customerDetail.setCustomer(customerMapper.toCustomerDTO(resultCustomerDetail));
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

	@Override
	public void updateCustomerCommunication(Integer id){
		log.info("Update Customer Communication: "+ id);
		Customer customer = getById(id);
		customer.setAlreadySent(true);
		customerRepository.save(customer);
	}

}
