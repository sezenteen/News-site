package com.example.amaraa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/contact-form")
    public String contactPage(Model model) {
        // Handle displaying the contact page
        return "contact";  // Thymeleaf template name
    }
}
