package com.softproject.SoftProject.controllers;

import com.softproject.SoftProject.User;
import com.softproject.SoftProject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/myOrder")
    public String inde(){
        return "myOrder";
    }
    @GetMapping("/resul")
    public String resutl(@RequestParam String username, Model model) {
        User results = userRepository.findByUsername(username);

        if (results == null) {
            // User with the given username does not exist
            model.addAttribute("errorMessage", "User with username " + username + " does not exist.");
            return "myOrder"; // This assumes you have a result.html template to display the message.
        } else {
            model.addAttribute("result", results);
            return "result";
        }
    }







    // Другие методы обработки заказов
}

