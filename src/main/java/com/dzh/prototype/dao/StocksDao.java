package com.dzh.prototype.dao;

import com.dzh.prototype.model.entity.Stocks;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface StocksDao extends ReactiveMongoRepository<Stocks, String> {

    Mono<Stocks> findByName(String name);

    Mono<Stocks> findStocksByAmount(Integer amount);


}
