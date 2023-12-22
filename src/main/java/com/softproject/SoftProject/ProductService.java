package com.softproject.SoftProject;

import com.softproject.SoftProject.repo.ProductRepository;
import com.softproject.SoftProject.repo.SearchRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Ваш сервис
@Service
public class ProductService {

    private final SearchRepository productRepository;

    @Autowired
    public ProductService(SearchRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public void addDescription(Long productId, String additionalDescription) {
        Product product = getProductById(productId);
        if (product != null) {
            String currentDescription = product.getDescription();
            String updatedDescription = currentDescription + "\n" + additionalDescription;
            product.setDescription(updatedDescription);
            productRepository.save(product);
        }
    }

    public void updateProductPrice(Long productId, double newPrice) {
        Product product = productRepository.findById(productId).orElse(null);

        if (product != null) {
            product.setPrice(String.valueOf(newPrice));
            productRepository.save(product);
        }
    }

    // Другие методы для работы с продуктами
}

