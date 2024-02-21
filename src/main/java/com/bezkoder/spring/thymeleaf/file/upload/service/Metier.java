package com.bezkoder.spring.thymeleaf.file.upload.service;


import com.bezkoder.spring.thymeleaf.file.upload.model.Commentaire;

public interface Metier {

    double evaluerProjet(Long idProjet, double note);
    void faireCommentaireSurProjet(Long idProjet, Commentaire commentaire);
    void validerArchivage(Long idProjet, String nomArchive);
    void rejeterArchivage(Long idProjet);
    void envoyerMail(String adresseMail, String message);
}
