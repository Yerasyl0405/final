package com.softproject.SoftProject.controllers;

// ProductController.java


import com.softproject.SoftProject.Command;
import com.softproject.SoftProject.Product;
import com.softproject.SoftProject.ProductService;
import com.softproject.SoftProject.UpdatePriceCommand;
import com.softproject.SoftProject.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/ine")
    public String index(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "index1";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String name, @RequestParam String description) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        productRepository.save(product);
        return "redirect:/";
    }



}
