package br.ufrrj.quicksell.views.panels;

import br.ufrrj.quicksell.entities.Proposta;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ProposeContainerPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel valueTitleLabel;
    private JLabel valueLabel;
    private JLabel contactTitleLabel;
    private JLabel contactLabel;
    private JLabel descriptionTitleLabel;
    private JTextArea descriptionLabel;

    public ProposeContainerPanel(Proposta proposta) {
        this.setPreferredSize(new Dimension(720, 150));
        Border padding = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border border = BorderFactory.createLineBorder(new Color(190, 190, 190), 5, true);
        this.setBorder(BorderFactory.createCompoundBorder(border, padding));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        nameLabel = new JLabel("Nome do Proponente: " + proposta.getProponente().getNome());
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        {
            gbc.gridy = 0;
            gbc.gridx = 0;
            gbc.gridwidth = 2;
        }
        this.add(nameLabel, gbc);

        valueTitleLabel = new JLabel("Valor");
        valueTitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        {
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.FIRST_LINE_START;
            gbc.gridy += 1;
            gbc.insets = new Insets(20, 0, 0, 0);
        }
        this.add(valueTitleLabel, gbc);

        valueLabel = new JLabel(String.format("R$%.2f", proposta.getValorInicial()));
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        {
            gbc.gridy += 1;
            gbc.insets = new Insets(0, 0, 0, 0);
        }
        this.add(valueLabel, gbc);

        contactTitleLabel = new JLabel("Contato");
        contactTitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        {
            gbc.gridy += 1;
            gbc.insets = new Insets(10, 0, 0, 0);
        }
        this.add(contactTitleLabel, gbc);

        contactLabel = new JLabel(proposta.getProponente().getEmail());
        contactLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        {
            gbc.gridy += 1;
            gbc.insets = new Insets(0, 0, 10, 0);
        }
        this.add(contactLabel, gbc);

        descriptionTitleLabel = new JLabel("Descri\u00E7\u00E3o");
        descriptionTitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        {
            gbc.gridy = 1;
            gbc.gridx = 1;
            gbc.insets = new Insets(20, 20, 0, 0);
        }
        this.add(descriptionTitleLabel, gbc);

        descriptionLabel = new JTextArea(proposta.getDescricao());
        descriptionLabel.setWrapStyleWord(true);
        descriptionLabel.setLineWrap(true);
        descriptionLabel.setEditable(false);
        descriptionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        descriptionLabel.setBackground(Color.lightGray);
        {
            gbc.gridy += 1;
            gbc.gridheight = 3;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(0, 20, 10, 0);
            gbc.weightx = 2;
        }
        this.add(descriptionLabel, gbc);


    }
}
