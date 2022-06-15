package model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Rastreio implements Serializable{

    @Id
    private Integer id;

    @Column
    private Integer origem;

    @Column
    private Integer destino;

    @Column
    private String dataHoraEntrada;

    @Column
    private String dataHoraSaida;

    @Column
    private Integer status;

    @Column
    private Integer rota;

    @Column
    private Integer localizacao;

    public Rastreio() {

    }

    public Rastreio(Integer id, Integer origem, Integer destino, String dataHoraEntrada, String dataHoraSaida, Integer status, Integer localizacao) {
        super();
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
        this.status = status;
        this.rota = rota;
        this.localizacao = localizacao;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getOrigem() {
        return origem;
    }

    public void setOrigem(Integer origem) {
        this.origem = origem;
    }

    public Integer getDestino() {
        return destino;
    }

    public void setDestino(Integer destino) {
        this.destino = destino;
    }

    public String getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(String dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public String getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(String dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRota() { return rota; }

    public void setRota(Integer rota) { this.rota = rota; }

    public Integer getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Integer localizacao) {
        this.localizacao = localizacao;
    }


}
