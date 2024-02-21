package com.bezkoder.spring.thymeleaf.file.upload.repositories;


import com.bezkoder.spring.thymeleaf.file.upload.model.Archive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchiveRepository extends JpaRepository<Archive,Long> {

    Archive findByLibelle(String libelle);
}
