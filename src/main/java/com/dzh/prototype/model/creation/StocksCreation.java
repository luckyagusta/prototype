package com.dzh.prototype.model.creation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StocksCreation {
    @NotNull
    private String name;
    private Integer amount;
    private Double price;
    private String desc;
}
