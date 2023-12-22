package com.softproject.SoftProject.repo;

import com.softproject.SoftProject.Product;
import com.softproject.SoftProject.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String keyword);
}
