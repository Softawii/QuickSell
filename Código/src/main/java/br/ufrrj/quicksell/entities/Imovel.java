package br.ufrrj.quicksell.entities;

import br.ufrrj.quicksell.utils.Endereco;
import br.ufrrj.quicksell.utils.Data;
import br.ufrrj.quicksell.utils.EstadoDoImovel;
import br.ufrrj.quicksell.utils.TipoDeImovel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Imovel {
    int area;
    float valor;
    String descricao;
    Endereco endereco;
    Data dataDeRegistro;
    List<ImageIcon> imagens;
    Proprietario proprietario;
    List<Proposta> listaDePropostas;
    TipoDeImovel tipoDeImovel;
    EstadoDoImovel estadoDoImovel;

    public Imovel(int valor, int area, String descricao, Endereco endereco, Proprietario proprietario) {
        this.valor = valor;
        this.area = area;
        this.descricao = descricao;
        this.endereco = endereco;
        this.proprietario = proprietario;
        listaDePropostas = new ArrayList<Proposta>();
    }

    public void addProposta(Proposta proposta) {
        listaDePropostas.add(proposta);
    }

    public int getArea() {
        return area;
    }

    public float getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public List<Proposta> getListaDePropostas() {
        return listaDePropostas;
    }

    public String getTipoDeImovelString() {
        return tipoDeImovel == TipoDeImovel.COMERCIAL ? "Comercial" : "Residencial";
    }
}
