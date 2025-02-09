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
    public Function<CustomerMessageDto, String> email(){
        log.info("Start sending message to email....");
        return CustomerMessageDto::getEmail;
    }

}
