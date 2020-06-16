package com.synergistictit.kafkaDemo.controllerV1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ControllerV1 {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        String topicName = "inbound";
        kafkaTemplate.send(topicName, message);

        return new ResponseEntity<String>("", HttpStatus.OK);
    }

    @GetMapping("/")
    String something(){
        return "Nice";
    }
}
