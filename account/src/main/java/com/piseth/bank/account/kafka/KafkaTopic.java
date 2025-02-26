package com.piseth.bank.account.kafka;

import com.piseth.bank.account.dto.CustomerDTO;
import com.piseth.bank.account.entity.Customer;
import com.piseth.bank.account.mapper.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaTopic {
    @Autowired
    private StreamBridge streamBridge;

    public void sendCommunication(Customer customer){
        log.info("Start process sending Topic......");
        CustomerDTO customerDTO = new CustomerMapper().toCustomerDTO(customer);

        boolean sendResult =  streamBridge.send("sendCommunication-out-0", customerDTO);
        log.info("Process sending is success : {}", sendResult);

    }

}
