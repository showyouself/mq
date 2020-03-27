package com.zengbingo.activeMQ.controller;

import com.zengbingo.activeMQ.publisher.RabbitPub;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController()
@RequestMapping("Rabbit")
public class Rabbit{

    @Resource
    RabbitPub rabbitPub;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return rabbitPub.sendMessage();
    }
}