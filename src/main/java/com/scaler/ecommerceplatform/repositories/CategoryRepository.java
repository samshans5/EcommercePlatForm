package com.scaler.ecommerceplatform.repositories;

import com.scaler.ecommerceplatform.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
    Category findByTitle(String title);
}
