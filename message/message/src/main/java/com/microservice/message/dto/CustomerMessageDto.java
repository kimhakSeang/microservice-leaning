package com.microservice.message.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerMessageDto {
    private String name;
    private String email;
    private String mobileNumber;
//    private LocalDate createDate;
}
