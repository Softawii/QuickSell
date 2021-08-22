package br.ufrrj.quicksell.controlers;


import br.ufrrj.quicksell.entities.Corretor;
import br.ufrrj.quicksell.entities.Imobiliaria;
import br.ufrrj.quicksell.entities.Imovel;
import br.ufrrj.quicksell.entities.Usuario;
import br.ufrrj.quicksell.views.HomeFrame;
import br.ufrrj.quicksell.views.PropertyFrame;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private static Sistema instancia;
    private static List<Usuario> listaDeUsuarios;
    private Usuario usuarioAtual;

    private static List<Imovel> listaDeImoveis;
    private Imovel imovelAtual;

    private static Imobiliaria imobiliaria;

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
        new PropertyFrame(imovel);
    }

    public void deslogar() {
        usuarioAtual = null;
    }

    public List<Imovel> pegarListaFiltradaParaUsuario() {
        if(usuarioAtual instanceof Corretor)
            return listaDeImoveis;

        List<Imovel> imoveisFiltrados = new ArrayList<Imovel>();
        for(Imovel imovel : listaDeImoveis)
            if(imovel.getProprietario() instanceof Imobiliaria) {
                imoveisFiltrados.add(imovel);
            }

        return imoveisFiltrados;
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

    public void addUsuario (Usuario usuario) {
        listaDeUsuarios.add(usuario);
    }

    public void addImovel (Imovel imovel) {
        listaDeImoveis.add(imovel);
    }

}

