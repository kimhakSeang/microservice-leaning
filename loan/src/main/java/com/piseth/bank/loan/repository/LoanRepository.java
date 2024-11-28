package com.piseth.bank.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piseth.bank.loan.entity.Loan;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

    List<Loan> findByCustomerId(Integer customerId);
}
