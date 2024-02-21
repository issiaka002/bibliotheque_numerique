package com.bezkoder.spring.thymeleaf.file.upload.controller;

import com.bezkoder.spring.thymeleaf.file.upload.model.Projet;
import com.bezkoder.spring.thymeleaf.file.upload.repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class testControllers {

    @Autowired
    ProjetRepository projetRepository;

    @GetMapping("/projetliste")
    public List<Projet> projettr() {
        return projetRepository.findAll();
    }

    @GetMapping("/auth")
    @ResponseBody
    public Authentication authenticationmethode(Authentication authentication) {
        return authentication;
    }

    @PostMapping("/save")
    public Projet saveProje(@RequestBody Projet projet){
        return projetRepository.save(projet);
    }
}
