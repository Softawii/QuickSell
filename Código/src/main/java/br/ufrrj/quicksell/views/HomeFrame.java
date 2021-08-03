package br.ufrrj.quicksell.views;

import br.ufrrj.quicksell.entities.Property;

import javax.swing.*;
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
    private JTextField searchField;
    private JButton searchButton;
    private JButton filterButton;

    private JPanel centerBody;
    private ArrayList<JPanel> propertyContainer;
    private JLabel propertyImage;
    private JLabel adressLabel;
    private JLabel priceLabel;
    private JButton proposalButton;

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
                westFooterLabel = new JLabel("\u00A9 2021 QuickSell");
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
            GridBagConstraints gbc = new GridBagConstraints();
            {
                JLabel spacing1 = new JLabel();
                {
                    gbc.weightx = 2.0;
                }
                centerHeader.add(spacing1, gbc);

                searchField = new JTextField(50);
                {
                    gbc.fill = GridBagConstraints.VERTICAL;
                    gbc.weightx = 0.05;
                }
                centerHeader.add(searchField, gbc);

                searchButton = new JButton();
                ImageIcon image = getImageWidth("SearchIcon.png", 18, 17);
                searchButton.setIcon(image);
                centerHeader.add(searchButton, gbc);


                filterButton = new JButton("Filter");
                ImageIcon image2 = getImageWidth("FilterIcon.png", 15, 17);
                filterButton.setIcon(image2);
                centerHeader.add(filterButton, gbc);

                JLabel spacing2 = new JLabel();
                {
                    gbc.weightx = 2.0;
                }
                centerHeader.add(spacing2, gbc);

            }
            center.add(centerHeader, BorderLayout.NORTH);


            centerBody = new JPanel();
            centerBody.setLayout(new GridBagLayout());
            GridBagConstraints gbc2 = new GridBagConstraints();
            {
                propertyContainer = new ArrayList<JPanel>();
//                for(int i = 0; i < properties.size(); i++){
//                    JPanel temp = new JPanel();
//                    propertyContainer.add(temp);
//
//
//                }
            }
            center.add(centerBody, BorderLayout.CENTER);


            centerFooter = new JPanel();
            {
                centerFooterLabel = new JLabel("V2.0.0");
                centerFooter.add(centerFooterLabel);
            }
            center.add(centerFooter, BorderLayout.SOUTH);
        }
        this.add(center, BorderLayout.CENTER);
    }

}
