package com.piseth.bank.account.controller;

import com.piseth.bank.account.dto.CustomerDetailDTO;
import com.piseth.bank.account.dto.LoanDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.piseth.bank.account.dto.CustomerDTO;
import com.piseth.bank.account.entity.Customer;
import com.piseth.bank.account.mapper.CustomerMapper;
import com.piseth.bank.account.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerMapper customerMapper;
	
	@PostMapping
	public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO dto){
		Customer customer = customerMapper.toCustomer(dto);
		customer = customerService.save(customer);
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping
	public ResponseEntity<?> getCustomers(){
		return ResponseEntity.ok(customerService.getCustomers());
	}
	
	@GetMapping("{customerId}")
	public ResponseEntity<?> getCustomers(@PathVariable Integer customerId){
		return ResponseEntity.ok(customerService.getById(customerId));
	}

//	@CircuitBreaker(name = "CustomerDetailSupport", fallbackMethod = "getCustomerDetailDefault")
//	@Retry(name = "retryGetCustomerDetail", fallbackMethod = "getCustomerDetailDefault")
	@GetMapping("/detail/{customerId}")
	public ResponseEntity<?> getCustomerDetail(@RequestHeader("connector-id") String connectorId, @PathVariable Integer customerId){
		log.info(">>>>>>>>>>>> CustomerDetail: Start process of connectorId : "+ connectorId);
		CustomerDetailDTO customerDetail = customerService.getCustomerDetail(connectorId, customerId);
		log.info(">>>>>>>>>>>> CustomerDetail: Response Data: "+customerDetail);
		return ResponseEntity.ok(customerDetail);
	}

	public ResponseEntity<?> getCustomerDetailDefault(@PathVariable Integer customerId, Throwable e){
		return ResponseEntity.ok(customerService.getCustomerDetailDefault(customerId));
	}

//	@RateLimiter(name = "greetingRateLimit", fallbackMethod = "sayHi")
	@GetMapping(value = "greeting")
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("Hello Java");
	}

	public ResponseEntity<String> sayHi( Throwable e){
		return ResponseEntity.ok("Hi Java");
	}

}
