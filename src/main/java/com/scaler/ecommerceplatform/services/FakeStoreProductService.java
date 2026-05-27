package com.scaler.ecommerceplatform.services;

import com.scaler.ecommerceplatform.dtos.CreateProductDto;
import com.scaler.ecommerceplatform.dtos.FakeStoreProductDto;
import com.scaler.ecommerceplatform.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService
{
    public RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    /*
    * This method is to call third party API
    * url: 'https://fakestoreapi.com/products/{id}'
    */
    @Override
    public Product getSingleProduct(long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public void CreateProduct(CreateProductDto createProductDto) {

    }
}
