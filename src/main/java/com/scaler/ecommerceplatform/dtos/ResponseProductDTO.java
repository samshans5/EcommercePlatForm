package com.scaler.ecommerceplatform.dtos;

import com.scaler.ecommerceplatform.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProductDTO {
    private long id;
    private String title;
    private String description;
    private String image;
    private double price;
    private String category;

    public ResponseProductDTO(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.description = product.getDescription();
        this.category = product.getCategory() != null ? product.getCategory().getTitle(): null;
        this.image = product.getImageUrl();
        this.price = product.getPrice();
    }
}
