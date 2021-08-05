package br.ufrrj.quicksell;

import br.ufrrj.quicksell.views.HomeFrame;
import br.ufrrj.quicksell.views.LoginFrame;
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
    }
}