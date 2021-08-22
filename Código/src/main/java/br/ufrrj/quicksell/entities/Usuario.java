package br.ufrrj.quicksell.entities;

import br.ufrrj.quicksell.utils.Data;
import br.ufrrj.quicksell.utils.Endereco;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Proprietario {
    private String nome;
    private String cpf;
    private Endereco endereco;
    private String telefone;
    private String email;
    private String senha;
    private List<Proposta> propostasRealizadas;

    public Usuario (String nome, Endereco endereco, String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.imoveis = new ArrayList<Imovel>();
        this.propostasRealizadas = new ArrayList<Proposta>();
    }

    public Usuario (String nome, Endereco endereco, String email, String senha, List<Imovel> imoveis) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.imoveis = imoveis;
        this.propostasRealizadas = new ArrayList<Proposta>();
    }

    public Proposta criarProposta(Imovel imovelAtual, float valor, String descricao, Data data){
        Proposta proposta = new Proposta(valor, descricao, data, this, imovelAtual);
        propostasRealizadas.add(proposta);
        return proposta;
    }

    public void registrarImovel(Imovel imovel){}

    public void atualizarInformacoes(String nome, String cpf, Endereco Endereco, String telefone, String email, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getPrimeiroNome() {
        String[] nomes = nome.split(" ");
        return nomes[0];
    }

    public String getEmail() {
        return email;
    }

}
