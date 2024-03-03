package com.kefu.controller;

import jakarta.annotation.Resource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class KafkaProducerController {
    @Resource
    private KafkaTemplate<String, String> kafka;

    @PostMapping("send")
    public String data(@RequestBody String msg) {
        // 通过Kafka发出数据
        kafka.send("test", msg);
        return "ok";
    }
}
