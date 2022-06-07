package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Rastreio implements Serializable{

    @Id
    private Integer id;

    @Column
    private Integer origem;

    @Column
    private Integer destino;

    @Column
    private LocalDateTime dataHoraEntrada;

    @Column
    private LocalDateTime dataHoraSaida;

    @Column
    private Enum status;

    @Column
    private Integer rota;

    public Rastreio() {

    }

    public Rastreio(Integer id, Integer origem, Integer destino, LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaida, Enum status) {
        super();
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
        this.status = status;
        this.rota = rota;
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

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public Integer getRota() { return rota; }

    public void setRota(Integer rota) { this.rota = rota; }
}
