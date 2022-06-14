package model;

import javax.persistence.Column;
import javax.persistence.Id;

public class RotasListagem {
    @Id
    private Integer id;

    @Column
    private String unidadeOrigem;

    @Column
    private String unidadeDestino;

    public RotasListagem(Integer id, String unidadeOrigem, String unidadeDestino) {
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

    public String getUnidadeOrigem() {
        return unidadeOrigem;
    }

    public void setUnidadeOrigem(String unidadeOrigem) {
        this.unidadeOrigem = unidadeOrigem;
    }

    public String getUnidadeDestino() {
        return unidadeDestino;
    }

    public void setUnidadeDestino(String unidadeDestino) {
        this.unidadeDestino = unidadeDestino;
    }
}
