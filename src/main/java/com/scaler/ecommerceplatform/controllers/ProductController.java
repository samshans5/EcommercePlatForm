package com.scaler.ecommerceplatform.controllers;

import com.scaler.ecommerceplatform.dtos.CreateProductDto;
import com.scaler.ecommerceplatform.models.Product;
import com.scaler.ecommerceplatform.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController
{
    private ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }
    /*
    * API: methods in controller
    * */


    /*
    * GET /products: Get all products
    * */
    @GetMapping("/products")
    public List<Product> getALLProducts()
    {
        return productService.getAllProducts();
    }

    /*
     * GET /products/{id}: Get single product
     * */
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable long id)
    {
        return productService.getSingleProduct(id);
    }

    /*
    * POST /products: Create a product
    * */
    @PostMapping("/products")
    public void createProduct(CreateProductDto createProductDto)
    {
        productService.CreateProduct(createProductDto);
    }


}
