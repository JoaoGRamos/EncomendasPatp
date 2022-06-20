package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Rastreio implements Serializable{

    @Id
    private Integer id;

    @Column
    private Integer origem;

    @Column
    private Integer destino;

    private String datahora_entrada;

    private String datahora_saida;

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
        this.datahora_entrada = dataHoraEntrada;
        this.datahora_saida = dataHoraSaida;
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

    public String getDatahora_entrada() {
        return datahora_entrada;
    }

    public void setDatahora_entrada(String datahora_entrada) {
        this.datahora_entrada = datahora_entrada;
    }

    public String getDatahora_saida() {
        return datahora_saida;
    }

    public void setDatahora_saida(String datahora_saida) {
        this.datahora_saida = datahora_saida;
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
