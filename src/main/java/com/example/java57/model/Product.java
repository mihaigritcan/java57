package com.example.java57.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Data
public class Product {
    @Id
    private Long id;
    private String name;
    private Double price;

    public Product(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {

    }
}
