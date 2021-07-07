package com.dzh.prototype.service.impl;

import com.dzh.prototype.dao.StocksDao;
import com.dzh.prototype.model.creation.StocksCreation;
import com.dzh.prototype.model.creation.StocksUpdate;
import com.dzh.prototype.model.entity.Stocks;
import com.dzh.prototype.service.StocksService;
import com.dzh.prototype.util.path.TopicConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Date;
import java.util.UUID;

@Service
public class StocksServiceImpl implements StocksService {

    private StocksDao stocksDao;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public void setStocksDao(StocksDao stocksDao) {
        this.stocksDao = stocksDao;
    }

    @Override
    public Flux<Stocks> findAll() {
        this.kafkaTemplate.send(TopicConstants.STOCKS, "Hi im sending this message using kafka");
        return stocksDao.findAll()
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Stocks> save(StocksCreation creation) {
        return stocksDao.findByName(creation.getName())
                .flatMap(stocks -> Mono.error(new Exception("Duplicate")))
                .switchIfEmpty(Mono.defer(() -> {
                    Stocks stocks = Stocks.builder()
                            .id(UUID.randomUUID().toString())
                            .price(creation.getPrice())
                            .desc(creation.getDesc())
                            .amount(creation.getAmount())
                            .name(creation.getName())
                            .build();
                    stocks.setIsDeleted(Boolean.FALSE);

                    return stocksDao.save(stocks);
                }))
                .map(o -> {
                    new Stocks();
                    return (Stocks) o;
                })
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Stocks> findById(String id) {
        return stocksDao.findById(id)
                .switchIfEmpty(Mono.error(new Exception("Not Found")))
                .subscribeOn(Schedulers.boundedElastic());
    }

    /*Update to Repository And send to kafka*/
    @Override
    public Mono<Stocks> update(StocksUpdate update) {
        return findById(update.getId())
                .switchIfEmpty(Mono.error(new Exception("Not Found")))
                .flatMap(stocks -> {
                    stocks.setName(update.getName());
                    stocks.setAmount(update.getAmount());
                    stocks.setPrice(update.getPrice());
                    stocks.setDesc(update.getDesc());
                    stocks.setUpdatedDate(new Date());

                    return stocksDao.save(stocks);
                });
    }
}
