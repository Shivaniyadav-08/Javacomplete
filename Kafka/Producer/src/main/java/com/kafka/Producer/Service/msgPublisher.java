package com.kafka.Producer.Service;

import com.kafka.Producer.Pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class msgPublisher {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public void sendMessage(String msg){

        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("kafkaTopic", 0, null, msg);
        future.whenComplete((result,ex)->{
            if(ex==null){
                System.out.println("Sent =[" +msg +"] , offset=[" + result.getRecordMetadata().offset() +"]" );
            }else {
                System.out.println("Unable to send");
            }
        });
    }

    //sending customer object as a message to kafka topic

    public void sendEventToTopic(Customer customer){
        CompletableFuture<SendResult<String, Object>> future1 = kafkaTemplate.send("kafkaTopic3", customer);
        future1.whenComplete((result, ex)->{
            if(ex==null){
                System.out.println("Sent =[" +customer.toString() +"] , offset=[" + result.getRecordMetadata().offset() +"]" );
            }else {
                System.out.println("Unable to send");
            }
        });
    }
}
