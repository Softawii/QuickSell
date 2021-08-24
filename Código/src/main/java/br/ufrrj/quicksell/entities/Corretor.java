package br.ufrrj.quicksell.entities;

import br.ufrrj.quicksell.utils.Endereco;

import java.util.List;

public class Corretor extends Usuario {
    private String creci;
    private Imobiliaria imobiliaria;
    private List<Imovel> imoveisGerenciados;



    private void addImovel(Imovel imovel){}

    public Corretor(String nome, String cpf, String telefone, Endereco endereco, String email, String senha, List<Imovel> imoveisGerenciados) {
        super(nome, cpf, telefone, endereco, email, senha);
        this.imoveisGerenciados = imoveisGerenciados;
    }

    public Corretor(String nome, String cpf, String telefone, Endereco endereco, String email, String senha, List<Imovel> imoveis, List<Imovel> imoveisGerenciados) {
        super(nome, cpf, telefone, endereco, email, senha, imoveis);
        this.imoveisGerenciados = imoveisGerenciados;
    }

    public List<Imovel> getImoveisGerenciados() {
        return imoveisGerenciados;
    }

    public boolean checarResponsabilidade (Imovel imovel) {
        for(Imovel imovelIte : imoveisGerenciados) {
            if(imovelIte.equals(imovel))
                return true;
        }
        return false;
    }
}
