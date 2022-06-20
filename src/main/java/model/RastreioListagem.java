package model;

import javax.persistence.Column;
import javax.persistence.Id;

public class RastreioListagem {
    @Id
    private Integer id;

    @Column
    private String origem;

    @Column
    private String destino;
    @Column
    private String status;

    @Column
    private String dataHoraEntrada;

    @Column
    private String dataHoraSaida;


    @Column
    private Integer rota;

    @Column
    private String localizacao;

    public RastreioListagem(Integer id, String origem, String destino,String status, String dataHoraEntrada, String dataHoraSaida, Integer rota, String localizacao) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.status = status;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
        this.rota = rota;
        this.localizacao = localizacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRota() {
        return rota;
    }

    public void setRota(Integer rota) {
        this.rota = rota;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "RastreioListagem{" +
                "id=" + id +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", status='" + status + '\'' +
                ", dataHoraEntrada='" + dataHoraEntrada + '\'' +
                ", dataHoraSaida='" + dataHoraSaida + '\'' +
                ", rota=" + rota +
                ", localizacao='" + localizacao + '\'' +
                '}';
    }
}
