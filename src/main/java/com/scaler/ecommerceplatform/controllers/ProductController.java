package com.scaler.ecommerceplatform.controllers;

import com.scaler.ecommerceplatform.dtos.CreateProductDto;
import com.scaler.ecommerceplatform.dtos.ResponseProductDTO;
import com.scaler.ecommerceplatform.exceptions.ProductNotFoundException;
import com.scaler.ecommerceplatform.models.Product;
import com.scaler.ecommerceplatform.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController
{
    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService)
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
    public Product getSingleProduct(@PathVariable long id) throws ProductNotFoundException {

        return productService.getSingleProduct(id);
    }

    @GetMapping("/products/category/{category}")
    public List<Product> fetchProductsBasedOnCategory(@PathVariable String category) throws ProductNotFoundException {
        return productService.getAllProductsByCategory(category);
    }

    /*
    * POST /products: Create a product
    * for testing purpose we changed return type from void to product
    * */
    @PostMapping("/products")
    public ResponseProductDTO createProduct(@RequestBody CreateProductDto createProductDto)
    {
        Product product = productService.CreateProduct(
                createProductDto.getTitle(),
                createProductDto.getDescription(),
                createProductDto.getImage(),
                createProductDto.getPrice(),
                createProductDto.getCategory()
        );
        return new ResponseProductDTO(product);
    }
}
