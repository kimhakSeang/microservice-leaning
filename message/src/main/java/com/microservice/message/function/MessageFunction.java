package com.microservice.message.function;

import lombok.extern.slf4j.Slf4j;
import com.microservice.message.dto.CustomerMessageDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Slf4j
@Configuration
public class MessageFunction {

    @Bean
    public Function<CustomerMessageDto, CustomerMessageDto> email(){
        log.info("Start sending message to email....");
        return e -> {
            log.info("Send email to customer: {}", e);
//            if(e.getEmail().equals("hak@gmail.com")){
//                throw new RuntimeException("Test");
//            }
            return e;
        };
    }

    @Bean
    public Function<CustomerMessageDto, Integer> sms(){
        log.info("Start sending message to sms....");
        return cust -> {
            log.info("Consume Successfully: "+ cust.getId());
            return cust.getId();
        };
    }

}
