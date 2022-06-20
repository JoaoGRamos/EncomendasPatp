package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable{

    @Id
    private Integer codigo;

    @Column
    private String nome;

    @Column
    private Integer unidade;

    public Usuario() {

    }

    public Usuario(Integer codigo, String nome, Integer unidade) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.unidade = unidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getUnidade() {
        return unidade;
    }

    public void setUnidade(Integer unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return nome;
    }
}
