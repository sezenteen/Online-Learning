package com.example.onlinesurgalt.repository;

import com.example.onlinesurgalt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByDescription(String name);
    List<Product> findByCategoryId(Long categoryId);
}
