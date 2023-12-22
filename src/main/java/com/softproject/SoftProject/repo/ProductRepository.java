package com.softproject.SoftProject.repo;

import com.softproject.SoftProject.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {


}
