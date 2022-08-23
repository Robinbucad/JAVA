package com.example.Kafka;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "topic1",
            groupId= "groupid"
    )
    void listener1(String data){
        System.out.println("Mensaje del topic 1 " +data);
    }

    @KafkaListener(
            topics = "topic2",
            groupId = "groupid"
    )
    void listner2(String data){
        System.out.println("Mensaje del topico 2 " + data);
    }
}
