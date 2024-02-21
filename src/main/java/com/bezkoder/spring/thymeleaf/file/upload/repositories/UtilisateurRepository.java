package com.bezkoder.spring.thymeleaf.file.upload.repositories;


import com.bezkoder.spring.thymeleaf.file.upload.model.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateurs,Long> {
}
