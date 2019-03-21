package com.cognizant.training.springrabbitmqapp;

import com.cognizant.training.springrabbitmqapp.rabbitmq.HelloReceiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRabbitmqAppApplication {
	public static final String QUEUE_ORDERS = "HELLO_QUEUE";
	public static final String EXCHANGE_ORDERS = "HELLO_EXCHANGE";
	public static final String ROUTING_ORDERS = "HELLO_KEY";

	@Bean
	Queue queue() {
		return QueueBuilder.durable(QUEUE_ORDERS).build();
	}

	@Bean
	Exchange exchange() {
		return ExchangeBuilder.topicExchange(EXCHANGE_ORDERS).build();
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder
				.bind(queue)
				.to(exchange)
				.with(ROUTING_ORDERS);
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory
				= new CachingConnectionFactory("wabbit-host");
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		return connectionFactory;
	}

	@Bean
	SimpleMessageListenerContainer container(
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setQueueNames(QUEUE_ORDERS);
		container.setMessageListener(listenerAdapter        );
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(HelloReceiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqAppApplication.class, args);
	}

}
