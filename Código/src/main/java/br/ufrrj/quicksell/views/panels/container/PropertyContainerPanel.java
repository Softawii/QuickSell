package br.ufrrj.quicksell.views.panels.container;


import br.ufrrj.quicksell.controlers.Sistema;
import br.ufrrj.quicksell.entities.Imovel;
import br.ufrrj.quicksell.views.HomeFrame;
import br.ufrrj.quicksell.views.panels.center.PropertyCenterPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static br.ufrrj.quicksell.utils.Util.getImageWidth;

public class PropertyContainerPanel extends JPanel implements ActionListener {
    private Imovel imovel;
    private HomeFrame frame;

    private JLabel propertyImage;
    private JLabel priceLabel;
    private JLabel adressLabel;
    private JLabel areaLabel;
    private JTextArea descriptionLabel;
    private JButton imovelButton;


    public PropertyContainerPanel(HomeFrame frame, Imovel imovel) {
        this.imovel = imovel;
        this.frame = frame;
        this.setPreferredSize(new Dimension(720, 200));
        Border padding = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border border = BorderFactory.createLineBorder(new Color(190, 190, 190), 5, true);
        this.setBorder(BorderFactory.createCompoundBorder(border, padding));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        propertyImage = new JLabel();
        //ImageIcon image = getImageWidth("Casa_Braba.jpg", 160, 140);
        propertyImage.setIcon(imovel.getImagem(160, 140));
        {
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.weighty = 0;
            gbc.insets = new Insets(0, 0, 0, 10);
            gbc.gridheight = 4;
            gbc.weightx = 2;
        }
        this.add(propertyImage, gbc);

        priceLabel = new JLabel(String.format("R$%.2f", imovel.getValor()));
        priceLabel.setFont(new Font("Arial", Font.BOLD, 25));
        {
            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.gridheight = 1;
            gbc.weightx = 0;
            gbc.weighty = 1;
            gbc.insets = new Insets(0, 10, 0, 10);
        }
        this.add(priceLabel, gbc);

        imovelButton = new JButton();
        imovelButton.addActionListener(this);
        imovelButton.setBackground(new Color(37, 138,164));
        imovelButton.setLayout(new BorderLayout());
        JLabel buttonLabel = new JLabel("Acessar Propriedade");
        buttonLabel.setForeground(Color.white);
        buttonLabel.setHorizontalAlignment(JLabel.CENTER);
        buttonLabel.setHorizontalTextPosition(JLabel.CENTER);
        imovelButton.add(buttonLabel);
        {
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.gridx = 2;
            gbc.weighty = 1;
            gbc.weightx = 0.5;
            gbc.fill = GridBagConstraints.HORIZONTAL;
        }
        this.add(imovelButton, gbc);


        descriptionLabel = new JTextArea(imovel.getDescricao());
        descriptionLabel.setWrapStyleWord(true);
        descriptionLabel.setLineWrap(true);
        descriptionLabel.setEditable(false);
        descriptionLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        descriptionLabel.setBackground(Color.lightGray);
        {
            gbc.weighty = 0.5;
            gbc.gridx = 1;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridy = 1;
        }
        this.add(descriptionLabel, gbc);


        areaLabel = new JLabel("\u00C1rea: " + Integer.toString(imovel.getArea()) + "m\u00B2");
        areaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        {
            gbc.weighty = 0.2;
            gbc.gridy = 2;
        }
        this.add(areaLabel, gbc);


        adressLabel = new JLabel("Endere\u00E7o: " + imovel.getEndereco().getStringMetadeEndereco());
        adressLabel.setFont(new Font("Arial", Font.BOLD, 15));
        {
            gbc.gridy = 3;
        }
        this.add(adressLabel, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == imovelButton) {
            Sistema.pegarInstancia().selecionarImovel(imovel);
            frame.setCenter(new PropertyCenterPanel(frame));
        }
    }
}
