package com.kefu.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
@Slf4j
public class BookProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    public BookProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Object o) {
        // 分区编号最好为 null，交给 kafka 自己去分配
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(topic, null, System.currentTimeMillis(), String.valueOf(o.hashCode()), o);

        ListenableFuture<SendResult<String, Object>> future = (ListenableFuture<SendResult<String, Object>>) kafkaTemplate.send(producerRecord);
        future.addCallback(result -> log.info("生产者成功发送消息到topic:{} partition:{}的消息", result.getRecordMetadata().topic(), result.getRecordMetadata().partition()),
                ex -> log.error("生产者发送消失败，原因：{}", ex.getMessage()));
    }
}
