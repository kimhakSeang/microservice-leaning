package com.microservice.message.dto;

import lombok.Data;

@Data
public class CustomerMessageDto {
    private Integer id;
    private String name;
    private String email;
    private String mobileNumber;

}
