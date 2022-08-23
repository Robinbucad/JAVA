package com.example.Kafka.controller;


import com.example.Kafka.controller.record.MessageRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    @PostMapping("/{topic}")
    public ResponseEntity<String> addListener(@PathVariable String topic, @RequestBody MessageRecord message){
        try {
            kafkaTemplate.send(topic,message.message());
            return ResponseEntity.ok().body("Message sent " + message.message() + " to " + topic);
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity().body("Error al enviar");
        }
    }



}
