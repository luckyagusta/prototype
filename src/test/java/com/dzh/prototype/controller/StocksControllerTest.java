package com.dzh.prototype.controller;

import com.dzh.prototype.model.creation.StocksCreation;
import com.dzh.prototype.model.entity.Stocks;
import com.dzh.prototype.service.StocksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RunWith(SpringRunner.class)
@WebFluxTest(StocksController.class)
public class StocksControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    private StocksService stocksService;

    @Test
    public void testSaveStocks() {
        StocksCreation stocks = StocksCreation.builder()
                .name("Google")
                .price(2000.00)
                .amount(3)
                .desc("Google Stocks")
                .build();

        Mockito.when(stocksService.save(stocks)).thenReturn(getDummyStocks());

        webTestClient.post()
                .uri("/stocks/saveStocks")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(stocks), StocksCreation.class)
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

    public Mono<Stocks> getDummyStocks() {
        Stocks stocks = Stocks.builder()
                .id(UUID.randomUUID().toString())
                .name("Google")
                .price(2000.00)
                .amount(3)
                .desc("Google Stocks")
                .build();
        return Mono.just(stocks);
    }
}
