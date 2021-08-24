package br.ufrrj.quicksell.controlers;


import br.ufrrj.quicksell.entities.*;
import br.ufrrj.quicksell.utils.Data;
import br.ufrrj.quicksell.views.HomeFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
    private static Sistema instancia;
    private static List<Usuario> listaDeUsuarios;
    private Usuario usuarioAtual;

    private static List<Imovel> listaDeImoveis;
    private static List<Imovel> listaDeImoveisFiltrada;
    private Imovel imovelAtual;

    private static Imobiliaria imobiliaria;

    private Data data;

    private Sistema() { }

    public static synchronized Sistema pegarInstancia() {
        if(instancia == null){
            instancia = new Sistema();
            listaDeUsuarios = new ArrayList<Usuario>();
            listaDeImoveis = new ArrayList<Imovel>();
        }

        return instancia;
    }

    public boolean fazerLogin(String email, String senha) {
        Usuario usuario = filtrarUsuarioPorEmail(email);
        if(usuario == null)
            System.out.println("Não existe usuario com esse email");
        else
        {
            if(usuario.getSenha().equals(senha)) {
                usuarioAtual = usuario;
                criarListaFiltradaParaUsuario();
                new HomeFrame();
                return true;
            }
            else
                System.out.println("Senha incorreta");

        }
        return false;
    }

    public Usuario filtrarUsuarioPorEmail (String email) {
        for (Usuario usuario : listaDeUsuarios ) {
            if(usuario.getEmail().equals(email))
                return usuario;
        }
        return null;
    }

    public void selecionarImovel(Imovel imovel) {
        this.imovelAtual = imovel;
    }

    public void deslogar() {
        usuarioAtual = null;
    }

    public void criarListaFiltradaParaUsuario() {
        listaDeImoveisFiltrada = new ArrayList<Imovel>();

        if(usuarioAtual instanceof Corretor){
            listaDeImoveisFiltrada.addAll(listaDeImoveis);
            return;
        }

        for(Imovel imovel : listaDeImoveis)
            if(imovel.getProprietario() instanceof Imobiliaria) {
                listaDeImoveisFiltrada.add(imovel);
            }
    }

    public void fazerProposta(float valor, String descricao) {
        Proposta proposta = usuarioAtual.criarProposta(imovelAtual, valor, descricao, data);
        imovelAtual.addProposta(proposta);
    }

    public static Imobiliaria getImobiliaria() {
        return imobiliaria;
    }

    public static void setImobiliaria(Imobiliaria imobiliaria) {
        Sistema.imobiliaria = imobiliaria;
    }

    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public Imovel getImovelAtual() {
        return imovelAtual;
    }

    public static List<Imovel> getListaDeImoveisFiltrada() {
        return listaDeImoveisFiltrada;
    }

    public void addUsuario (Usuario usuario) {
        listaDeUsuarios.add(usuario);
    }

    public void addImovel (Imovel imovel) {
        listaDeImoveis.add(imovel);
    }

    public void filtrarPorPreco(float menorQue, float maiorQue) {
        listaDeImoveisFiltrada = listaDeImoveisFiltrada.stream().filter(imovel -> {
            return imovel.getValor() <= menorQue && imovel.getValor() >= maiorQue;
        }).collect(Collectors.toList());
        for (Imovel imovel : listaDeImoveisFiltrada)
        {
            System.out.println(imovel.getValor());
        }
    }

    public void filtrarPorBairro(String bairro) {
        listaDeImoveisFiltrada = listaDeImoveisFiltrada.stream().filter(imovel -> {
            return imovel.getEndereco().getBairro().equals(bairro);
        }).collect(Collectors.toList());
    }

    public void filtrarPorTipo(String tipo) {
        listaDeImoveisFiltrada = listaDeImoveisFiltrada.stream().filter(imovel -> {
            return imovel.getTipoDeImovelString().equals(tipo);
        }).collect(Collectors.toList());
    }
}

