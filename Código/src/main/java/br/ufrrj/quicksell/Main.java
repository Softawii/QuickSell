package br.ufrrj.quicksell;

import br.ufrrj.quicksell.controlers.Sistema;
import br.ufrrj.quicksell.entities.Imovel;
import br.ufrrj.quicksell.entities.Usuario;
import br.ufrrj.quicksell.utils.Endereco;
import br.ufrrj.quicksell.utils.Data;
import br.ufrrj.quicksell.views.HomeFrame;
import br.ufrrj.quicksell.views.LoginFrame;
import br.ufrrj.quicksell.views.PropertyFrame;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;

public class Main {
    // loginFrameWidth = 400;
    // loginFrameHeight = 500;
    public static void main(String[] args) {
        FlatCyanLightIJTheme.setup();

        Endereco endereco = new Endereco("Soares", "26379060", "Vila Sao Joao sdfsdaffsdafsda", "40", "Queimados", "Rio de Janeiro", " ");
        Imovel imovel = new Imovel(250, 250000, "Totalmente mobilada e excelente bairro. Realmente uma das casas ja vistas, mt braba msm",
                endereco);

        Endereco endereco1 = new Endereco("Irene", "26276370", "Comendador", "000", "Nova Iguaçu", "Rio de Janeiro", " ");
        Imovel imovel1 = new Imovel(1, -1, "ALO ALO ALO QUEM LEU MAMOU",
                endereco1);

        Endereco endereco2 = new Endereco(" De baixo", "666", "inferno", "666", "Sétimo ciclo", "ali", " ");
        Imovel imovel2 = new Imovel(666, 250000, "local seguro e bem climatizado, perfeito para crianças",
                endereco2);

        Sistema.pegarInstancia().addImovel(imovel);
        Sistema.pegarInstancia().addImovel(imovel1);
        Sistema.pegarInstancia().addImovel(imovel2);

        Sistema.pegarInstancia().addUsuario(new Usuario("sergio", "123"));
        Sistema.pegarInstancia().addUsuario(new Usuario("nicolas", "321"));

        new LoginFrame(400, 500);

        /*
        Endereco endereco = new Endereco("Soares", "26379060", "Vila Sao Joao", "40", "Queimados", "Rio de Janeiro", " ");
        Imovel imovel = new Imovel(250, 250000, "Totalmente mobilada e excelente bairro. Realmente uma das casas ja vistas, mt braba msm",
                endereco, new Data(20,02,2001));

        new PropertyFrame(imovel);*/
    }
}