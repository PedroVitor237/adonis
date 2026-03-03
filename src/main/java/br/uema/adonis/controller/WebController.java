package br.uema.adonis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    
    @GetMapping("/")
    public String home() {
        return "index"; // Retorna o nome da view (index.html) para ser renderizada
    }
}
