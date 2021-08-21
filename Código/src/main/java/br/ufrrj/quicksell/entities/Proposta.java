package br.ufrrj.quicksell.entities;

import br.ufrrj.quicksell.utils.Data;

public class Proposta {
    private int valorInicial;
    private String descricao;
    private Data data;
    private Usuario aceitante;
    private Usuario proponente;
    private Imovel imovel;
}
