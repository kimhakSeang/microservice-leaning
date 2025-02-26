package com.piseth.bank.account.kafka;

import com.piseth.bank.account.service.CustomerService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Data
public class KafkaConfiguration {
//    private final CustomerService customerService;

//    @Bean
//    public Consumer<Integer> updateCustomerCommunication(){
//        return customerService::updateCustomerCommunication;
//    }

    @Bean
    public Consumer<Integer> updateCustomerCommunication(CustomerService customerService){
        return customerService::updateCustomerCommunication;
    }
}
