package br.ufrrj.quicksell.views;

import br.ufrrj.quicksell.entities.Property;
import br.ufrrj.quicksell.utils.Adress;
import br.ufrrj.quicksell.views.panels.FilterPanel;
import br.ufrrj.quicksell.views.panels.MenuPanel;
import br.ufrrj.quicksell.views.panels.PropertyContainerPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

import static br.ufrrj.quicksell.utils.Util.getImageWidth;
import static java.util.Objects.requireNonNull;

public class HomeFrame extends JFrame {

    private JPanel west;

    private JPanel center;

    private JPanel centerHeader;

    private JPanel centerBody;
    private JScrollPane scrollBody;
    private ArrayList<JPanel> propertyContainer;

    private JPanel centerFooter;
    private JLabel centerFooterLabel;

    public ArrayList<Property> properties;

    public HomeFrame(int width, int height) {
        super();
        ImageIcon image = new ImageIcon(requireNonNull(this.getClass().getClassLoader().getResource("LoginIcon.png")));
        this.setIconImage(image.getImage());
        this.setTitle("Quicksell"); //Bota t�tulo
        this.setSize(width, height); //Muda o tamanho
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fechar a aplica��o ao clicar no X
        this.setResizable(true); //Permite que o usu�rio mude o tamanho da janela
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(0,5));


        west = new MenuPanel();
        this.add(west, BorderLayout.WEST);
        createCenter();

        this.setVisible(true); //Faz o this ser visivel
    }

    public void createCenter() {
        center = new JPanel();
        center.setLayout(new BorderLayout());
        {
            centerHeader = new FilterPanel();
            center.add(centerHeader, BorderLayout.NORTH);

            scrollBody = new JScrollPane();
            centerBody = new JPanel();
            centerBody.setLayout(new GridBagLayout());
            GridBagConstraints gbc2 = new GridBagConstraints();
            gbc2.gridy = 0;
            gbc2.insets = new Insets(10,0, 10, 0);
            {
                for(int i = 0; i < 20; i++, gbc2.gridy += 1){
                    PropertyContainerPanel pcp = new PropertyContainerPanel(250000, 250, "Totalmente mobilada e excelente bairro. Realmente uma das casas ja vistas, mt braba msm",
                            new Adress("Soares", "26379060", "Vila Sao Joao", "40", "Queimados", "Rio de Janeiro", " "));
                    centerBody.add(pcp, gbc2);
                }
            }
            scrollBody = new JScrollPane(centerBody);
            scrollBody.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            scrollBody.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollBody.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollBody.getVerticalScrollBar().setUnitIncrement(15);
            center.add(scrollBody, BorderLayout.CENTER);


            centerFooter = new JPanel();
            {
                centerFooterLabel = new JLabel("\u00A9 2021 QuickSell ");
                centerFooter.add(centerFooterLabel);
            }
            center.add(centerFooter, BorderLayout.SOUTH);
        }
        this.add(center, BorderLayout.CENTER);
    }
}
