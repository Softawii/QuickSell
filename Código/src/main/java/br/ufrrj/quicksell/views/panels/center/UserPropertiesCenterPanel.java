package br.ufrrj.quicksell.views.panels.center;

import br.ufrrj.quicksell.controlers.Sistema;
import br.ufrrj.quicksell.entities.Imovel;
import br.ufrrj.quicksell.views.HomeFrame;
import br.ufrrj.quicksell.views.panels.container.PropertyContainerPanel;

import javax.swing.*;
import java.awt.*;

import static java.util.Objects.requireNonNull;

public class UserPropertiesCenterPanel extends JPanel {
    private HomeFrame frame;

    private JPanel centerBody;

    private JPanel centerHeader;
    private JLabel title;
    private JScrollPane scrollBody;

    private JPanel centerFooter;
    private JLabel centerFooterLabel;

    public UserPropertiesCenterPanel(HomeFrame frame) {
        this.frame = frame;
        this.setLayout(new BorderLayout());

        createCenter();

    }

    private void createCenter() {
        centerHeader = new JPanel();
        {
            title = new JLabel("Meus Im\u00F3veis");
            title.setFont(new Font("Segoe UI", Font.BOLD, 30));
            centerHeader.add(title);
        }
        this.add(centerHeader, BorderLayout.NORTH);

        //CenterBody
        if(Sistema.pegarInstancia().getUsuarioAtual().getImoveis().size() == 0)
        {
            centerBody = new JPanel();
            centerBody.setLayout(new GridBagLayout());
            JLabel warning = new JLabel("Voc\u00EA n\u00E3o tem im\u00F3veis registrados");
            warning.setFont(new Font("Segoe UI", Font.BOLD, 30));
            warning.setForeground(Color.GRAY);
            centerBody.add(warning);
            this.add(centerBody, BorderLayout.CENTER);
        }
        else{
            scrollBody = new JScrollPane();
            centerBody = new JPanel();
            centerBody.setLayout(new GridBagLayout());
            GridBagConstraints gbc2 = new GridBagConstraints();
            gbc2.gridy = 0;
            gbc2.insets = new Insets(10,0, 10, 0);
            {

                for(Imovel imovel : Sistema.pegarInstancia().getUsuarioAtual().getImoveis()){
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
            this.add(scrollBody, BorderLayout.CENTER);
        }
        //CenterBodyFim

        centerFooter = new JPanel();
        {
            centerFooterLabel = new JLabel("\u00A9 2021 QuickSell ");
            centerFooter.add(centerFooterLabel);
        }
        this.add(centerFooter, BorderLayout.SOUTH);
    }

}
