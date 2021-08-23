package br.ufrrj.quicksell.entities;

import br.ufrrj.quicksell.utils.Endereco;

import java.util.List;

public class Corretor extends Usuario {
    private String creci;
    private Imobiliaria imobiliaria;
    private List<Imovel> imoveisResponsaveis;



    private void addImovel(Imovel imovel){}
    private List<Proposta> pegarPropostasdaImobiliaria(){ return null; }

    public Corretor(String nome, String cpf, String telefone, Endereco endereco, String email, String senha) {
        super(nome, cpf, telefone, endereco, email, senha);
    }

    public Corretor(String nome, String cpf, String telefone, Endereco endereco, String email, String senha, List<Imovel> imoveis) {
        super(nome, cpf, telefone, endereco, email, senha, imoveis);
    }
}
