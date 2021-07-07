package com.dzh.prototype.controller;

import com.dzh.prototype.model.creation.StocksCreation;
import com.dzh.prototype.model.creation.StocksUpdate;
import com.dzh.prototype.model.entity.Stocks;
import com.dzh.prototype.service.StocksService;
import com.dzh.prototype.util.path.Apipath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = Apipath.STOCKS)
public class StocksController {
    private StocksService stocksService;

    @Autowired
    public void setStocksService(StocksService stocksService) {
        this.stocksService = stocksService;
    }

    @GetMapping
    private Flux<Stocks> findAll(){
        return stocksService.findAll();
    }

    @PostMapping(path = Apipath.SAVE_STOCKS)
    private Mono<Stocks> save(StocksCreation creation) {
        return stocksService.save(creation);
    }

    @GetMapping(path = Apipath.FIND_STOCK)
    private Mono<Stocks> findOne(@PathVariable String id){
        return stocksService.findById(id);
    }

    @PatchMapping(path = Apipath.UPDATE_STOCKS)
    private Mono<Stocks> update(StocksUpdate update){
        return stocksService.update(update);
    }
}
