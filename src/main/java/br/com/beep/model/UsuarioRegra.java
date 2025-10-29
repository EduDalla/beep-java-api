package br.com.beep.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UsuarioRegra {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Usuario usuario;

    @ManyToOne(optional = false)
    private Regra regra;

    private LocalDateTime dateCreated = LocalDateTime.now();

    // getters/setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }
    public Usuario getUsuario(){ return usuario; }
    public void setUsuario(Usuario u){ this.usuario=u; }
    public Regra getRegra(){ return regra; }
    public void setRegra(Regra r){ this.regra=r; }
    public LocalDateTime getDateCreated(){ return dateCreated; }
    public void setDateCreated(LocalDateTime d){ this.dateCreated=d; }
}
