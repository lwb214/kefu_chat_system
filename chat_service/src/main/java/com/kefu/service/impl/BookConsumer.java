package com.kefu.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kefu.mapper.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookConsumer {
    @Value("${kafka.topic.my-topic}")
    private String myTopic;
    @Value("${kafka.topic.my-topic2}")
    private String myTopic2;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @KafkaListener(topics = {"${kafka.topic.my-topic}"}, groupId = "group1")
    public void consumeMessage(ConsumerRecord<String, String> bookConsumerRecord) {
        try {
            Book book = objectMapper.readValue(bookConsumerRecord.value(), Book.class);
            log.info("消费者消费topic:{} partition:{}的消息 -> {}", bookConsumerRecord.topic(), bookConsumerRecord.partition(), book.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = {"${kafka.topic.my-topic2}"}, groupId = "group2")
    public void consumeMessage2(Book book) {
        log.info("消费者消费{}的消息 -> {}", myTopic2, book.toString());
    }
}
