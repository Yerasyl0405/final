package com.softproject.SoftProject.controllers;

import com.softproject.SoftProject.Product;
import com.softproject.SoftProject.User;
import com.softproject.SoftProject.repo.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private SearchRepository productRepository;
    @GetMapping("/index")
    public String indexx(){
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        List<Product> searchResults = productRepository.findByNameContainingIgnoreCase(keyword);
        model.addAttribute("searchResults", searchResults);
        return "searchResults";
    }
}
