package com.dzh.prototype.util;

import com.dzh.prototype.model.creation.StocksCreation;
import com.dzh.prototype.model.entity.Stocks;

@org.mapstruct.Mapper
public interface MapperHelper {
    Stocks mapToStocks(StocksCreation stocksCreation);
}
