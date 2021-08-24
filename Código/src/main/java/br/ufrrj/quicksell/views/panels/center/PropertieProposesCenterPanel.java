package br.ufrrj.quicksell.views.panels.center;

import br.ufrrj.quicksell.controlers.Sistema;
import br.ufrrj.quicksell.entities.Imovel;
import br.ufrrj.quicksell.entities.Proposta;
import br.ufrrj.quicksell.views.HomeFrame;
import br.ufrrj.quicksell.views.panels.container.ProposeContainerPanel;

import javax.swing.*;
import java.awt.*;

import static br.ufrrj.quicksell.utils.Util.getImageWidth;

public class PropertieProposesCenterPanel extends JPanel {
    private HomeFrame frame;
    private Imovel imovel;

    private JPanel header;
    private JLabel titleLabel;
    private JLabel propertyTitleLabel;
    private JLabel propertyImage;
    private JLabel priceLabel;
    private JLabel areaTitleLabel;
    private JLabel areaLabel;
    private JLabel adressTitleLabel;
    private JTextArea adressLabel;

    private JPanel body;
    private JScrollPane scrollBody;

    private JPanel footer;
    private JLabel footerLabel;

    public PropertieProposesCenterPanel(HomeFrame frame) {
        super();
        this.frame = frame;
        this.imovel = Sistema.pegarInstancia().getImovelAtual();
        this.setLayout(new BorderLayout());

        createHeader();
        createBody();
        createFooter();
    }

    public void createHeader() {
        header = new JPanel();
        header.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        {
            propertyTitleLabel = new JLabel("Propostas do Im\u00F3vel");
            propertyTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
            {
                gbc.gridy = 0;
                gbc.gridx = 0;
                gbc.fill = GridBagConstraints.VERTICAL;
                gbc.weightx = 0;
                gbc.insets = new Insets(0, 30, 20, 0);
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.gridwidth = 3;
            }
            header.add(propertyTitleLabel, gbc);

            propertyImage = new JLabel();
            propertyImage.setIcon(imovel.getImagem(200, 180));
            propertyImage.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
            {
                gbc.gridwidth = 1;
                gbc.gridx = 0;
                gbc.gridy += 1;
                gbc.insets = new Insets(0, 30, 10, 0);
                gbc.gridheight = 6;
            }
            header.add(propertyImage, gbc);

            priceLabel = new JLabel(String.format("Pre\u00E7o Base: R$%.2f", imovel.getValor()));
            priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
            {
                gbc.gridheight = 1;
                gbc.anchor = GridBagConstraints.LINE_START;
                gbc.insets = new Insets(0, 20, 0, 0);
                gbc.gridx = 1;
            }
            header.add(priceLabel, gbc);

            JPanel spacing = new JPanel();
            {
                gbc.insets = new Insets(0, 20, 0, 20);
                gbc.gridx = 2;
                gbc.weightx = 2;
            }
            header.add(spacing, gbc);

            areaTitleLabel = new JLabel("Area: ");
            areaTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            {
                gbc.weightx = 0;
                gbc.gridwidth = 2;
                gbc.insets = new Insets(10, 20, 0, 15);
                gbc.gridx = 1;
                gbc.gridy += 1;
            }
            header.add(areaTitleLabel, gbc);

            areaLabel = new JLabel(Integer.toString(imovel.getArea()) + "m\u00B2");
            areaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            {
                gbc.insets = new Insets(0, 20, 0, 0);
                gbc.gridy += 1;
            }
            header.add(areaLabel, gbc);

            adressTitleLabel = new JLabel("Endere\u00E7o:");
            adressTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            {
                gbc.insets = new Insets(10, 20, 0, 15);
                gbc.gridy += 1;
            }
            header.add(adressTitleLabel, gbc);

            adressLabel = new JTextArea(imovel.getEndereco().getStringAdress());
            adressLabel.setWrapStyleWord(true);
            adressLabel.setLineWrap(true);
            adressLabel.setEditable(false);
            adressLabel.setFont(new Font("Segoe UI", Font.ITALIC, 15));
            {
                gbc.insets = new Insets(0, 20, 0, 15);
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridy += 1;
            }
            header.add(adressLabel, gbc);

            spacing = new JPanel();
            {
                gbc.gridy += 1;
            }
            header.add(spacing, gbc);

        }
        this.add(header, BorderLayout.NORTH);
    }

    public void createBody() {
        if(imovel.getListaDePropostas().size() == 0)
        {
            body = new JPanel();
            body.setLayout(new GridBagLayout());
            JLabel warning = new JLabel("Esse im\u00F3vel n\u00E3o possui propostas registradas");
            warning.setFont(new Font("Segoe UI", Font.BOLD, 30));
            warning.setForeground(Color.GRAY);
            body.add(warning);
            this.add(body, BorderLayout.CENTER);
        }
        else {
            scrollBody = new JScrollPane();
            {
                body = new JPanel();
                body.setLayout(new GridBagLayout());
                GridBagConstraints gbc2 = new GridBagConstraints();
                gbc2.gridy = 0;
                gbc2.insets = new Insets(10,0, 10, 0);
                {
                    for(Proposta proposta : imovel.getListaDePropostas()){
                        ProposeContainerPanel pcp = new ProposeContainerPanel(proposta);
                        gbc2.gridy += 1;
                        body.add(pcp, gbc2);
                    }
                }
                scrollBody = new JScrollPane(body);
                scrollBody.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
                scrollBody.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scrollBody.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollBody.getVerticalScrollBar().setUnitIncrement(15);
            }
            this.add(scrollBody, BorderLayout.CENTER);
        }
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
