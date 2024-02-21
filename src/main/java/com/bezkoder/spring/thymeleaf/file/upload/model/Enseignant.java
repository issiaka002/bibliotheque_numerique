package com.bezkoder.spring.thymeleaf.file.upload.model;


import com.bezkoder.spring.thymeleaf.file.upload._utils.enums.Titre;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@DiscriminatorValue(value = "ENSEI")
public class Enseignant extends Utilisateurs {

    private String domaine;

    @Enumerated(value = EnumType.STRING)
    private Titre titre;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "enseignants")
    private List<Projet> projets = new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "enseignant")
    private List<Evaluation> projetsEvalues = new ArrayList<>();
}
