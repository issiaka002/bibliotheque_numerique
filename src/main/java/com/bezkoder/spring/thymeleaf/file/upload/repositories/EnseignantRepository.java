package com.bezkoder.spring.thymeleaf.file.upload.repositories;


import com.bezkoder.spring.thymeleaf.file.upload.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {
}
