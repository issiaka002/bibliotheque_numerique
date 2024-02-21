package com.bezkoder.spring.thymeleaf.file.upload.repositories;


import com.bezkoder.spring.thymeleaf.file.upload.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommantaireRepository extends JpaRepository<Commentaire,Long> {
}
