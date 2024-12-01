package com.piseth.bank.loan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.piseth.bank.loan.dto.LoanDTO;
import com.piseth.bank.loan.entity.Loan;
import com.piseth.bank.loan.mapper.LoanMapper;
import com.piseth.bank.loan.service.LoanService;

@RestController
@RequestMapping("api/loans")
public class LoanController {

	private static final Logger log = LoggerFactory.getLogger(LoanController.class);
	@Autowired
	private LoanService loanService;
	
	@Autowired
	private LoanMapper loanMapper;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody LoanDTO dto){
		Loan loan = loanService.save(loanMapper.toLoan(dto));
		return ResponseEntity.status(HttpStatus.CREATED).body(loan);
	}
	
	@GetMapping
	public ResponseEntity<?> list(){
		return ResponseEntity.ok(loanService.getList());
	}

	@GetMapping(value = "/{customerId}")
	public ResponseEntity<?> getLoanInfoByCustomerId(@RequestHeader("connector-id")String connectorId, @PathVariable Integer customerId){
		log.warn("GetLoanInfoByCustomerId: Start getLoanInfoByCustomerId of id = "+customerId);
		log.warn("GetLoanInfoByCustomerId: connector-id = "+connectorId);
		return ResponseEntity.ok(loanService.getLoanInfoByCustomerId( customerId));
	}


}
