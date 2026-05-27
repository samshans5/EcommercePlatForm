package com.scaler.ecommerceplatform.services;

import com.scaler.ecommerceplatform.dtos.CreateProductDto;
import com.scaler.ecommerceplatform.models.Product;

import java.util.List;

public interface ProductService
{
    List<Product> getAllProducts();
    Product getSingleProduct(long id);
    void CreateProduct(CreateProductDto createProductDto);
}
