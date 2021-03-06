package br.ufrrj.quicksell.views.panels.center;

import br.ufrrj.quicksell.controlers.Sistema;
import br.ufrrj.quicksell.entities.Imovel;
import br.ufrrj.quicksell.views.HomeFrame;
import br.ufrrj.quicksell.views.panels.container.FilterContainerPanel;
import br.ufrrj.quicksell.views.panels.container.PropertyContainerPanel;

import javax.swing.*;
import java.awt.*;

public class HomeCenterPanel extends JPanel {
    private HomeFrame frame;
    private JPanel center;

    private JPanel centerHeader;

    private JPanel centerBody;
    private JScrollPane scrollBody;

    private JPanel centerFooter;
    private JLabel centerFooterLabel;

    public HomeCenterPanel(HomeFrame frame) {
        this.frame = frame;
        this.setLayout(new BorderLayout());

        createCenter();
    }

    private void createCenter() {
        center = new JPanel();
        center.setLayout(new BorderLayout());
        {
            centerHeader = new FilterContainerPanel(frame);
            center.add(centerHeader, BorderLayout.NORTH);


            if(Sistema.pegarInstancia().getListaDeImoveisFiltrada().size() == 0)
            {
                centerBody = new JPanel();
                centerBody.setLayout(new GridBagLayout());
                JLabel warning = new JLabel("N\u00E3o h\u00E1 im\u00F3veis dispon\u00EDveis");
                warning.setFont(new Font("Segoe UI", Font.BOLD, 30));
                warning.setForeground(Color.GRAY);
                centerBody.add(warning);
                center.add(centerBody, BorderLayout.CENTER);
            }
            else {
                scrollBody = new JScrollPane();
                centerBody = new JPanel();
                centerBody.setLayout(new GridBagLayout());
                GridBagConstraints gbc2 = new GridBagConstraints();
                gbc2.gridy = 0;
                gbc2.insets = new Insets(10, 0, 10, 0);
                {
                    for (Imovel imovel : Sistema.pegarInstancia().getListaDeImoveisFiltrada()) {
                        PropertyContainerPanel pcp = new PropertyContainerPanel(frame, imovel);
                        gbc2.gridy += 1;
                        centerBody.add(pcp, gbc2);
                    }
                }
                scrollBody = new JScrollPane(centerBody);
                scrollBody.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
                scrollBody.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scrollBody.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollBody.getVerticalScrollBar().setUnitIncrement(15);
                center.add(scrollBody, BorderLayout.CENTER);
            }


            centerFooter = new JPanel();
            {
                centerFooterLabel = new JLabel("\u00A9 2021 QuickSell ");
                centerFooter.add(centerFooterLabel);
            }
            center.add(centerFooter, BorderLayout.SOUTH);
        }
        this.add(center, BorderLayout.CENTER);
    }
}
