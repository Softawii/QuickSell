package br.ufrrj.quicksell.views.panels;

import br.ufrrj.quicksell.controlers.Sistema;
import br.ufrrj.quicksell.entities.Imovel;
import br.ufrrj.quicksell.entities.Usuario;
import br.ufrrj.quicksell.views.HomeFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static br.ufrrj.quicksell.utils.Util.getImageWidth;

public class UserProfileCenterPanel extends JPanel {

    private HomeFrame frame;
    private Usuario usuario;

    private JPanel header;
    private JLabel titleLabel;

    private JPanel body;
    private JLabel userImage;
    private JLabel nameLabel;
    private JLabel emailTitleLabel;
    private JLabel emailLabel;
    private JLabel phoneTitleLabel;
    private JLabel phoneLabel;
    private JLabel adressTitleLabel;
    private JTextArea adressLabel;
    private JLabel cpfTitleLabel;
    private JLabel cpfLabel;
    private JLabel propertyNumberTitleLabel;
    private JLabel propertyNumberLabel;
    private JButton editButton;

    private JPanel footer;
    private JLabel footerLabel;

    public UserProfileCenterPanel(HomeFrame frame) {
        super();
        this.frame = frame;
        this.usuario = Sistema.pegarInstancia().getUsuarioAtual();
        this.setLayout(new BorderLayout());

        createHeader();
        createBody();
        createFooter();
    }

    public void createHeader() {
        header = new JPanel();
        {
            titleLabel = new JLabel("Perfil do Usu\u00E1rio");
            titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
            header.add(titleLabel);
        }
        this.add(header, BorderLayout.NORTH);
    }

    public void createBody() {
        body = new JPanel();
        Border margin = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border border = BorderFactory.createLineBorder(new Color(190, 190, 190), 2, true);
        body.setBorder(BorderFactory.createCompoundBorder(margin, border));
        body.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        {
            userImage = new JLabel();
            ImageIcon image = getImageWidth("UserImage.png", 200, 180);
            userImage.setIcon(image);
            userImage.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
            {
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.insets = new Insets(30, 30, 20, 0);
                gbc.fill = GridBagConstraints.VERTICAL;
                gbc.weightx = 0;
                gbc.gridheight = 6;
            }
            body.add(userImage, gbc);

            nameLabel = new JLabel(usuario.getNome());
            nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
            {
                gbc.gridheight = 1;
                gbc.anchor = GridBagConstraints.LINE_START;
                gbc.insets = new Insets(30, 20, 0, 0);
                gbc.gridx = 1;
            }
            body.add(nameLabel, gbc);

            JPanel spacing = new JPanel();
            {
                gbc.insets = new Insets(0, 20, 0, 20);
                gbc.gridx = 2;
                gbc.weightx = 2;
            }
            body.add(spacing, gbc);

            emailTitleLabel = new JLabel("Email: ");
            emailTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            {
                gbc.weightx = 0;
                gbc.gridwidth = 2;
                gbc.insets = new Insets(10, 20, 0, 15);
                gbc.gridx = 1;
                gbc.gridy += 1;
            }
            body.add(emailTitleLabel, gbc);

            emailLabel = new JLabel(usuario.getEmail());
            emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            {
                gbc.insets = new Insets(0, 20, 0, 0);
                gbc.gridy += 1;
            }
            body.add(emailLabel, gbc);


            phoneTitleLabel = new JLabel("Telefone: ");
            phoneTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            {
                gbc.insets = new Insets(10, 20, 0, 15);
                gbc.gridy += 1;
            }
            body.add(phoneTitleLabel, gbc);

            phoneLabel = new JLabel(usuario.getTelefone());
            phoneLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            {
                gbc.insets = new Insets(0, 20, 0, 15);
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridy += 1;
            }
            body.add(phoneLabel, gbc);

            spacing = new JPanel();
            {
                gbc.gridy += 1;
            }
            body.add(spacing, gbc);


            adressTitleLabel = new JLabel("Endere\u00E7o:");
            adressTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            {
                gbc.gridx = 0;
                gbc.gridy += 1;
                gbc.gridwidth = 3;
            }
            body.add(adressTitleLabel, gbc);

            adressLabel = new JTextArea(usuario.getEndereco().getStringAdress());
            adressLabel.setWrapStyleWord(true);
            adressLabel.setLineWrap(true);
            adressLabel.setEditable(false);
            adressLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            {
                gbc.gridy += 1;
            }
            body.add(adressLabel, gbc);

            cpfTitleLabel = new JLabel("CPF: ");
            cpfTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            {
                gbc.insets = new Insets(30, 20, 0, 15);
                gbc.gridy += 1;
            }
            body.add(cpfTitleLabel, gbc);

            cpfLabel = new JLabel(usuario.getCpf());
            cpfLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            {
                gbc.insets = new Insets(0, 20, 0, 15);
                gbc.gridy += 1;
            }
            body.add(cpfLabel, gbc);


            propertyNumberTitleLabel = new JLabel("Propriedades Registradas:");
            propertyNumberTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            {
                gbc.insets = new Insets(30, 20, 0, 15);
                gbc.gridy += 1;
            }
            body.add(propertyNumberTitleLabel, gbc);

            propertyNumberLabel = new JLabel(Integer.toString(usuario.getNumeroImoveis()));
            propertyNumberLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            {
                gbc.insets = new Insets(0, 20, 0, 15);
                gbc.gridy += 1;
            }
            body.add(propertyNumberLabel, gbc);


            spacing = new JPanel();
            {
                gbc.gridy += 1;
                gbc.weighty = 1;
            }
            body.add(spacing, gbc);


            editButton = new JButton();
            editButton.setBackground(new Color(37, 138,164));
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
                gbc.gridwidth = 4;
            }
            body.add(editButton, gbc);


        }
        this.add(body, BorderLayout.CENTER);
    }

    public void createFooter() {
        footer = new JPanel();
        {
            footerLabel = new JLabel("\u00A9 2021 QuickSell ");
            footer.add(footerLabel);
        }
        this.add(footer, BorderLayout.SOUTH);
    }
}
