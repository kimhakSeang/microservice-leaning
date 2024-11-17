package com.piseth.bank.account.repository;

import com.piseth.bank.account.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, Long>{

}
