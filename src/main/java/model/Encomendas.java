package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

public class Encomendas implements Serializable{

    @Id
    private Integer codigo;

    @Column
    private Integer remetente;

    @Column
    private Integer destinatario;

    @Column
    private Integer origem;

    @Column
    private Integer destino;

    @Column
    private LocalDate dataPostagem;

    @Column
    private LocalDate dataEntregaPrev;

    @Column
    private LocalDate dataEntregaReal;

    public Encomendas() {

    }

    public Encomendas(Integer codigo, Integer remetente, Integer destinatario, Integer origem, Integer destino, LocalDate dataPostagem, LocalDate dataEntregaPrev, LocalDate dataEntregaReal) {
        super();
        this.codigo = codigo;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.origem = origem;
        this.destino = destino;
        this.dataPostagem = dataPostagem;
        this.dataEntregaPrev = dataEntregaPrev;
        this.dataEntregaReal = dataEntregaReal;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getRemetente() {
        return remetente;
    }

    public void setRemetente(Integer remetente) {
        this.remetente = remetente;
    }

    public Integer getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Integer destinatario) {
        this.destinatario = destinatario;
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

    public LocalDate getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(LocalDate dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public LocalDate getDataEntregaPrev() {
        return dataEntregaPrev;
    }

    public void setDataEntregaPrev(LocalDate dataEntregaPrev) {
        this.dataEntregaPrev = dataEntregaPrev;
    }

    public LocalDate getDataEntregaReal() {
        return dataEntregaReal;
    }

    public void setDataEntregaReal(LocalDate dataEntregaReal) {
        this.dataEntregaReal = dataEntregaReal;
    }
}
