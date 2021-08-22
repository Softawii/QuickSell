package br.ufrrj.quicksell.entities;

import java.util.List;

public class Imobiliaria extends Proprietario {
    private String nome;
    private String cnpj;
    private List<Corretor> corretores;

    public Imobiliaria(String nome, List<Imovel> imoveis) {
        this.imoveis = imoveis;
        this.nome = nome;
    }

    Corretor pegarResposavel(Imovel imovelAtual) {
        return null;
    }
}
