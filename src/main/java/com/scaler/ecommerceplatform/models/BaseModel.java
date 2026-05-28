package com.scaler.ecommerceplatform.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseModel {
    private long id;
    private Date createdAt;
    private Date lastModifiedAt;
    private boolean isDeleted;


}
