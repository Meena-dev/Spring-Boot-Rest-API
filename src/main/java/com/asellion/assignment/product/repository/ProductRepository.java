package com.asellion.assignment.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asellion.assignment.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
