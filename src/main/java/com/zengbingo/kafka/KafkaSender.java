package com.zengbingo.kafka;

import com.alibaba.fastjson.JSONObject;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;


@Controller
public class KafkaSender {

    @Resource
    KafkaTemplate kafkaTemplate;

    @GetMapping("KafkaSender/sendMsg")
    public void sendMsg() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", "1");
        kafkaTemplate.send("kafka-1", jsonObject.toJSONString());
    }
}