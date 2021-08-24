package br.ufrrj.quicksell.views;

import br.ufrrj.quicksell.controlers.Sistema;
import br.ufrrj.quicksell.exceptions.NegativePriceException;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.util.Objects.requireNonNull;

public class ProposeFrame extends JFrame implements ActionListener {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private JPanel header;
    private JLabel titleLabel;

    private JPanel body;
    private JLabel priceLabel;
    private JLabel price_2Label;

    private JTextField priceField;
    private JLabel descriptionLabel;
    private JTextArea descriptionField;
    private JLabel requiredLabel;
    private JButton proposeButton;


    private JPanel footer;
    private JLabel footerLabel;

    public ProposeFrame() {
        super();
        ImageIcon image = new ImageIcon(requireNonNull(this.getClass().getClassLoader().getResource("LoginIcon.png")));
        this.setIconImage(image.getImage());
        this.setTitle("Quicksell"); //Bota t�tulo
        this.setSize(WIDTH, HEIGHT); //Muda o tamanho
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Fechar a aplica��o ao clicar no X
        this.setResizable(false); //Permite que o usu�rio mude o tamanho da janela
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(0,5));

        createHeader();
        createBody();
        createFooter();

        this.setVisible(true); //Faz o this ser visivel
    }

    public void createHeader() {
        header = new JPanel();
        {
            titleLabel = new JLabel("Proposta");
            titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
            header.add(titleLabel);
        }
        this.add(header, BorderLayout.NORTH);
    }

    public void createBody() {
        body = new JPanel();
        body.setLayout(new GridBagLayout());
        Border margin = BorderFactory.createEmptyBorder(15, 30, 15, 30);
        Border border = BorderFactory.createLineBorder(new Color(190, 190, 190), 3, true);
        body.setBorder(BorderFactory.createCompoundBorder(margin, border));
        GridBagConstraints gbc = new GridBagConstraints();
        {
            priceLabel = new JLabel("Valor *");
            priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
            {
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridwidth = 2;
            }
            body.add(priceLabel, gbc);

            price_2Label = new JLabel("R$ ");
            price_2Label.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            {
                gbc.gridwidth = 1;
                gbc.gridy += 1;
                gbc.gridx = 0;
            }
            body.add(price_2Label, gbc);


            priceField = new JTextField(10);
            {
                gbc.gridx += 1;
            }
            body.add(priceField, gbc);


            descriptionLabel = new JLabel("Descri\u00E7\u00E3o");
            descriptionLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
            {
                gbc.insets = new Insets(20, 0, 0, 0);
                gbc.gridx = 0;
                gbc.gridy += 1;
                gbc.gridwidth = 2;
            }
            body.add(descriptionLabel, gbc);


            descriptionField = new JTextArea(5, 22);
            descriptionField.setWrapStyleWord(true);
            descriptionField.setLineWrap(true);
            descriptionField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
            {
                gbc.insets = new Insets(0, 0, 0, 0);
                gbc.gridy += 1;
            }
            body.add(descriptionField, gbc);

            requiredLabel = new JLabel("* Campos Obrigat\u00F3rios");
            requiredLabel.setFont(new Font("Segoe UI", Font.BOLD, 10));
            {
                gbc.insets = new Insets(10, 0, 0, 0);
                gbc.gridy += 1;
            }
            body.add(requiredLabel, gbc);

            // SignInButton Inicio
            proposeButton = new JButton();
            proposeButton.setBackground(new Color(37, 138,164));
            proposeButton.addActionListener(this);
            proposeButton.setLayout(new BorderLayout());
            {
                JLabel buttonLabel = new JLabel("Fazer Proposta");
                buttonLabel.setForeground(Color.white);
                buttonLabel.setHorizontalAlignment(JLabel.CENTER);
                buttonLabel.setHorizontalTextPosition(JLabel.CENTER);
                proposeButton.add(buttonLabel);

                gbc.insets = new Insets(10, 0, 0, 0);
                gbc.gridy += 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
            }
            body.add(proposeButton, gbc);
        }
        this.add(body, BorderLayout.CENTER);
    }

    public void createFooter() {
        footer = new JPanel();
        {
            footer = new JPanel();
            {
                footerLabel = new JLabel("\u00A9 2021 QuickSell");
                footer.add(footerLabel);
            }
            this.add(footer, BorderLayout.SOUTH);
        }
        this.add(footer, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == proposeButton) {
            float valor;
            try {
                if(priceField.getText().equals(""))
                    throw new NullPointerException();
                valor = Float.parseFloat(priceField.getText());
                if(valor < 0)
                    throw new NegativePriceException("N\u00FAmero negativo");

                Sistema.pegarInstancia().fazerProposta(valor, descriptionField.getText());
                JOptionPane.showMessageDialog(this,
                        "Sua proposta foi enviada",
                        "Sucesso",
                        JOptionPane.PLAIN_MESSAGE);
                dispose();
            }
            catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this,
                        "O pre\u00E7o deve ser um n\u00FAmero.",
                        "Campo incorreto",
                        JOptionPane.PLAIN_MESSAGE);
            }
            catch (NegativePriceException npe) {
                JOptionPane.showMessageDialog(this,
                        npe.getMessage(),
                        "Campo incorreto",
                        JOptionPane.PLAIN_MESSAGE);
            }
            catch (NullPointerException npe2) {
                JOptionPane.showMessageDialog(this,
                        "Campos necess\u00E1rios n\u00E3o foram preenchidos",
                        "Campo faltando",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
