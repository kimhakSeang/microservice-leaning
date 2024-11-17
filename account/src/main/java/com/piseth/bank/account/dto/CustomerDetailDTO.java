package com.piseth.bank.account.dto;

import com.piseth.bank.account.entity.Customer;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDetailDTO {

    CustomerDTO customer;
    List<LoanDTO> loanDTOList;
}
