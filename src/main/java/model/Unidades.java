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
    private String local;

    public Unidades() {

    }

    public Unidades(Integer codigo, String descricao, String local) {
        super();
        this.codigo = codigo;
        this.descricao = descricao;
        this.local = local;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Unidade [id=" + codigo + ", descricao=" + descricao + ", local=" + local + "]";
    }
}
