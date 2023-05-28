package com.springDataJPA.springboot.repository;

import com.springDataJPA.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
