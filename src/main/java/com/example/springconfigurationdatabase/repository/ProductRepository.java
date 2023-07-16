package com.example.springconfigurationdatabase.repository;

import com.example.springconfigurationdatabase.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
