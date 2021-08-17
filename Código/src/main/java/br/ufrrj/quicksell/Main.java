package br.ufrrj.quicksell;

import br.ufrrj.quicksell.entities.Property;
import br.ufrrj.quicksell.utils.Adress;
import br.ufrrj.quicksell.utils.Date;
import br.ufrrj.quicksell.views.HomeFrame;
import br.ufrrj.quicksell.views.LoginFrame;
import br.ufrrj.quicksell.views.PropertyFrame;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;

import javax.swing.*;

public class Main {
    // loginFrameWidth = 400;
    // loginFrameHeight = 500;
    public static void main(String[] args) {
        FlatCyanLightIJTheme.setup();

        new HomeFrame(1024, 720);
        new LoginFrame(400, 500);

        Adress adress = new Adress("Soares", "26379060", "Vila Sao Joao", "40", "Queimados", "Rio de Janeiro", " ");
        Property property = new Property(250, 250000, "Totalmente mobilada e excelente bairro. Realmente uma das casas ja vistas, mt braba msm",
               adress, new Date(20,02,2001));

        new PropertyFrame(property);
    }
}