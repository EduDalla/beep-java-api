package br.com.beep.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Entity
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Min(0)
    private int quantidadeEstoque;

    @PositiveOrZero
    private BigDecimal preco;

    @Version
    private Long version;

    // getters/setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }
    public String getNome(){ return nome; }
    public void setNome(String n){ this.nome=n; }
    public int getQuantidadeEstoque(){ return quantidadeEstoque; }
    public void setQuantidadeEstoque(int q){ this.quantidadeEstoque=q; }
    public BigDecimal getPreco(){ return preco; }
    public void setPreco(BigDecimal p){ this.preco=p; }
    public Long getVersion(){ return version; }
    public void setVersion(Long version){ this.version = version; }
}