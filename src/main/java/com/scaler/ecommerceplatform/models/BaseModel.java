package com.scaler.ecommerceplatform.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date lastModifiedAt;
    private boolean isDeleted;

    /* // JPA Lifecycle Callbacks
    @PrePersist
    protected void onCreate(){
        createdAt = new Date();
        lastModifiedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        lastModifiedAt = new Date();
    }*/
}
