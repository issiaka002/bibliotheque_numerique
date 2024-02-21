package com.bezkoder.spring.thymeleaf.file.upload.repositories;

import com.bezkoder.spring.thymeleaf.file.upload.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {
}
