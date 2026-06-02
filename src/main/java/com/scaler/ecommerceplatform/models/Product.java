package com.scaler.ecommerceplatform.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel{
    @Column(unique = true)  // ensures db enforces uniqueness
    private String title;
    private String description;
    private double price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
    private String imageUrl;
}
