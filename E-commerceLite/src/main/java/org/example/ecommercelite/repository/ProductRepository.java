package org.example.ecommercelite.repository;

import org.example.ecommercelite.enity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

//    find products by name
    List<Product> findByNameContainingIgnoreCase(String name);

//    find products in stock
    List<Product> findByStockQuantityGreaterThan(Integer stockQuantity);
}
