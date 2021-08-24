package br.ufrrj.quicksell.entities;

import br.ufrrj.quicksell.utils.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class Imovel {
    int area;
    float valor;
    String descricao;
    Endereco endereco;
    Data dataDeRegistro;
    ImageIcon imagem;
    Proprietario proprietario;
    List<Proposta> listaDePropostas;
    TipoDeImovel tipoDeImovel;
    EstadoDoImovel estadoDoImovel;

    public Imovel(int valor, int area, String descricao, Endereco endereco, Proprietario proprietario, String path, TipoDeImovel tipoDeImovel) {
        this.valor = valor;
        this.area = area;
        this.descricao = descricao;
        this.endereco = endereco;
        this.proprietario = proprietario;
        listaDePropostas = new ArrayList<Proposta>();
        Imovel o = new Imovel();
        imagem = new ImageIcon(requireNonNull(o.getClass().getClassLoader().getResource(path)));
        this.tipoDeImovel = tipoDeImovel;
    }

    public Imovel () {

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

    public ImageIcon getImagem(int width, int height) {
        return Util.getImageWidth(imagem, width, height);
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
