package com.softproject.SoftProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String log(@RequestParam String password){
        System.out.println(password);
        if("erererer".equals(password)){
            return "redirect:/products";
        }else{
            return "redirect:/login?error";
        }
    }
}
