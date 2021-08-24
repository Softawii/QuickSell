package br.ufrrj.quicksell;

import br.ufrrj.quicksell.controlers.Sistema;
import br.ufrrj.quicksell.entities.Corretor;
import br.ufrrj.quicksell.entities.Imobiliaria;
import br.ufrrj.quicksell.entities.Imovel;
import br.ufrrj.quicksell.entities.Usuario;
import br.ufrrj.quicksell.utils.Endereco;
import br.ufrrj.quicksell.utils.TipoDeImovel;
import br.ufrrj.quicksell.views.LoginFrame;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // loginFrameWidth = 400;
    // loginFrameHeight = 500;
    public static void main(String[] args) {
        FlatCyanLightIJTheme.setup();

        Endereco endereco = new Endereco("Soares", "26379060", "Vila S\u00E3o Jo\u00E3o", "40", "Queimados", "Rio de Janeiro", " ");
        Endereco endereco1 = new Endereco("Irene", "26276370", "Comendador Soares", "000", "Nova Igua\u00E7u", "Rio de Janeiro", " ");
        Endereco endereco2 = new Endereco("Meriti", "21211007", "Vila da Penha", "777", "Rio de Janeiro", "Rio de Janeiro", " ");
        Endereco endereco3 = new Endereco("Volta", "21220000", "Vila da Penha", "123", "Rio de Janeiro", "Rio de Janeiro", " ");
        Endereco endereco4 = new Endereco("das Am\u00E9ricas", "22640602", "Cordovil", "10", "Rio de Janeiro", "Rio de Janeiro", " ");
        Endereco endereco5 = new Endereco("Wesley Advicunha de Souza", "26292492", "Campo Alegre", "27", "Nova Igua\u00E7u", "Rio de Janeiro", " ");

        List<Imovel> listaNicolas = new ArrayList<Imovel>();
        List<Imovel> listaSergio = new ArrayList<Imovel>();
        List<Imovel> listaImobiliaria = new ArrayList<Imovel>();
        List<Imovel> listaRespCorretor = new ArrayList<Imovel>();
        List<Imovel> listaRespCorretor1 = new ArrayList<Imovel>();
        List<Corretor> corretores = new ArrayList<Corretor>();

        Usuario nicolas = new Usuario("Nicolas Magalh\u00E3es", "123456789", "26656666", endereco1, "nicolas@gmail.com", "123", listaNicolas);
        Usuario sergio = new Usuario("S\u00E9rgio Felipe", "027456712", "90909090", endereco, "sergio@gmail.com", "123", listaSergio);
        Corretor corretor = new Corretor("Eduardo Vieira", "867491273", "12345678", endereco2,"corretor@gmail.com","123", listaRespCorretor);
        Corretor corretor1 = new Corretor("Bruno Almeida", "456172367", "54612678", endereco2,"corretor1@gmail.com","123", listaRespCorretor1);

        corretores.add(corretor);
        corretores.add(corretor1);

        Imobiliaria imobiliaria = new Imobiliaria("Imor Tal", "imorTal@gmail.com", listaImobiliaria, corretores);

        Imovel imovelSergio = new Imovel(950000, 200, "Casa totalmente mobiliada, com 4 quartos(2 su\u00EDtes), 1 banheiro, 1 cozinha e 2 salas de estar. \u00C1rea de lazer com piscina e churrasqueira.",
                endereco, sergio, "Casa_Braba.jpg", TipoDeImovel.RESIDENCIAL);

        Imovel imovelNicolas = new Imovel(180000, 100, "Apenas o terreno, \u00E1rea nobre de Nova de Igua\u00E7u.",
                endereco1, nicolas, "Terreno_Baldio.jpg", TipoDeImovel.RESIDENCIAL);

        Imovel imovelImo1 = new Imovel(300000, 80, "Casa pronta, sem mobilia, com 2 quartos, 1 cozinha e 1 banheiro.",
                endereco2, imobiliaria, "Casa_Simples.jpg", TipoDeImovel.RESIDENCIAL);

        Imovel imovelImo2 = new Imovel(120000, 45, "Quitinete na grande cidade do Rio de Janeiro.",
                endereco3, imobiliaria, "Quitinete.jpg", TipoDeImovel.RESIDENCIAL);

        Imovel imovelImo3 = new Imovel(400000, 70, "Apartamento em condom\u00EDnio fechado, excelente para crian\u00E7as.",
                endereco4, imobiliaria, "Apartamento.jpg", TipoDeImovel.RESIDENCIAL);

        Imovel imovelImo4 = new Imovel(100000, 200, "Uma \u00F3tima oportunidade, local aconchegante, com 3 quarto, 2 banheiros, 1 por\u00E3o bem escuro e totalmente seguro.",
                endereco5, imobiliaria, "Casa_Segura.jpg", TipoDeImovel.RESIDENCIAL);

        listaRespCorretor.add(imovelImo1);
        listaRespCorretor.add(imovelImo4);
        listaRespCorretor1.add(imovelImo2);
        listaRespCorretor1.add(imovelImo3);


        listaNicolas.add(imovelNicolas);
        listaSergio.add(imovelSergio);

        listaImobiliaria.add(imovelImo1);
        listaImobiliaria.add(imovelImo2);
        listaImobiliaria.add(imovelImo3);
        listaImobiliaria.add(imovelImo4);

        Sistema.pegarInstancia().addImovel(imovelImo1);
        Sistema.pegarInstancia().addImovel(imovelImo2);
        Sistema.pegarInstancia().addImovel(imovelImo3);
        Sistema.pegarInstancia().addImovel(imovelImo4);
        Sistema.pegarInstancia().addImovel(imovelNicolas);
        Sistema.pegarInstancia().addImovel(imovelSergio);
        Sistema.setImobiliaria(imobiliaria);
        Sistema.pegarInstancia().addUsuario(sergio);
        Sistema.pegarInstancia().addUsuario(nicolas);
        Sistema.pegarInstancia().addUsuario(corretor);
        Sistema.pegarInstancia().addUsuario(corretor1);


        new LoginFrame();
    }
}