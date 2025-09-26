package com.chg.ticketing_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeDirect {
    
    @GetMapping("/")
    public String home() {
        return "redirect:/user/tickets"; // Default to user view
    }
}