package br.ufrrj.quicksell.entities;

import java.util.List;

public class Imobiliaria extends Proprietario {
    private String nome;
    private String cnpj;
    private String email;
    private List<Corretor> corretores;

    public Imobiliaria(String nome, String email, List<Imovel> imoveis, List<Corretor> corretores) {
        this.imoveis = imoveis;
        this.nome = nome;
        this.email = email;
        this.corretores = corretores;
    }

    public Usuario pegarResponsavel(Imovel imovelAtual) {
        for(Corretor corretor : corretores) {
            if(corretor.checarResponsabilidade(imovelAtual))
                return (Usuario) corretor;
        }
        return null;
    }


    public String getNome() {
        return "Imobili\u00E1ria " + nome;
    }


    public String getEmail(){
        return email;
    }

}
