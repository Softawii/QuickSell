package br.ufrrj.quicksell.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import static java.util.Objects.requireNonNull;

public class LoginFrame extends JFrame {
    private JPanel header;
    public JLabel iconImage;
    private JLabel loginLabel;

    private JPanel body;
    private JLabel userLabel;
    private JTextField userField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton signUpButton;

    private JPanel footer;
    private JLabel footerLabel;



    private JPanel container;

    public LoginFrame(int width, int height) {
        super();
        ImageIcon image = new ImageIcon(requireNonNull(this.getClass().getClassLoader().getResource("LoginIcon.png")));
        this.setIconImage(image.getImage());
        this.setTitle("Quicksell"); //Bota t�tulo
        this.setSize(width, height); //Muda o tamanho
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fechar a aplica��o ao clicar no X
        this.setResizable(false); //Permite que o usu�rio mude o tamanho da janela
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(0,5));

        createHeader();
        createBody();
        createFooter();

        this.setVisible(true); //Faz o this ser visivel
    }

    private void createHeader() {
        header = new JPanel();
        header.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        {
            // IconImage Inicio
            iconImage = new JLabel();
            ImageIcon image = getImageWidth("LoginIcon.png", 100, 100);
            iconImage.setIcon(image);
            iconImage.setHorizontalAlignment(JLabel.CENTER);
            iconImage.setLayout(new BorderLayout(0, 100));
            iconImage.setText("QUICKSELL");
            iconImage.setHorizontalTextPosition(JLabel.CENTER);
            iconImage.setVerticalTextPosition(JLabel.BOTTOM);
            iconImage.setHorizontalAlignment(JLabel.CENTER);
            iconImage.setFont(new Font("Cooper Std Black", Font.ITALIC, 28));
            header.add(iconImage, gbc);
            // IconImage Final


            // LoginLabel inicio
            loginLabel = new JLabel();
            loginLabel.setFont(new Font("Arial", Font.BOLD, 20));
            loginLabel.setText("Sign In");
            {
                gbc.insets = new Insets(5, 0, 0, 0);
                gbc.gridy = 1;
            }
            header.add(loginLabel, gbc);
            // LoginLabel Final
        }
        this.add(header, BorderLayout.NORTH);
    }


    private void createBody() {
        body = new JPanel();
        body.setBackground(Color.RED);
        body.setLayout(new BorderLayout());
        {
            // Container Inicio
            container = new JPanel();
            Border padding = BorderFactory.createEmptyBorder(5, 40, 0, 40);
            Border border = BorderFactory.createLineBorder(Color.lightGray, 2, true);
            container.setBorder(BorderFactory.createCompoundBorder(padding, border));
            container.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            {
                // UserLabel Inicio
                userLabel = new JLabel("Username");
                {
                    gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                }
                container.add(userLabel, gbc);
                // Userlabel Final


                // UserField Inicio
                userField = new JTextField(20);
                {
                    gbc.gridy = 1;
                }
                container.add(userField, gbc);
                // UserField Final


                // PasswordLabel Inicio
                passwordLabel = new JLabel("Password");
                {
                    gbc.insets = new Insets(15, 0, 0, 0);
                    gbc.gridy = 2;
                }
                container.add(passwordLabel, gbc);
                // PasswordLabel Final


                // PasswordField Inicio
                passwordField = new JPasswordField(20);
                {
                    gbc.insets = new Insets(0, 0, 0, 0);
                    gbc.gridy = 3;
                }
                container.add(passwordField, gbc);
                // PasswordField Final


                // SignInButton Inicio
                signInButton = new JButton();
                signInButton.setPreferredSize(new Dimension(0, 35));
                signInButton.setText("Sign in");
                signInButton.setBackground(new Color(37, 138,164));
                {
                    gbc.insets = new Insets(10, 0, 0, 0);
                    gbc.gridy = 4;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                }
                container.add(signInButton, gbc);
                // SignInButton Final


                // SignUpButton Inicio
                signUpButton = new JButton();
                signUpButton.setContentAreaFilled(true);
                signUpButton.setHorizontalTextPosition(JButton.LEFT);
                signUpButton.setFont(new Font("Arial", Font.BOLD, 10));
                signUpButton.setLayout(new BorderLayout());
                JLabel labelteste = new JLabel("Create an account");
                labelteste.setFont(new Font("Arial", Font.BOLD, 10));
                labelteste.setForeground(Color.white);
                labelteste.setHorizontalAlignment(JLabel.CENTER);
                labelteste.setHorizontalTextPosition(JLabel.CENTER);
                signUpButton.add(labelteste);
                signUpButton.setBackground(new Color(37, 138,164));
                {
                    gbc.gridy = 5;
                    gbc.insets = new Insets(15, 0, 0, 0);
                    gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                }
                container.add(signUpButton, gbc);
                // SignUpButton Final
            }
            body.add(container);
            // Container final
        }
        this.add(body, BorderLayout.CENTER);
    }

    private void createFooter() {
        JPanel footer = new JPanel();
        {
            footerLabel = new JLabel("\u00A9 2021 QuickSell");
            footer.add(footerLabel);
        }
        this.add(footer, BorderLayout.SOUTH);
    }



    public ImageIcon getImageWidth(String path, int width, int height) {
        ImageIcon image = new ImageIcon(requireNonNull(this.getClass().getClassLoader().getResource(path)));
        return new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    }

}
