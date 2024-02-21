package com.bezkoder.spring.thymeleaf.file.upload.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class FileInfo {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String url;

  /*@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @OneToOne(mappedBy = "rapport")
  private Projet projet;*/

  public FileInfo(String name, String url) {
    this.name = name;
    this.url = url;
  }
}
