package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;

@Entity
public class Encomendas implements Serializable{

    @Id
    @GeneratedValue
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
    private LocalDate data_postagem;

    @Column
    private LocalDate data_entrega_prev;

    @Column
    private LocalDate data_entrega_real;

    public Encomendas() {

    }

    public Encomendas(Integer codigo, Integer remetente, Integer destinatario, Integer origem, Integer destino, LocalDate dataPostagem, LocalDate dataEntregaPrev, LocalDate dataEntregaReal) {
        super();
        this.codigo = codigo;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.origem = origem;
        this.destino = destino;
        this.data_postagem = dataPostagem;
        this.data_entrega_prev = dataEntregaPrev;
        this.data_entrega_real = dataEntregaReal;
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
        return data_postagem;
    }

    public void setDataPostagem(LocalDate dataPostagem) {
        this.data_postagem = dataPostagem;
    }

    public LocalDate getDataEntregaPrev() {
        return data_entrega_prev;
    }

    public void setDataEntregaPrev(LocalDate dataEntregaPrev) {
        this.data_entrega_prev = dataEntregaPrev;
    }

    public LocalDate getDataEntregaReal() {
        return data_entrega_real;
    }

    public void setDataEntregaReal(LocalDate dataEntregaReal) {
        this.data_entrega_real = dataEntregaReal;
    }
}
