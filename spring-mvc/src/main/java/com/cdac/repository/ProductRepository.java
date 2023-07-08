package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
