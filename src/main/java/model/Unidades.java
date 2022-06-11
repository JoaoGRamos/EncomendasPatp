package model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Unidades implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer codigo;

    @Column
    private String descricao;

    @Column
    private String municipio;

    public Unidades() {

    }

    public Unidades(Integer codigo, String descricao, String municipio) {
        super();
        this.codigo = codigo;
        this.descricao = descricao;
        this.municipio = municipio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String local) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
