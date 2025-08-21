package com.kelly.Compra_usuario_padaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    
    @GetMapping("/")
    public String serveHomepage() {
        return "usuario.html";
    }
}