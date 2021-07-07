package com.dzh.prototype.model.common;

import lombok.Data;

import java.util.Date;

@Data
public class CommonEntity {

    private Date createdDate;
    private Date updatedDate ;
    private String createdBy;
    private String updatedBy;
    private Boolean isDeleted;
}
