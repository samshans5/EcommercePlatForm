package com.scaler.ecommerceplatform.services;

import com.scaler.ecommerceplatform.dtos.CreateProductDto;
import com.scaler.ecommerceplatform.dtos.FakeStoreProductDto;
import com.scaler.ecommerceplatform.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService
{
    public RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    /*
     * This method is to call third party API
     * url: 'https://fakestoreapi.com/products'
     */
    @Override
    public List<Product> getAllProducts() {
        // Creating  a list, which will be returned by the method
        List<Product> products = new ArrayList<>();

        // Iterate over the array and convert individual FakeStoreDto to product, then add the product to list
        FakeStoreProductDto[] fakeStoreProductDtoArray = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtoArray){
            Product product = fakeStoreProductDto.toProduct();
            products.add(product);
        }
        return products;
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
    public Product CreateProduct(CreateProductDto createProductDto)
    {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(createProductDto.getTitle());
        fakeStoreProductDto.setDescription(createProductDto.getDescription());
        fakeStoreProductDto.setPrice(createProductDto.getPrice());
        fakeStoreProductDto.setImage(createProductDto.getImage());
        fakeStoreProductDto.setCategory(createProductDto.getCategory());

        FakeStoreProductDto fakeStoreProductDto1 = restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class);
        return fakeStoreProductDto1.toProduct();
    }
}
