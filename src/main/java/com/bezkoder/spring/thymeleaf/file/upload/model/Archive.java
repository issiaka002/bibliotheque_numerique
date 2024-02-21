package com.bezkoder.spring.thymeleaf.file.upload.model;



import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Archive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArchive;
    private String libelle;

    @OneToMany(mappedBy = "archive", fetch = FetchType.EAGER)
    private List<Projet> projets = new ArrayList<>();
}
