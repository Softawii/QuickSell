package br.ufrrj.quicksell.views.panels;


import br.ufrrj.quicksell.controlers.Sistema;
import br.ufrrj.quicksell.entities.Usuario;

import javax.swing.*;
import java.awt.*;

import static br.ufrrj.quicksell.utils.Util.getImageWidth;

public class MenuPanel extends JPanel {
    private JPanel header;

    private JPanel body;
    private JLabel iconImage;
    private JLabel nameLabel;
    private JButton profileButton;
    private JButton propertyButton;
    private JButton signOutButton;

    private JPanel footer;
    private JLabel footerLabel;


    public MenuPanel(Usuario usuario){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(160, 1));
        {
            // Header Inicio
            header = new JPanel();
            this.add(header, BorderLayout.NORTH);
            // Header Final


            // Body Inicio
            body = new JPanel();
            body.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4, new Color(190, 190, 190)));
            body.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            {
                // iconImage Inicio
                iconImage = new JLabel();
                ImageIcon image = getImageWidth("LoginIcon.png", 100, 100);
                iconImage.setIcon(image);
                iconImage.setText("QUICKSELL");
                iconImage.setHorizontalTextPosition(JLabel.CENTER);
                iconImage.setVerticalTextPosition(JLabel.BOTTOM);
                iconImage.setFont(new Font("Segoe UI", Font.ITALIC, 24));
                {
                    gbc.anchor = GridBagConstraints.CENTER;
                    gbc.weighty = 0.05;
                    gbc.insets = new Insets(0, 10, 10, 10);
                }
                body.add(iconImage, gbc);
                // iconImage Final


                nameLabel = new JLabel("Ol\u00E1, " + usuario.getPrimeiroNome());
                nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
                {
                    gbc.insets = new Insets(0, 10, 5, 10);
                    gbc.gridy = 1;
                }
                body.add(nameLabel, gbc);

                profileButton = new JButton("Perfil");
                profileButton.setBackground(new Color(211, 211,211));
                {
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    gbc.gridy = 2;
                }
                body.add(profileButton, gbc);

                propertyButton = new JButton("Im\u00F3veis");
                propertyButton.setBackground(new Color(211, 211,211));
                {
                    gbc.gridy = 3;
                }
                body.add(propertyButton, gbc);

                JLabel spacing = new JLabel();
                {
                    gbc.gridy = 4;
                    gbc.weighty = 2.0;
                }
                body.add(spacing, gbc);

                signOutButton = new JButton("Sair");
                signOutButton.setBackground(new Color(211, 211,211));
                {
                    gbc.gridy = 5;
                    gbc.fill = GridBagConstraints.NONE;
                    gbc.weighty = 0.05;
                }
                body.add(signOutButton, gbc);
            }
            this.add(body, BorderLayout.CENTER);
            // Body Final

            // Footer Inicio
            footer = new JPanel();
            {
                footerLabel = new JLabel("V2.0.0");
                footer.add(footerLabel);
            }
            this.add(footer, BorderLayout.SOUTH);
            // Footer Final
        }
    }

}
