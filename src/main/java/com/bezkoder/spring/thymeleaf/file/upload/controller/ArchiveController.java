package com.bezkoder.spring.thymeleaf.file.upload.controller;

import com.bezkoder.spring.thymeleaf.file.upload.model.Archive;
import com.bezkoder.spring.thymeleaf.file.upload.repositories.ArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ArchiveController {

    @Autowired
    private ArchiveRepository archiveRepository;

    @GetMapping("/archive")
    public String archive(Model model) {
        model.addAttribute("archives",archiveRepository.findAll());
        return "archive";
    }

    @GetMapping(path="/saveArchive")
    public String formAchive(Model model){
        model.addAttribute("archive", new Archive());
        return "add-archive";
    }

    @GetMapping(path = "/archive/delete")
    public String deleteArchive(Long idArchive){
        archiveRepository.deleteById(idArchive);
        return "redirect:/archive";
    }

    @PostMapping(path = "/sauvegarderArchive")
    public String saveArchive(Model model,Archive archive){

        archiveRepository.save(archive);
        String mes = "Archive enregistrer avec succes...";
        model.addAttribute("message", mes);
        return "redirect:/archive";

    }

    @GetMapping(path = "/archive/edit")
    public String updateArchive(Model model,Long id ){
        Archive archive = archiveRepository.findById(id).orElse(null);
        if(archive==null) throw new RuntimeException("Archive introvable !");
        model.addAttribute("archive", archive);
        return "add-archive";
    }

    @GetMapping("/rechercheprojetecole")
    public String rechercheprojetecole(){
        return "";
    }

    @GetMapping("/rechercheprojet")
    public String rechercheprojet(){
        return "";
    }

    @GetMapping("/detailArchive")
    public String detailArchive(Model model, Long id){
        try{
            Archive archive = archiveRepository.findById(id).get();
            model.addAttribute("archive", archive);
            return "detail-archive";
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return "redirect:/archive";
        }

    }




}
