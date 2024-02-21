package com.bezkoder.spring.thymeleaf.file.upload.repositories;


import com.bezkoder.spring.thymeleaf.file.upload.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
}
