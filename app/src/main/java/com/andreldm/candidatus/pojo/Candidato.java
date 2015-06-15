package com.andreldm.candidatus.pojo;

/**
 * Created by andre on 6/15/15.
 */
public class Candidato {
    private String nome;
    private String descricao;

    public Candidato(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
