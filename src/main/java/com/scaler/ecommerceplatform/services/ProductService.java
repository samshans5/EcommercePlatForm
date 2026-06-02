package com.scaler.ecommerceplatform.services;

import com.scaler.ecommerceplatform.exceptions.ProductNotFoundException;
import com.scaler.ecommerceplatform.models.Product;

import java.util.List;

public interface ProductService
{
    List<Product> getAllProducts();
    Product getSingleProduct(long id) throws ProductNotFoundException;
    Product CreateProduct(String title, String description, String image, double price, String category);

    List<Product> getAllProductsByCategory(String category) throws ProductNotFoundException;
}
