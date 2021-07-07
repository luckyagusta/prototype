package com.dzh.prototype.model.entity;

import com.dzh.prototype.model.common.CommonEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stocks extends CommonEntity {

    @Id
    private String id;
    private String name;
    private Integer amount;
    private Double price;
    private String desc;
}
