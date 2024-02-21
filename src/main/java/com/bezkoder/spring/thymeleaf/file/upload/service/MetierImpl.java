package com.bezkoder.spring.thymeleaf.file.upload.service;


import com.bezkoder.spring.thymeleaf.file.upload._utils.enums.Etat;
import com.bezkoder.spring.thymeleaf.file.upload.model.Archive;
import com.bezkoder.spring.thymeleaf.file.upload.model.Commentaire;
import com.bezkoder.spring.thymeleaf.file.upload.model.Evaluation;
import com.bezkoder.spring.thymeleaf.file.upload.model.Projet;
import com.bezkoder.spring.thymeleaf.file.upload.repositories.ArchiveRepository;
import com.bezkoder.spring.thymeleaf.file.upload.repositories.CommantaireRepository;
import com.bezkoder.spring.thymeleaf.file.upload.repositories.EvaluationRepository;

import com.bezkoder.spring.thymeleaf.file.upload.repositories.ProjetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@AllArgsConstructor
@Transactional
public class MetierImpl implements Metier {

    private EvaluationRepository evaluationRepository;
    private CommantaireRepository commantaireRepository;
    private ProjetRepository projetRepository;
    private ArchiveRepository archiveRepository;


    @Override
    public double evaluerProjet(Long idProjet, double notes) {
        Projet projet = projetRepository.findById(idProjet).orElseThrow(() -> new RuntimeException("Projet non trouve avec l'ID=" + idProjet));
        Evaluation _evaluation = new Evaluation();
        _evaluation.setNote(notes);
        _evaluation.setProjet(projet);
        projet.getEvaluations().add(_evaluation);

        evaluationRepository.save(_evaluation);
        double note = 0;
        try {
            for (Evaluation eval : projet.getEvaluations()) {
                note = note + eval.getNote();
            }
            return note / projet.getEvaluations().size();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public void faireCommentaireSurProjet(Long idProjet, Commentaire commentaire) {
        Projet projet = projetRepository.findById(idProjet).orElseThrow(() -> new RuntimeException("Projet non trouve avec l'ID=" + idProjet));
        Commentaire comment = Commentaire.builder().titre(commentaire.getTitre()).date(new Date()).description(commentaire.getDescription()).projet(projet).auteur(commentaire.getAuteur()).build();
        commantaireRepository.save(comment);
        projet.getCommentaires().add(comment);
    }

    @Override
    public void validerArchivage(Long idProjet, String nomArchive) {
        Projet projet = projetRepository.findById(idProjet).orElseThrow(() -> new RuntimeException("Projet non trouve avec l'ID=" + idProjet));
        projet.setEtat(Etat.ARCHIVER);
        Archive archive = archiveRepository.findByLibelle(nomArchive);
        if(archive ==null) throw new RuntimeException("Archive non trouvé avec le nom :"+nomArchive);
        projet.setArchive(archive);
        archive.getProjets().add(projet);

        // envoyer mail confirmation
        //...

    }

    @Override
    public void rejeterArchivage(Long idProjet) {
        Projet projet = projetRepository.findById(idProjet).orElseThrow(() -> new RuntimeException("Projet non trouve avec l'ID=" + idProjet));
        projet.setEtat(Etat.REJETER);

        // envoyer mail refus
        //..
    }

    @Override
    public void envoyerMail(String adresseMail, String message) {

    }
}
