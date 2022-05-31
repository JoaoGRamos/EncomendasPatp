package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class Rotas implements Serializable{

    @Id
    private Integer id;

    @Column
    private Integer unidadeOrigem;

    @Column
    private Integer unidadeDestino;

    public Rotas() {

    }

    public Rotas(Integer id, Integer unidadeOrigem, Integer unidadeDestino) {
        super();
        this.id = id;
        this.unidadeOrigem = unidadeOrigem;
        this.unidadeDestino = unidadeDestino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnidadeOrigem() {
        return unidadeOrigem;
    }

    public void setUnidadeOrigem(Integer unidadeOrigem) {
        this.unidadeOrigem = unidadeOrigem;
    }

    public Integer getUnidadeDestino() {
        return unidadeDestino;
    }

    public void setUnidadeDestino(Integer unidadeDestino) {
        this.unidadeDestino = unidadeDestino;
    }
}
