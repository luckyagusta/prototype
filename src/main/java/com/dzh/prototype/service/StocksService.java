package com.dzh.prototype.service;

import com.dzh.prototype.model.creation.StocksCreation;
import com.dzh.prototype.model.creation.StocksUpdate;
import com.dzh.prototype.model.entity.Stocks;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface StocksService {

    Flux<Stocks> findAll();

    Mono<Stocks> save(StocksCreation creation);

    Mono<Stocks> findById(String id);

    Mono<Stocks> update(StocksUpdate update);
}
