package com.piseth.bank.loan.config;

import com.piseth.bank.loan.entity.Loan;
import com.piseth.bank.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class CommendRunnerImpl implements CommandLineRunner {
    @Autowired
    private LoanRepository loanRepository;

    @Override
    public void run(String... args) throws Exception {
        Loan loan = new Loan();
        loan.setLoanType("Installment Car");
        loan.setTotalLoan(BigDecimal.ONE);
        loan.setAmountPaid(BigDecimal.TEN);
        loan.setCreateDate(LocalDate.now());
        loan.setCustomerId(1);
        loan.setStartDate(LocalDate.now());
        loan.setOutstandingAmount(BigDecimal.ZERO);
        loanRepository.save(loan);
    }
}
