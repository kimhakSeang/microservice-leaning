package com.piseth.bank.account.config;

import com.piseth.bank.account.entity.Account;
import com.piseth.bank.account.entity.Customer;
import com.piseth.bank.account.service.AccountService;
import com.piseth.bank.account.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AccountCommendRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(AccountCommendRunner.class);
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setName("Kimhak");
        customer.setCreateDate(LocalDate.now());
        customer.setEmail("Kimhak@gmail.com");
        customer.setMobileNumber("081531077");
        customerService.save(customer);

        Account account = new Account();
        account.setAccountNumber(1L);
        account.setAccountType("Saving");
        account.setCreateDate(LocalDate.now());
        account.setCustomer(customer);
        account.setBranchAddress("Kandal");
        accountService.save(account);
        log.info("Account Created");
    }
}
