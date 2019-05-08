package com.kafka.mendixclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MendixClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MendixClientApplication.class, args);
    }

}


@RestController
class KafkaProducerController{

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private static final String TOPIC = "replicated_topic";

    @GetMapping("/message/send")
    public String sendMessage(@PathVariable("message") final String  message){

        kafkaTemplate.send(TOPIC,"Hello");

    return null;
    }


}
