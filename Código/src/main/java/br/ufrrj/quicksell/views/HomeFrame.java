package br.ufrrj.quicksell.views;

import br.ufrrj.quicksell.entities.Property;
import br.ufrrj.quicksell.utils.Adress;
import br.ufrrj.quicksell.views.panels.PropertyContainerPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

import static br.ufrrj.quicksell.utils.Util.getImageWidth;
import static java.util.Objects.requireNonNull;

public class HomeFrame extends JFrame {

    private JPanel west;

    private JPanel westHeader;
    private JLabel iconImage;

    private JPanel westBody;
    private JLabel nameLabel;
    private JButton profileButton;
    private JButton propertyButton;
    private JButton signOutButton;

    private JPanel westFooter;
    private JLabel westFooterLabel;

    private JPanel center;

    private JPanel centerHeader;

    private String[] filterStrings;

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
        filterStrings = new String[2];
        filterStrings[0] = "teste";
        filterStrings[1] = "teste2";


        createWest();
        createCenter();

        this.setVisible(true); //Faz o this ser visivel
    }

    public void createWest() {
        west = new JPanel();
        west.setBackground(Color.red);
        west.setLayout(new BorderLayout());
        {
            // WestHeader Inicio
            westHeader = new JPanel();
            west.add(westHeader, BorderLayout.NORTH);
            // WestHeader Final


            // WestBody Inicio
            westBody = new JPanel();
            westBody.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4, new Color(190, 190, 190)));
            westBody.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            {
                // iconImage Inicio
                iconImage = new JLabel();
                ImageIcon image = getImageWidth("LoginIcon.png", 100, 100);
                iconImage.setIcon(image);
                iconImage.setText("QUICKSELL");
                iconImage.setHorizontalTextPosition(JLabel.CENTER);
                iconImage.setVerticalTextPosition(JLabel.BOTTOM);
                iconImage.setFont(new Font("Cooper Std Black", Font.ITALIC, 24));
                {
                    gbc.anchor = GridBagConstraints.CENTER;
                    gbc.weighty = 0.05;
                    gbc.insets = new Insets(0, 10, 10, 10);
                }
                westBody.add(iconImage, gbc);
                // iconImage Final


                nameLabel = new JLabel("S\u00E9rgio Rezende");
                nameLabel.setFont(new Font("Cooper Std Black", Font.BOLD, 15));
                {
                    gbc.insets = new Insets(0, 10, 5, 10);
                    gbc.gridy = 1;
                }
                westBody.add(nameLabel, gbc);

                profileButton = new JButton("Profile");
                profileButton.setBackground(new Color(211, 211,211));
                {
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    gbc.gridy = 2;
                }
                westBody.add(profileButton, gbc);

                propertyButton = new JButton("Properties");
                propertyButton.setBackground(new Color(211, 211,211));
                {
                    gbc.gridy = 3;
                }
                westBody.add(propertyButton, gbc);

                JLabel spacing = new JLabel();
                {
                    gbc.gridy = 4;
                    gbc.weighty = 2.0;
                }
                westBody.add(spacing, gbc);

                signOutButton = new JButton("Sign Out");
                signOutButton.setBackground(new Color(211, 211,211));
                {
                    gbc.gridy = 5;
                    gbc.fill = GridBagConstraints.NONE;
                    gbc.weighty = 0.05;
                }
                westBody.add(signOutButton, gbc);
            }
            west.add(westBody, BorderLayout.CENTER);
            // WestBody Final


            westFooter = new JPanel();
            //westFooter.setBackground(Color.green);
            {
                westFooterLabel = new JLabel("V2.0.0");
                westFooter.add(westFooterLabel);
            }
            west.add(westFooter, BorderLayout.SOUTH);

        }
        this.add(west, BorderLayout.WEST);
    }

    public void createCenter() {
        center = new JPanel();
        center.setLayout(new BorderLayout());
        {
            centerHeader = new JPanel();
            centerHeader.setLayout(new GridBagLayout());
            centerHeader.setBorder(BorderFactory.createTitledBorder("Search Filter: "));
            GridBagConstraints gbc = new GridBagConstraints();
            {
                JCheckBox districtFilterCheck = new JCheckBox("District");
                {
                    gbc.weightx = 1;
                    gbc.gridx = 0;
                    gbc.anchor = GridBagConstraints.NORTH;

                    JTextField districtSearch = new JTextField(10);
                    gbc.gridy = 1;
                    centerHeader.add(districtSearch, gbc);
                    gbc.gridy = 0;
                }
                centerHeader.add(districtFilterCheck, gbc);

                JCheckBox priceFilterCheck = new JCheckBox("Price");
                {
                    gbc.gridx = 1;
                    gbc.gridy = 1;

                    JPanel priceFilterContainer = new JPanel();
                    priceFilterContainer.setLayout(new GridBagLayout());
                    GridBagConstraints gbcCont = new GridBagConstraints();

                    gbcCont.gridy = 0;
                    JLabel greaterThanLabel = new JLabel(">=");
                    priceFilterContainer.add(greaterThanLabel, gbcCont);
                    JTextField priceSearch_1 = new JTextField(5);
                    priceFilterContainer.add(priceSearch_1, gbcCont);

                    gbcCont.gridy = 1;
                    JLabel lessThanLabel = new JLabel("<=");
                    priceFilterContainer.add(lessThanLabel, gbcCont);
                    JTextField priceSearch_2 = new JTextField(5);
                    priceFilterContainer.add(priceSearch_2, gbcCont);

                    centerHeader.add(priceFilterContainer, gbc);
                    gbc.gridy = 0;
                }
                centerHeader.add(priceFilterCheck, gbc);

                JCheckBox propertyTypeFilterCheck = new JCheckBox("Property Type");
                {
                    gbc.gridx = 2;
                    String[] stringArr = new String[2];
                    stringArr[0] = "Residential";
                    stringArr[1] = "Comercial";
                    JComboBox propertyTypeBox = new JComboBox(stringArr);
                    gbc.gridy = 1;
                    centerHeader.add(propertyTypeBox, gbc);
                    gbc.gridy = 0;
                }
                centerHeader.add(propertyTypeFilterCheck, gbc);

                JButton filterButton = new JButton();
                filterButton.setBackground(new Color(37, 138,164));
                filterButton.setLayout(new BorderLayout());
                JLabel buttonLabel = new JLabel("Filter");
                buttonLabel.setForeground(Color.white);
                buttonLabel.setHorizontalAlignment(JLabel.CENTER);
                buttonLabel.setHorizontalTextPosition(JLabel.CENTER);
                filterButton.add(buttonLabel);
                {
                    gbc.gridx = 3;
                    gbc.gridy = 1;
                }
                centerHeader.add(filterButton, gbc);
            }
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
