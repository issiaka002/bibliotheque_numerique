package com.bezkoder.spring.thymeleaf.file.upload.repositories;



import com.bezkoder.spring.thymeleaf.file.upload._utils.enums.Etat;
import com.bezkoder.spring.thymeleaf.file.upload.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet,Long> {

    List<Projet> findByThemeContainingIgnoreCase(String keyword);
    List<Projet> findByThemeContainingIgnoreCaseAndEtat(String keyword, Etat etat);

    List<Projet> findByDateDebut(Date date);
    List<Projet> findByDateFin(Date date);
    List<Projet> findByDateSoutenance(Date date);

    List<Projet> findByEtat(Etat etat);
}
