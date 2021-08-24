package br.ufrrj.quicksell.views.panels.center;

import br.ufrrj.quicksell.controlers.Sistema;

import br.ufrrj.quicksell.entities.Imovel;
import br.ufrrj.quicksell.entities.Proposta;
import br.ufrrj.quicksell.views.HomeFrame;
import br.ufrrj.quicksell.views.ProposeFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static br.ufrrj.quicksell.utils.Util.getImageWidth;
import static java.util.Objects.requireNonNull;

public class PropertyCenterPanel extends JPanel implements ActionListener {
    private Imovel imovel;
    private JFrame proposeFrame;
    private HomeFrame frame;

    private JPanel centerHeader;
    private JLabel titleLabel;

    private JPanel centerBody;
    private JLabel propertyImage;
    private JLabel priceLabel;
    private JLabel areaTitleLabel;
    private JLabel areaLabel;
    private JLabel descriptionTitleLabel;
    private JTextArea descriptionLabel;
    private JLabel adressTitleLabel;
    private JTextArea adressLabel;
    private JLabel ownerTitleLabel;
    private JTextArea ownerLabel;
    private JLabel contactTitleLabel;
    private JTextArea contactLabel;
    private JButton editButton;
    private JButton accessProposeButton;
    private JButton createProposeButton;

    private JPanel centerFooter;
    private JLabel centerFooterLabel;

    public PropertyCenterPanel(HomeFrame frame) {
        super();
        this.imovel = Sistema.pegarInstancia().getImovelAtual();
        this.frame = frame;

        createCenter();
    }

