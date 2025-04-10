package com.microservice.message.controller;

import com.microservice.message.dto.CustomerMessageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KakfaController {
//    @Autowired
//    private KafkaTopicService kafkaTopicService;

    @PostMapping("")
    public ResponseEntity<?> sendTopic(CustomerMessageDto customerMessageDto){
//        kafkaTopicService.send(customerMessageDto);
        return ResponseEntity.ok("Work");
    }
}
