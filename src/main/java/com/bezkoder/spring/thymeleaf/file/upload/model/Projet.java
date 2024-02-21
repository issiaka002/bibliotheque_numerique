package com.bezkoder.spring.thymeleaf.file.upload.model;


import javax.persistence.*;

import com.bezkoder.spring.thymeleaf.file.upload._utils.enums.Cycle;
import com.bezkoder.spring.thymeleaf.file.upload._utils.enums.Ecole;
import com.bezkoder.spring.thymeleaf.file.upload._utils.enums.Etat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjet;

    private String theme;

    @Column(length = 755)
    private String description;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateSoutenance;

    private String jury;

    @Enumerated(EnumType.STRING)
    private Ecole ecole;

    @Enumerated(EnumType.STRING)
    private Cycle cycle;

    @Enumerated(EnumType.STRING)
    private Etat etat= Etat.EN_ATTENTE;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FileInfo rapport;

    @Column(length = 10000)
    private String remarques;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Archive archive;

    @OneToMany(mappedBy = "projet")
    private List<Evaluation> evaluations = new ArrayList<>();

    @OneToMany(mappedBy = "projet",fetch = FetchType.EAGER)
    private List<Commentaire> commentaires= new ArrayList<>();

    @OneToMany
    private List<Enseignant> enseignants = new ArrayList<>();

    private String encardreur;

    @Column(length = 700)
    private String etudiants ;
}
