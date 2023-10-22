package com.example.java57.services;

import com.example.java57.model.Product;
import com.example.java57.repositoires.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> geAllProducts() {
        return productRepository.findAll();
    }
    public Optional<Product>getProductById(Long id){
        return productRepository.findById(id);
    }
    public void saveProduct(Product product){
        productRepository.save(product);
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}

