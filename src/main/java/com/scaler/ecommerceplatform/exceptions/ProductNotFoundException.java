package com.scaler.ecommerceplatform.exceptions;

public class ProductNotFoundException extends Exception{

    private final boolean status;
    //Custom Exception
    public ProductNotFoundException(boolean status, String message){
        super(message);
        this.status = status;
    }

    // Getter
    public boolean getStatus(){
        return status;
    }
}
