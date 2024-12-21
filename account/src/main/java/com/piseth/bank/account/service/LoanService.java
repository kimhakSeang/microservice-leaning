package com.piseth.bank.account.service;

import com.piseth.bank.account.dto.LoanDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "loan")
public interface LoanService {

    @GetMapping(value = "/api/loans/{customerId}")
    List<LoanDTO> getLoanInfoByCustomerId(@RequestHeader("connector-id") String connectorId, @PathVariable  Integer customerId);
}
