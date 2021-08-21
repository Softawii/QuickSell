package br.ufrrj.quicksell.entities;

import java.util.List;

public class Corretor extends Usuario {
    private String creci;
    private Imobiliaria imobiliaria;
    private List<Imovel> imoveisResponsaveis;

    public Corretor(String email, String senha) {
        super(email, senha);
    }

    private void addImovel(Imovel imovel){}
    private List<Proposta> pegarPropostasdaImobiliaria(){ return null; }







}
