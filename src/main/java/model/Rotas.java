package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Rotas implements Serializable{

    @Id
    private Integer id;


    private Integer unidade_origem;


    private Integer unidade_destino;

    public Rotas() {

    }

    public Rotas(Integer id, Integer unidadeOrigem, Integer unidadeDestino) {
        super();
        this.id = id;
        this.unidade_origem = unidadeOrigem;
        this.unidade_destino = unidadeDestino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnidade_origem() {
        return unidade_origem;
    }

    public void setUnidade_origem(Integer unidade_origem) {
        this.unidade_origem = unidade_origem;
    }

    public Integer getUnidade_destino() {
        return unidade_destino;
    }

    public void setUnidade_destino(Integer unidade_destino) {
        this.unidade_destino = unidade_destino;
    }

    @Override
    public String toString() {
        return "Rota = " + id;
    }
}
