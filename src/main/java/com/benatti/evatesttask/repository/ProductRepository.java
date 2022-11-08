package com.benatti.evatesttask.repository;

import com.benatti.evatesttask.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
