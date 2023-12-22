package com.softproject.SoftProject.controllers;

import com.softproject.SoftProject.OrderService;
import com.softproject.SoftProject.User;
import jakarta.persistence.criteria.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class MainController {
    @GetMapping("/")
    public String registration() {
        return "home";
    }
    @GetMapping("/map")
    public String map(){
        return "map";
    }

@GetMapping("/ordered")
    public String ordered(){
        return "ordered";
}



}
