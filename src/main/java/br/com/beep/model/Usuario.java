package br.com.beep.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

@Entity
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Past
    private LocalDate dataNascimento;

    // getters/setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }
    public String getNome(){ return nome; }
    public void setNome(String nome){ this.nome=nome; }
    public LocalDate getDataNascimento(){ return dataNascimento; }
    public void setDataNascimento(LocalDate d){ this.dataNascimento=d; }
}
