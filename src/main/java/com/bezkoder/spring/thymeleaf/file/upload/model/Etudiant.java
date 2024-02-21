package com.bezkoder.spring.thymeleaf.file.upload.model;



import com.bezkoder.spring.thymeleaf.file.upload._utils.enums.Cycle;
import com.bezkoder.spring.thymeleaf.file.upload._utils.enums.Ecole;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@DiscriminatorValue(value = "ETUD")
public class Etudiant extends Utilisateurs {

    private String filiere;

    @Enumerated(value = EnumType.STRING)
    private Ecole ecole;

    @Enumerated(value = EnumType.STRING)
    private Cycle cycle;

    @ManyToOne
    private Projet projet;
}
