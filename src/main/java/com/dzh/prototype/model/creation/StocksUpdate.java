package com.dzh.prototype.model.creation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StocksUpdate {
    @NotNull
    private String id;
    private String name;
    private Integer amount;
    private Double price;
    private String desc;
}
