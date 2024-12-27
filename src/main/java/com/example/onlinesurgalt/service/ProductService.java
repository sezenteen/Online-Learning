package com.example.onlinesurgalt.service;

import com.example.onlinesurgalt.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findByProductDescription(String name);
    List<Product> getAllProducts();
    Product createProduct(Product product);
    List<Product> createProducts(List<Product> products);
    Optional<Product> getProductById(Long id);
    Product updateProduct(Product product);
    String deleteProductById(Long id);
}
