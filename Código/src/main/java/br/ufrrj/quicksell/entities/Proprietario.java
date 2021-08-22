package br.ufrrj.quicksell.entities;

import java.util.List;

public class Proprietario {

    protected List<Imovel> imoveis;
    public Usuario pegarResponsavel(Imovel imovelAtual){ return null; }
    public List<Proposta> pegarPropostas(){ return  null; }

    public List<Imovel> getImoveis() {
        return imoveis;
    }
}
