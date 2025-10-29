package br.com.beep.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Beep {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Usuario usuario;

    @ManyToOne(optional = false)
    private Produto produto;

    private LocalDateTime dataHora = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private BeepStatus status = BeepStatus.OK;

    // getters/setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }
    public Usuario getUsuario(){ return usuario; }
    public void setUsuario(Usuario u){ this.usuario=u; }
    public Produto getProduto(){ return produto; }
    public void setProduto(Produto p){ this.produto=p; }
    public LocalDateTime getDataHora(){ return dataHora; }
    public void setDataHora(LocalDateTime d){ this.dataHora=d; }
    public BeepStatus getStatus(){ return status; }
    public void setStatus(BeepStatus s){ this.status=s; }
}
