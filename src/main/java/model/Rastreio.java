package model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Rastreio implements Serializable{

    @Id
    private Integer id;

    @Column
    private Unidades origem;

    @Column
    private Unidades destino;

    @Column
    private LocalDateTime dataHoraEntrada;

    @Column
    private LocalDateTime dataHoraSaida;

    @Column
    private String status;

    @Column
    private Integer rota;

    @Column
    private Unidades localizacao;

    public Rastreio() {

    }

    public Rastreio(Integer id, String status) {
        super();
        this.id = id;
        this.status = status;
    }

    public Rastreio(Integer id, Unidades origem, Unidades destino, LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaida, String status, Unidades localizacao) {
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


    public Unidades getOrigem() {
        return origem;
    }

    public void setOrigem(Unidades origem) {
        this.origem = origem;
    }

    public Unidades getDestino() {
        return destino;
    }

    public void setDestino(Unidades destino) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRota() { return rota; }

    public void setRota(Integer rota) { this.rota = rota; }

    @OneToOne()
    @JoinTable(name="unidades",
            joinColumns={@JoinColumn(name="localizacao",
                    referencedColumnName="codigo")})
    public Unidades getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Unidades localizacao) {
        this.localizacao = localizacao;
    }
}
