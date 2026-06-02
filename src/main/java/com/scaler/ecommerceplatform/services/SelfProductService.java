package com.scaler.ecommerceplatform.services;

import com.scaler.ecommerceplatform.exceptions.ProductNotFoundException;
import com.scaler.ecommerceplatform.models.Category;
import com.scaler.ecommerceplatform.models.Product;
import com.scaler.ecommerceplatform.repositories.CategoryRepository;
import com.scaler.ecommerceplatform.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService
{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()){
            // product with given id doesn't exist
            throw new ProductNotFoundException(false, "Product with id does not exist: "+id);
        }
        return optionalProduct.get();
    }

    @Override
    public Product CreateProduct(String title, String description, String image, double price, String category)
    {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setImageUrl(image);
        product.setPrice(price);

        // checking if category is present in db otherwise create new category in table.
        Category createCategoryDB = categoryRepository.findByTitle(category);
        if (createCategoryDB == null){
            Category insertCategory = new Category();
            insertCategory.setTitle(category);
            categoryRepository.save(insertCategory);
            product.setCategory(insertCategory);
        }else{
            product.setCategory(createCategoryDB);
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProductsByCategory(String category) throws ProductNotFoundException{
        Optional<List<Product>> optionalProductsList = productRepository.findByCategory_title(category);
        if (optionalProductsList.isEmpty()){
            throw new ProductNotFoundException(false, "Products not found with given Category: " + category);
        }
        return optionalProductsList.get();
    }
}
