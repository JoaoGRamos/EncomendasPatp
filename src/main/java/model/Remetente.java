package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class Remetente implements Serializable{

    @Id
    private Integer id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String telefone;

    public Remetente() {

    }

    public Remetente(Integer id, String nome, String cpf, String telefone) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
