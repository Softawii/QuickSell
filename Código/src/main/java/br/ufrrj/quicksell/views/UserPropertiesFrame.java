package br.ufrrj.quicksell.views;

import br.ufrrj.quicksell.controlers.Sistema;
import br.ufrrj.quicksell.entities.Imovel;
import br.ufrrj.quicksell.views.panels.FilterPanel;
import br.ufrrj.quicksell.views.panels.MenuPanel;
import br.ufrrj.quicksell.views.panels.PropertyContainerPanel;

import javax.swing.*;
import java.awt.*;

import static java.util.Objects.requireNonNull;

public class UserPropertiesFrame extends JFrame {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 720;


    private JPanel west;

    private JPanel center;
    private JPanel centerBody;

    private JPanel centerHeader;
    private JLabel title;
    private JScrollPane scrollBody;

    public UserPropertiesFrame() {
        super();
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


        centerHeader = new JPanel();


        createCenter();

        this.setVisible(true);
    }

    private void createCenter() {

        center = new JPanel();
        center.setLayout(new BorderLayout());
        {
            centerHeader = new JPanel();
            {
                title = new JLabel("Meus Im\u00F3veis");
                title.setFont(new Font("Segoe UI", Font.BOLD, 24));
                centerHeader.add(title);
            }
            center.add(centerHeader, BorderLayout.NORTH);

            if(Sistema.pegarInstancia().getUsuarioAtual().getImoveis().size() == 0)
            {
                centerBody = new JPanel();
                centerBody.setLayout(new GridBagLayout());
                JLabel warning = new JLabel("Voce nao tem imoveis registrados");
                warning.setFont(new Font("Cooper Std Black", Font.BOLD, 32));
                centerBody.add(warning);
                center.add(centerBody, BorderLayout.CENTER);
            }
            else{
                scrollBody = new JScrollPane();
                centerBody = new JPanel();
                centerBody.setLayout(new GridBagLayout());
                GridBagConstraints gbc2 = new GridBagConstraints();
                gbc2.gridy = 0;
                gbc2.insets = new Insets(10,0, 10, 0);
                {

                    for(Imovel imovel : Sistema.pegarInstancia().getUsuarioAtual().getImoveis()){
                        PropertyContainerPanel pcp = new PropertyContainerPanel(this, imovel);
                        gbc2.gridy += 1;
                        centerBody.add(pcp, gbc2);
                    }
                }
                scrollBody = new JScrollPane(centerBody);
                scrollBody.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
                scrollBody.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scrollBody.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollBody.getVerticalScrollBar().setUnitIncrement(15);
                center.add(scrollBody, BorderLayout.CENTER);
            }

        }
        this.add(center, BorderLayout.CENTER);

    }
}
