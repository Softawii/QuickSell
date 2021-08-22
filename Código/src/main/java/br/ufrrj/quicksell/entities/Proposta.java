package br.ufrrj.quicksell.entities;

import br.ufrrj.quicksell.utils.Data;

public class Proposta {
    private float valorInicial;
    private String descricao;
    private Data data;
    private Usuario proponente;
    private Imovel imovel;

    public Proposta(float valorInicial, String descricao, Data data, Usuario proponente, Imovel imovel) {
        this.valorInicial = valorInicial;
        this.descricao = descricao;
        this.data = data;
        this.proponente = proponente;
        this.imovel = imovel;
    }

    public Usuario getProponente() {
        return proponente;
    }

    public float getValorInicial() {
        return valorInicial;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Proposta{" +
                "valorInicial=" + valorInicial +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", proponente=" + proponente +
                ", imovel=" + imovel +
                '}';
    }
}

