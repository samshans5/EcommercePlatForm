package com.scaler.ecommerceplatform;

import com.scaler.ecommerceplatform.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommercePlatFormApplication {

    public static void main(String[] args) {
        Product p1 = new Product();
        SpringApplication.run(EcommercePlatFormApplication.class, args);
    }

}
