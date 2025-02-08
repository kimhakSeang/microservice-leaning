package com.microservice.message.function;

import com.microservice.message.dto.CustomerMessageDto;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunction {

    @Bean
    public Function<CustomerMessageDto, String> email(){
            return customerMessage -> customerMessage.getEmail();
    }

}
