package com.piseth.bank.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piseth.bank.loan.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
