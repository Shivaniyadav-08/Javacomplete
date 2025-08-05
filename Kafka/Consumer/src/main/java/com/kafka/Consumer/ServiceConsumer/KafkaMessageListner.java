package com.kafka.Consumer.ServiceConsumer;

import com.kafka.Producer.Pojo.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListner {

    Logger logger = LoggerFactory.getLogger(KafkaMessageListner.class);


    @KafkaListener(topics = "kafkaTopic2", groupId = "Group3", topicPartitions = {@TopicPartition(topic = "kafkaTopic2", partitions = {"0"})})
    public void consumer1(String msg){
            logger.info("Consumer consumes message "+ msg);

    }

    @KafkaListener(topics = "kafkaTopic1", groupId = "Group1")
    public void consumer(Customer customer){
        logger.info("Consumer consumes customer "+ customer.toString());

    }





   /*
   @KafkaListener(topics = "kafkaTopic", groupId = "Group")
    public void consumer2(String msg){
        logger.info("Consumer consumes message "+ msg);
    }
    @KafkaListener(topics = "kafkaTopic", groupId = "Group")
    public void consumer3(String msg){
        logger.info("Consumer consumes message "+ msg);

    }
    @KafkaListener(topics = "kafkaTopic", groupId = "Group")
    public void consumer4(String msg){
        logger.info("Consumer consumes message "+ msg);
    }*/

}
