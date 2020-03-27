package com.zengbingo.activeMQ.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitCon{

    @RabbitListener(queues = "testQueue")
    public void proces2(Message message, Channel channel) throws  Exception{
        System.out.println("p2");
        System.out.println("p2 tag : " + message.getMessageProperties().getDeliveryTag());
        System.out.println("p2 CheckReceiver: " + new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}