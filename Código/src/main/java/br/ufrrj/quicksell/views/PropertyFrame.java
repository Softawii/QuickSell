package br.ufrrj.quicksell.views;

import br.ufrrj.quicksell.controlers.Sistema;

import br.ufrrj.quicksell.entities.Imovel;
import br.ufrrj.quicksell.views.panels.MenuPanel;
import br.ufrrj.quicksell.views.panels.PropertyContainerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.util.Objects.requireNonNull;

public class PropertyFrame extends JFrame {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 720;
    private Imovel imovel;

    private JPanel west;

    private JPanel center;
    private JPanel centerHeader;
    private JPanel centerBody;
    private JPanel centerFooter;

    public PropertyFrame(Imovel imovel) {
        super();
        this.imovel = imovel;
        ImageIcon image = new ImageIcon(requireNonNull(this.getClass().getClassLoader().getResource("LoginIcon.png")));
        this.setIconImage(image.getImage());
        this.setTitle("Quicksell"); //Bota t�tulo
        this.setSize(WIDTH, HEIGHT); //Muda o tamanho
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fechar a aplica��o ao clicar no X
        this.setResizable(true); //Permite que o usu�rio mude o tamanho da janela
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(0,5));

        west = new MenuPanel(this, Sistema.pegarInstancia().getUsuarioAtual());

        this.add(west, BorderLayout.WEST);

        createCenter();

        this.setVisible(true);
    }

    public void createCenter() {
        center = new JPanel();
        center.setLayout(new BorderLayout());
        {
            centerBody = new JPanel();
                
            center.add(centerBody, BorderLayout.CENTER);

            centerFooter = new JPanel();
            center.add(centerFooter, BorderLayout.SOUTH);
        }
        this.add(center, BorderLayout.CENTER);
    }

}
