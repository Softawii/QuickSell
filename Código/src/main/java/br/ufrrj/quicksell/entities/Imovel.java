package br.ufrrj.quicksell.entities;

import br.ufrrj.quicksell.utils.Endereco;
import br.ufrrj.quicksell.utils.Data;
import br.ufrrj.quicksell.utils.EstadoDoImovel;
import br.ufrrj.quicksell.utils.TipoDeImovel;

import javax.swing.*;
import java.util.List;

public class Imovel {
    int area;
    int valor;
    String descricao;
    Endereco endereco;
    Data dataDeRegistro;
    List<ImageIcon> imagens;
    Proprietario proprietario;
    List<Proposta> listaDePropostas;
    TipoDeImovel tipoDeImovel;
    EstadoDoImovel estadoDoImovel;

    public Imovel(int valor, int area, String descricao, Endereco endereco) {
        this.valor = valor;
        this.area = area;
        this.descricao = descricao;
        this.endereco = endereco;
    }

    public int getArea() {
        return area;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
