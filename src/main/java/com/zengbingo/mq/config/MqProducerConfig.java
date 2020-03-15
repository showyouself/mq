package com.zengbingo.mq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author mark
 */
@Configuration
@Slf4j
public class MqProducerConfig {

    @Bean
    public ConnectionFactory connectionFactory(com.rabbitmq.client.ConnectionFactory rabbitConnectionFactory){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitConnectionFactory);
        return connectionFactory;
    }

    @Bean
    public com.rabbitmq.client.ConnectionFactory rabbitConnectionFactory() {
        com.rabbitmq.client.ConnectionFactory connectionFactory = new com.rabbitmq.client.ConnectionFactory();
        connectionFactory.setAutomaticRecoveryEnabled(false);
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        return connectionFactory;
    }

    @Bean(name="testExchange")
    DirectExchange testExchange(){
        return new DirectExchange("testExchange");
    }

    @Bean(name="testQueue")
    Queue testQueue(){
        return new Queue("testQueue", true);
    }

    @Bean(name="testQueue2")
    Queue testQueue2(){
        return new Queue("testQueue2", true);
    }

    @Bean
    Binding binding(Queue testQueue, DirectExchange testExchange){
        return  BindingBuilder.bind(testQueue).to(testExchange).with("testRouting");
    }

    @Bean
    Binding bindin2(Queue testQueue, DirectExchange testExchange){
        return  BindingBuilder.bind(testQueue).to(testExchange).with("testRouting2");
    }
}