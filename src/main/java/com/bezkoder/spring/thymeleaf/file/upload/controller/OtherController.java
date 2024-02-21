package com.bezkoder.spring.thymeleaf.file.upload.controller;

import com.bezkoder.spring.thymeleaf.file.upload.repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    @Autowired
    private ProjetRepository projetRepository;

    @GetMapping("/")
    public String homepage() {
        return "index";
    }


    @GetMapping("/acceuil")
    public String home() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/a-propos")
    public String propos() {
        return "apropos";
    }

}
