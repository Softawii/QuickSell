package br.ufrrj.quicksell;

import br.ufrrj.quicksell.controlers.Sistema;
import br.ufrrj.quicksell.entities.Corretor;
import br.ufrrj.quicksell.entities.Imobiliaria;
import br.ufrrj.quicksell.entities.Imovel;
import br.ufrrj.quicksell.entities.Usuario;
import br.ufrrj.quicksell.utils.Endereco;
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
        Endereco endereco2 = new Endereco("De baixo", "666", "inferno", "666", "S\u00E9timo ciclo", "ali", " ");
        Endereco endereco3 = new Endereco("Rosana", "000111333", "Vila de Cava", "118", "Nova york", "RJ", " ");
        Endereco endereco4 = new Endereco("Santa Rosa", "123456789", "Cabu\u00E7u", "10", "Nova Igua\u00E7u", "RJ", " ");
        Endereco endereco5 = new Endereco("Ana", "18062001", "Luisa", "27", "May\u00E3o", "RJ", " ");

        List<Imovel> listaNicolas = new ArrayList<Imovel>();
        List<Imovel> listaSergio = new ArrayList<Imovel>();
        List<Imovel> listaImobiliaria = new ArrayList<Imovel>();
        List<Imovel> listaRespCorretor = new ArrayList<Imovel>();
        List<Imovel> listaRespCorretor1 = new ArrayList<Imovel>();
        List<Corretor> corretores = new ArrayList<Corretor>();

        Usuario nicolas = new Usuario("Nicolas Magalh\u00E3es", "123456789", "26656666", endereco1, "nicolas@gmail.com", "123", listaNicolas);
        Usuario sergio = new Usuario("S\u00E9rgio Felipe", "195345604", "90909090", endereco, "sergio@gmail.com", "123", listaSergio);
        Corretor corretor = new Corretor("Diogo Moreira", "867491273", "12345678", endereco2,"corretor@gmail.com","123", listaRespCorretor);
        Corretor corretor1 = new Corretor("Caio Araujo", "456172367", "54612678", endereco2,"corretor1@gmail.com","123", listaRespCorretor1);

        corretores.add(corretor);
        corretores.add(corretor1);

        Imobiliaria imobiliaria = new Imobiliaria("Imor Tal", "imorTal@gmail.com", listaImobiliaria, corretores);

        Imovel imovelSergio = new Imovel(250, 250000, "Totalmente mobilada e excelente bairro. Realmente uma das casas ja vistas, mt braba msm",
                endereco, sergio);

        Imovel imovelNicolas = new Imovel(1, -1, "ALO ALO ALO QUEM LEU MAMOU",
                endereco1, nicolas);

        Imovel imovelImo1 = new Imovel(500, 50, "Casa confortavel, grande e muito quintal iririri ",
                endereco2, imobiliaria);

        Imovel imovelImo2 = new Imovel(200000, 200, "Bairro seguro, excelente para a mulekada",
                endereco3, imobiliaria);

        Imovel imovelImo3 = new Imovel(900, 10, "Lugar top dmais slk...",
                endereco4, imobiliaria);

        Imovel imovelImo4 = new Imovel(900, 10, "Duvidei tu fazer um proposta, nem sabe fazer xD",
                endereco5, imobiliaria);

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

        Sistema.pegarInstancia().fazerLogin("nicolas@gmail.com", "123");

        /*
        Sistema.pegarInstancia().selecionarImovel(imovelNicolas);
        Sistema.pegarInstancia().fazerProposta(150, "UMA DAS PROPOSTAS JA FEITAS");
        Sistema.pegarInstancia().fazerProposta(150, "UMA DAS PROPOSTAS JA FEITAS");
        Sistema.pegarInstancia().fazerProposta(150, "UMA DAS PROPOSTAS JA FEITAS");



        //new LoginFrame();


        Endereco endereco = new Endereco("Soares", "26379060", "Vila Sao Joao", "40", "Queimados", "Rio de Janeiro", " ");
        Imovel imovel = new Imovel(250, 250000, "Totalmente mobilada e excelente bairro. Realmente uma das casas ja vistas, mt braba msm",
                endereco, new Data(20,02,2001));

        new PropertyFrame(imovel);*/
    }
}