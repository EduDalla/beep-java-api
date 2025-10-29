package br.com.beep.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Regra {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nomeRegra;

    private LocalDateTime dateCreated = LocalDateTime.now();

    // getters/setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }
    public String getNomeRegra(){ return nomeRegra; }
    public void setNomeRegra(String n){ this.nomeRegra=n; }
    public LocalDateTime getDateCreated(){ return dateCreated; }
    public void setDateCreated(LocalDateTime d){ this.dateCreated=d; }
}
