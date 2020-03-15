package com.zengbingo.mq.publisher;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RabbitPub {

    @Resource
    RabbitTemplate rabbitTemplate;

    public String sendMessage(){
        JSONObject data = new JSONObject();
        data.put("曾彬", "100分");
        data.put("历史成绩", "100分");
        rabbitTemplate.convertAndSend("testExchange","testRouting",data);
        return "success";
    }
}