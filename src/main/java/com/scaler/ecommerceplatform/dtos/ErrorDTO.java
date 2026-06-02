package com.scaler.ecommerceplatform.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
    private boolean status;
    private String message;
}
