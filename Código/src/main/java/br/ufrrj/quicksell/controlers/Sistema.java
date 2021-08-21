package br.ufrrj.quicksell.controlers;


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
                new HomeFrame(1024, 720);
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

    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public Imovel getImovelAtual() {
        return imovelAtual;
    }

    public static List<Imovel> getListaDeImoveis() {
        return listaDeImoveis;
    }

    public void addUsuario (Usuario usuario) {
        listaDeUsuarios.add(usuario);
    }
    public void addImovel (Imovel imovel) {
        listaDeImoveis.add(imovel);
    }

}
