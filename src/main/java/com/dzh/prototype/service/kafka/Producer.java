package com.dzh.prototype.service.kafka;

import com.dzh.prototype.model.entity.Stocks;
import com.dzh.prototype.util.path.TopicConstants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



public class Producer {
//    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
//
//    @Autowired
//    private KafkaTemplate<String, Object> kafkaTemplate;

//    public void sendStocks(Stocks stocks) {
//        logger.info(String.format("#### -> Producing message -> %s", stocks));
//        this.kafkaTemplate.send(TopicConstants.STOCKS, stocks);
//    }
}
