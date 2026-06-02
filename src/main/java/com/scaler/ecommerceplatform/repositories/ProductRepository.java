package com.scaler.ecommerceplatform.repositories;

import com.scaler.ecommerceplatform.models.Category;
import com.scaler.ecommerceplatform.models.Product;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
    @Override
    List<Product> findAll();

//    Product findById(long id);


    @Override
    Optional<Product> findById(Long id);

    Product save(@NonNull Product product);

    Optional<List<Product>> findByCategory_title(String category);
}
