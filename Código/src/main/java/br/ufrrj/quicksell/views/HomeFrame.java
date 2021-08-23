package br.ufrrj.quicksell.views;

import br.ufrrj.quicksell.controlers.Sistema;
import br.ufrrj.quicksell.entities.Corretor;
import br.ufrrj.quicksell.entities.Imovel;
import br.ufrrj.quicksell.entities.Usuario;
import br.ufrrj.quicksell.views.panels.FilterPanel;
import br.ufrrj.quicksell.views.panels.HomeCenterPanel;
import br.ufrrj.quicksell.views.panels.MenuPanel;
import br.ufrrj.quicksell.views.panels.PropertyContainerPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static br.ufrrj.quicksell.utils.Util.getImageWidth;
import static java.util.Objects.requireNonNull;

public class HomeFrame extends JFrame {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 720;

    private JPanel west;

    private JPanel center;

    public HomeFrame() {
        super();
        ImageIcon image = new ImageIcon(requireNonNull(this.getClass().getClassLoader().getResource("LoginIcon.png")));
        this.setIconImage(image.getImage());
        this.setTitle("Quicksell"); //Bota t�tulo
        this.setSize(WIDTH, HEIGHT); //Muda o tamanho
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fechar a aplica��o ao clicar no X
        this.setResizable(true); //Permite que o usu�rio mude o tamanho da janela
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(0,5));

        west = new MenuPanel(this);
        this.add(west, BorderLayout.WEST);

        center = new HomeCenterPanel(this);
        this.add(center, BorderLayout.CENTER);

        this.setVisible(true); //Faz o this ser visivel
    }


    public void setCenter(JPanel center) {
        this.center.setVisible(false);
        this.remove(center);
        this.center = center;
        this.add(center, BorderLayout.CENTER);
    }
}
