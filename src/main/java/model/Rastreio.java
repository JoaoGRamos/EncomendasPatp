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
    private String status;

    @Column
    private Integer rota;

    @Column
    private Integer localizacao;

    public Rastreio() {

    }

    public Rastreio(Integer id, String status) {
        super();
        this.id = id;
        this.status = status;
    }

    public Rastreio(Integer id, Integer origem, Integer destino, String dataHoraEntrada, String dataHoraSaida, String status, Integer localizacao) {
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
    public Integer getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Integer localizacao) {
        this.localizacao = localizacao;
    }


}
