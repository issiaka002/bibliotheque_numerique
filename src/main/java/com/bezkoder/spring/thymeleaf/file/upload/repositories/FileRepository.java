package com.bezkoder.spring.thymeleaf.file.upload.repositories;

import com.bezkoder.spring.thymeleaf.file.upload.model.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileInfo,Long> {
}
