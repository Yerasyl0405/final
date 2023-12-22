package com.softproject.SoftProject.controllers;

import com.softproject.SoftProject.Product;
import com.softproject.SoftProject.ProductService;
import com.softproject.SoftProject.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdateController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String showProducts(Model model) {
        // Получаем все продукты из базы данных
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/updatePriceForm")
    public String showUpdatePriceForm() {
        return "updatePriceForm";
    }

    @PostMapping("/updatePrice")
    public String updatePrice(@RequestParam Long productId, @RequestParam double newPrice) {
        // Обновляем цену товара
        productService.updateProductPrice(productId, newPrice);
        return "redirect:/products";
    }
}