    public void createCenter() {
        this.setLayout(new BorderLayout());

        centerHeader = new JPanel();
        {
            titleLabel = new JLabel("Informa\u00E7\u00F5es do Im\u00F3vel");
            titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
            centerHeader.add(titleLabel);
        }
        this.add(centerHeader, BorderLayout.NORTH);


        centerBody = new JPanel();
        Border margin = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border border = BorderFactory.createLineBorder(new Color(190, 190, 190), 2, true);
        centerBody.setBorder(BorderFactory.createCompoundBorder(margin, border));
        centerBody.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        {
            propertyImage = new JLabel();
            //ImageIcon image = getImageWidth("Casa_Braba.jpg", 220, 200);
            propertyImage.setIcon(imovel.getImagem(220, 200));
            propertyImage.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
            {
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.insets = new Insets(30, 30, 20, 0);
                gbc.fill = GridBagConstraints.VERTICAL;
                gbc.weightx = 0;
                gbc.gridheight = 6;
            }
            centerBody.add(propertyImage, gbc);

            priceLabel = new JLabel(String.format("Pre\u00E7o Base: R$%.2f", imovel.getValor()));
            priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
            {
                gbc.gridheight = 1;
                gbc.anchor = GridBagConstraints.LINE_START;
                gbc.insets = new Insets(30, 20, 0, 0);
                gbc.gridx = 1;
            }
            centerBody.add(priceLabel, gbc);

            JPanel spacing = new JPanel();
            {
                gbc.insets = new Insets(0, 20, 0, 20);
                gbc.gridx = 2;
                gbc.weightx = 2;
            }
            centerBody.add(spacing, gbc);

            areaTitleLabel = new JLabel("Area: ");
            areaTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            {
                gbc.weightx = 0;
                gbc.gridwidth = 2;
                gbc.insets = new Insets(10, 20, 0, 15);
                gbc.gridx = 1;
                gbc.gridy += 1;
            }
            centerBody.add(areaTitleLabel, gbc);

            areaLabel = new JLabel(Integer.toString(imovel.getArea()) + "m\u00B2");
            areaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            {
                gbc.insets = new Insets(0, 20, 0, 0);
                gbc.gridy += 1;
            }
            centerBody.add(areaLabel, gbc);


            descriptionTitleLabel = new JLabel("Descri\u00E7\u00E3o:");
            descriptionTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            {
                gbc.insets = new Insets(10, 20, 0, 15);
                gbc.gridy += 1;
            }
            centerBody.add(descriptionTitleLabel, gbc);

            descriptionLabel = new JTextArea(imovel.getDescricao());
            descriptionLabel.setWrapStyleWord(true);
            descriptionLabel.setLineWrap(true);
            descriptionLabel.setEditable(false);
            descriptionLabel.setFont(new Font("Segoe UI", Font.ITALIC, 15));
            {
                gbc.insets = new Insets(0, 20, 0, 15);
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridy += 1;
            }
            centerBody.add(descriptionLabel, gbc);

            spacing = new JPanel();
            {
                gbc.gridy += 1;
            }
            centerBody.add(spacing, gbc);


            adressTitleLabel = new JLabel("Endere\u00E7o:");
            adressTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            {
                gbc.gridx = 0;
                gbc.gridy += 1;
                gbc.gridwidth = 3;
            }
            centerBody.add(adressTitleLabel, gbc);

            adressLabel = new JTextArea(imovel.getEndereco().getStringAdress());
            adressLabel.setWrapStyleWord(true);
            adressLabel.setLineWrap(true);
            adressLabel.setEditable(false);
            adressLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            {
                gbc.gridy += 1;
            }
            centerBody.add(adressLabel, gbc);

            ownerTitleLabel = new JLabel("Propriet\u00E1rio:");
            ownerTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            {
                gbc.insets = new Insets(30, 20, 0, 15);
                gbc.gridy += 1;
            }
            centerBody.add(ownerTitleLabel, gbc);

            ownerLabel = new JTextArea(imovel.getProprietario().getNome());
            ownerLabel.setWrapStyleWord(true);
            ownerLabel.setLineWrap(true);
            ownerLabel.setEditable(false);
            ownerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            {
                gbc.insets = new Insets(0, 20, 0, 15);
                gbc.gridy += 1;
            }
            centerBody.add(ownerLabel, gbc);


            contactTitleLabel = new JLabel("Contato:");
            contactTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            {
                gbc.insets = new Insets(30, 20, 0, 15);
                gbc.gridy += 1;
            }
            centerBody.add(contactTitleLabel, gbc);

            contactLabel = new JTextArea(imovel.getProprietario().pegarResponsavel(imovel).getEmail());
            contactLabel.setWrapStyleWord(true);
            contactLabel.setLineWrap(true);
            contactLabel.setEditable(false);
            contactLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            {
                gbc.insets = new Insets(0, 20, 0, 15);
                gbc.gridy += 1;
            }
            centerBody.add(contactLabel, gbc);



            spacing = new JPanel();
            {
                gbc.gridy += 1;
                gbc.weighty = 1;
            }
            centerBody.add(spacing, gbc);

            if(imovel.getProprietario().pegarResponsavel(imovel) == Sistema.pegarInstancia().getUsuarioAtual())
            {
                editButton = new JButton();
                editButton.setBackground(new Color(37, 138,164));
                editButton.setLayout(new BorderLayout());
                JLabel editButtonLabel = new JLabel("Editar Informa\u00E7\u00F5es");
                editButtonLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
                editButtonLabel.setForeground(Color.white);
                editButtonLabel.setHorizontalAlignment(JLabel.CENTER);
                editButtonLabel.setHorizontalTextPosition(JLabel.CENTER);
                editButton.add(editButtonLabel);
                {
                    gbc.gridy += 1;
                    gbc.fill = GridBagConstraints.NONE;
                    gbc.anchor = GridBagConstraints.CENTER;
                    gbc.gridwidth = 2;
                }
                centerBody.add(editButton, gbc);

                accessProposeButton = new JButton();
                accessProposeButton.setBackground(new Color(37, 138,164));
                accessProposeButton.setLayout(new BorderLayout());
                accessProposeButton.addActionListener(this);
                JLabel accessProposeButtonLabel = new JLabel("Ver Propostas");
                accessProposeButtonLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
                accessProposeButtonLabel.setForeground(Color.white);
                accessProposeButtonLabel.setHorizontalAlignment(JLabel.CENTER);
                accessProposeButtonLabel.setHorizontalTextPosition(JLabel.CENTER);
                accessProposeButton.add(accessProposeButtonLabel);
                {
                    gbc.gridx = 1;
                    gbc.gridwidth = 2;
                }
                centerBody.add(accessProposeButton, gbc);
            }
            else {
                createProposeButton = new JButton();
                createProposeButton.setBackground(new Color(37, 138,164));
                createProposeButton.addActionListener(this);
                JLabel createProposeButtonLabel = new JLabel("Fazer Proposta");
                createProposeButtonLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
                createProposeButtonLabel.setForeground(Color.white);
                createProposeButtonLabel.setHorizontalAlignment(JLabel.CENTER);
                createProposeButtonLabel.setHorizontalTextPosition(JLabel.CENTER);
                createProposeButton.add(createProposeButtonLabel);
                {
                    gbc.gridy += 1;
                    gbc.fill = GridBagConstraints.NONE;
                    gbc.anchor = GridBagConstraints.CENTER;
                    gbc.gridwidth = 4;
                }
                centerBody.add(createProposeButton, gbc);
            }

        }
        this.add(centerBody, BorderLayout.CENTER);

        centerFooter = new JPanel();
        {
            centerFooterLabel = new JLabel("\u00A9 2021 QuickSell ");
            centerFooter.add(centerFooterLabel);
        }
        this.add(centerFooter, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createProposeButton){
            if(proposeFrame != null)
                proposeFrame.dispose();
            proposeFrame = new ProposeFrame();
        }

        if(e.getSource() == accessProposeButton) {
            frame.setCenter(new PropertieProposesCenterPanel(frame));
            for (Proposta proposta : imovel.getListaDePropostas())
                System.out.println(proposta.toString());
        }

    }
}
