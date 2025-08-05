package com.kafka.Producer;

import com.kafka.Producer.Pojo.Customer;
import com.kafka.Producer.Service.msgPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.kafka.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class ProducerApplicationTests {

	// Create Kafka container using DockerImageName

	@Container
	 static KafkaContainer kafkaContainer =  new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest")
			.asCompatibleSubstituteFor("apache/kafka"));

	@DynamicPropertySource
	static void setKafkaProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.kafka.bootstrap-servers", kafkaContainer::getBootstrapServers);// bootstrap running dynamically
	}
	@Autowired
	msgPublisher msgPublisher;

	@Test
	void sendEventToTopic() {
		Customer customer = new Customer();
		customer.setId(9);
		customer.setAge(22);
		customer.setName("shivi");
		customer.setEmail("shivi123@gmail.com");

		msgPublisher.sendEventToTopic(customer);

	}

}
