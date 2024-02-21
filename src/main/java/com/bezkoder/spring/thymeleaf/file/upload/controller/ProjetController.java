package com.bezkoder.spring.thymeleaf.file.upload.controller;

import com.bezkoder.spring.thymeleaf.file.upload._utils.enums.Etat;
import com.bezkoder.spring.thymeleaf.file.upload.model.Commentaire;
import com.bezkoder.spring.thymeleaf.file.upload.model.Projet;
import com.bezkoder.spring.thymeleaf.file.upload.repositories.ProjetRepository;
import com.bezkoder.spring.thymeleaf.file.upload.service.Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjetController {

    @Autowired
    private ProjetRepository projetRepository;
    @Autowired
    private Metier metier;

    @GetMapping("/projetrtyuytryu/rien")
    public String projet(Model model) {
        model.addAttribute("projets", projetRepository.findByEtat(Etat.EN_ATTENTE));
        return "projet";
    }

    @GetMapping("/projet")
    public String getAll(Model model, @Param("keyword") String keyword) {
        try {
            List<Projet> projets = new ArrayList<>();

            if (keyword == null) {
                projets.addAll(projetRepository.findByEtat(Etat.EN_ATTENTE));
            } else {
                projets.addAll(projetRepository.findByThemeContainingIgnoreCase(keyword));
                model.addAttribute("keyword", keyword);
            }

            model.addAttribute("projets", projets);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "projet";
    }

    @GetMapping("/projetform")
    public String addprojet(Model model) {
        model.addAttribute("projet", new Projet());
        return "add-project";
    }

    @GetMapping(path = "/projet/delete")
    public String deleteProjet(Long idProjet) {
        projetRepository.deleteById(idProjet);
        return "redirect:/projet";
    }


    @GetMapping("/detailArchiveProjet")
    public String detailArchiveprojet(Model model, Long id){
        try {
            Projet projet = projetRepository.findById(id).get();
            model.addAttribute("projet", projet);
            model.addAttribute("commentaire", new Commentaire());

            return "detail-projet-archive";

        } catch (Exception e) {

            return "redirect:/projet";
        }

    }

    @GetMapping(path = "/detailprojet")
    public String getProjet(Model model, Long id) {


        try {
            Projet projet = projetRepository.findById(id).get();
            model.addAttribute("projet", projet);
            model.addAttribute("commentaire", new Commentaire());

            return "detail";

        } catch (Exception e) {

            return "redirect:/projet";
        }


        /*//...code de validation
        if(bindingResult.hasErrors()) return "add-projet";
        projetRepository.save(projet);
        String mes = "Projet enregistrer avec succes : en cours de traitement ...";
        model.addAttribute("message", mes);
        return "redirect:/projet";*/

    }

    @PostMapping("/commentaire")
    public String commenter(Long id, Commentaire commentaire) {
        metier.faireCommentaireSurProjet(id,commentaire);
        return "redirect:/detailArchiveProjet?id=" + id;
    }

    @GetMapping("/archiverProjet")
    public String archiverProjet(Long id){
        metier.validerArchivage(id,"ARC_STIC_ING");
        return "redirect:/projet";
    }

}
