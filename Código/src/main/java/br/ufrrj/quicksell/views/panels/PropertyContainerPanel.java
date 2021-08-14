package br.ufrrj.quicksell.views.panels;

import br.ufrrj.quicksell.utils.Adress;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static br.ufrrj.quicksell.utils.Util.getImageWidth;

public class PropertyContainerPanel extends JPanel {

    private JLabel propertyImage;
    private JLabel priceLabel;
    private JLabel adressLabel;
    private JLabel areaLabel;
    private JTextArea descriptionLabel;
    private JButton imovelButton;

    public PropertyContainerPanel(int value, int area, String description, Adress adress) {
        Border padding = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border border = BorderFactory.createLineBorder(Color.lightGray, 5, true);
        //this.setBackground(Color.lightGray);
        this.setBorder(BorderFactory.createCompoundBorder(border, padding));
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();


        propertyImage = new JLabel();
        ImageIcon image = getImageWidth("Casa_Teste.jpg", 160, 140);
        propertyImage.setIcon(image);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 0;
        gbc.insets = new Insets(0, 0, 0, 10);
        gbc.gridheight = 4;
        gbc.weightx = 2;
        this.add(propertyImage, gbc);

        imovelButton = new JButton();
        imovelButton.setBackground(new Color(37, 138,164));
        imovelButton.setLayout(new BorderLayout());
        JLabel buttonLabel = new JLabel("Acessar Imovel");
        buttonLabel.setForeground(Color.white);
        buttonLabel.setHorizontalAlignment(JLabel.CENTER);
        buttonLabel.setHorizontalTextPosition(JLabel.CENTER);
        imovelButton.add(buttonLabel);
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.weighty = 2;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 10, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(imovelButton, gbc);


        priceLabel = new JLabel("R$" + Integer.toString(value) + ",00");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 25));
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.weightx = 0;
        this.add(priceLabel, gbc);

        descriptionLabel = new JTextArea(description);
        descriptionLabel.setWrapStyleWord(true);
        descriptionLabel.setLineWrap(true);
        descriptionLabel.setEditable(false);
        descriptionLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        descriptionLabel.setBackground(Color.lightGray);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 1;
        this.add(descriptionLabel, gbc);


        areaLabel = new JLabel("Area: " + Integer.toString(area) + "m\u00B2");
        areaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        gbc.weighty = 0.2;
        gbc.gridy = 2;
        this.add(areaLabel, gbc);

        adressLabel = new JLabel("Adress: " + adress.getStringAdress());
        adressLabel.setFont(new Font("Arial", Font.BOLD, 15));
        gbc.gridy = 3;
        this.add(adressLabel, gbc);
    }
}
