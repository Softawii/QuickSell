package br.ufrrj.quicksell;

import br.ufrrj.quicksell.controlers.Sistema;
import br.ufrrj.quicksell.entities.Imobiliaria;
import br.ufrrj.quicksell.entities.Imovel;
import br.ufrrj.quicksell.entities.Usuario;
import br.ufrrj.quicksell.utils.Endereco;
import br.ufrrj.quicksell.utils.Data;
import br.ufrrj.quicksell.views.HomeFrame;
import br.ufrrj.quicksell.views.LoginFrame;
import br.ufrrj.quicksell.views.PropertyFrame;
import br.ufrrj.quicksell.views.UserPropertiesFrame;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // loginFrameWidth = 400;
    // loginFrameHeight = 500;
    public static void main(String[] args) {
        FlatCyanLightIJTheme.setup();

        Endereco endereco = new Endereco("Soares", "26379060", "Vila Sao Joao sdfsdaffsdafsda", "40", "Queimados", "Rio de Janeiro", " ");
        Endereco endereco1 = new Endereco("Irene", "26276370", "Comendador Soares", "000", "Nova Iguaçu", "Rio de Janeiro", " ");
        Endereco endereco2 = new Endereco(" De baixo", "666", "inferno", "666", "Sétimo ciclo", "ali", " ");

        List<Imovel> listaNicolas = new ArrayList<Imovel>();
        List<Imovel> listaSergio = new ArrayList<Imovel>();

        Usuario nicolas = new Usuario("nicolas", endereco1, "nicolas", "321", listaNicolas);
        Usuario sergio = new Usuario("sergio", endereco, "sergio", "123");

        List<Imovel> listaImobiliaria = new ArrayList<Imovel>();

        Imobiliaria imobiliaria = new Imobiliaria("Imor Tal", listaImobiliaria);


        Imovel imovelImo1 = new Imovel(250, 250000, "Totalmente mobilada e excelente bairro. Realmente uma das casas ja vistas, mt braba msm",
                endereco, imobiliaria);

        Imovel imovelNicolas = new Imovel(1, -1, "ALO ALO ALO QUEM LEU MAMOU",
                endereco1, nicolas);

        Imovel imovelImo2 = new Imovel(666, 250000, "local seguro e bem climatizado, perfeito para crianças",
                endereco2, imobiliaria);


        Sistema.pegarInstancia().addImovel(imovelImo1);
        Sistema.pegarInstancia().addImovel(imovelImo2);
        Sistema.pegarInstancia().addImovel(imovelNicolas);

        Sistema.setImobiliaria(imobiliaria);

        listaNicolas.add(imovelNicolas);

        listaImobiliaria.add(imovelImo1);
        listaImobiliaria.add(imovelImo2);



        Sistema.pegarInstancia().addUsuario(sergio);
        Sistema.pegarInstancia().addUsuario(nicolas);

        new LoginFrame();

        /*
        Endereco endereco = new Endereco("Soares", "26379060", "Vila Sao Joao", "40", "Queimados", "Rio de Janeiro", " ");
        Imovel imovel = new Imovel(250, 250000, "Totalmente mobilada e excelente bairro. Realmente uma das casas ja vistas, mt braba msm",
                endereco, new Data(20,02,2001));

        new PropertyFrame(imovel);*/
    }
}