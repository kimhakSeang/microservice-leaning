package com.piseth.bank.account.repository;


import com.piseth.bank.account.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {

}
