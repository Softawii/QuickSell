package br.ufrrj.quicksell.views.panels.container;

import br.ufrrj.quicksell.controlers.Sistema;
import br.ufrrj.quicksell.views.HomeFrame;
import br.ufrrj.quicksell.views.panels.center.HomeCenterPanel;
import br.ufrrj.quicksell.views.panels.center.UserPropertiesCenterPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FilterContainerPanel extends JPanel implements ItemListener, ActionListener {
    private HomeFrame frame;

    private JPanel districtFilterContainer;
    private JCheckBox districtFilterCheck;
    private JTextField districtSearch;

    private JPanel priceFilterContainer;
    private JCheckBox priceFilterCheck;
    private JLabel greaterThanLabel;
    private JTextField priceSearch_1;
    private JLabel lessThanLabel;
    private JTextField priceSearch_2;

    private JPanel typeFilterContainer;
    private JCheckBox propertyTypeFilterCheck;
    private JComboBox<String> propertyTypeBox;

    private JButton filterButton;

    public FilterContainerPanel(HomeFrame frame) {
        this.frame = frame;
        this.setLayout(new GridBagLayout());
        Border padding = BorderFactory.createEmptyBorder(5, 40, 0, 50);
        Border border = BorderFactory.createTitledBorder("Filtro de Busca");
        this.setBorder(BorderFactory.createCompoundBorder(padding, border));
        GridBagConstraints gbc = new GridBagConstraints();
        {
            districtFilterContainer = new JPanel();
            districtFilterContainer.setLayout(new GridBagLayout());
            GridBagConstraints gbcCont = new GridBagConstraints();
            {
                districtFilterCheck = new JCheckBox("Bairro:");
                districtFilterCheck.addItemListener(this);
                {
                    gbcCont.gridx = 0;
                }
                districtFilterContainer.add(districtFilterCheck, gbcCont);

                districtSearch = new JTextField(10);
                districtSearch.setEnabled(false);
                {
                    gbcCont.gridx = 1;
                }
                districtFilterContainer.add(districtSearch, gbcCont);

                gbc.gridx = 0;
                gbc.weightx = 1;
            }
            this.add(districtFilterContainer, gbc);


            priceFilterContainer = new JPanel();
            priceFilterContainer.setLayout(new GridBagLayout());
            gbcCont = new GridBagConstraints();
            {
                priceFilterCheck = new JCheckBox("Pre\u00E7o: ");
                priceFilterCheck.addItemListener(this);
                {
                    gbcCont.gridheight = 2;
                    gbcCont.gridx = 0;
                    gbcCont.gridy = 0;
                }
                priceFilterContainer.add(priceFilterCheck, gbcCont);

                greaterThanLabel = new JLabel("\u2265");
                {
                    gbcCont.gridheight = 1;
                    gbcCont.gridx = 1;
                    gbcCont.gridy = 0;
                }
                priceFilterContainer.add(greaterThanLabel, gbcCont);

                priceSearch_1 = new JTextField(5);
                priceSearch_1.setEnabled(false);
                {
                    gbcCont.gridx = 2;
                }
                priceFilterContainer.add(priceSearch_1, gbcCont);

                lessThanLabel = new JLabel("\u2264");
                {
                    gbcCont.gridx = 1;
                    gbcCont.gridy = 1;
                }
                priceFilterContainer.add(lessThanLabel, gbcCont);

                priceSearch_2 = new JTextField(5);
                priceSearch_2.setEnabled(false);
                {
                    gbcCont.gridx = 2;
                }
                priceFilterContainer.add(priceSearch_2, gbcCont);

                gbc.gridx = 1;
            }
            this.add(priceFilterContainer, gbc);


            typeFilterContainer = new JPanel();
            typeFilterContainer.setLayout(new GridBagLayout());
            gbcCont = new GridBagConstraints();
            {
                propertyTypeFilterCheck = new JCheckBox("Tipo de propriedade:");
                propertyTypeFilterCheck.addItemListener(this);
                {
                    gbcCont.gridx = 0;
                }
                typeFilterContainer.add(propertyTypeFilterCheck, gbcCont);

                String[] stringArr = new String[2];
                stringArr[0] = "Residencial";
                stringArr[1] = "Comercial";
                propertyTypeBox = new JComboBox<String>(stringArr);
                propertyTypeBox.setEnabled(false);
                {
                    gbcCont.gridx = 1;
                }
                typeFilterContainer.add(propertyTypeBox, gbcCont);

                gbc.gridx = 2;
            }
            this.add(typeFilterContainer, gbc);


            filterButton = new JButton("Filtrar");
            filterButton.addActionListener(this);
            {
                gbc.gridx = 0;
                gbc.gridwidth = 3;
                gbc.gridy = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.insets = new Insets(5, 20, 0, 20);
            }
            this.add(filterButton, gbc);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == filterButton){
            try {
                Sistema.pegarInstancia().criarListaFiltradaParaUsuario();

                if(districtFilterCheck.isSelected()){
                    Sistema.pegarInstancia().filtrarPorBairro(districtSearch.getText());
                }

                if(priceFilterCheck.isSelected()){
                    float menorQue =  priceSearch_2.getText().equals("") ? Float.POSITIVE_INFINITY  : Float.parseFloat(priceSearch_2.getText());
                    float maiorQue = priceSearch_1.getText().equals("") ? 0 : Float.parseFloat(priceSearch_1.getText());
                    Sistema.pegarInstancia().filtrarPorPreco(menorQue, maiorQue);
                }

                if(propertyTypeFilterCheck.isSelected()){
                    Sistema.pegarInstancia().filtrarPorTipo(propertyTypeBox.getSelectedItem().toString());
                }

                if(!districtFilterCheck.isSelected() && !priceFilterCheck.isSelected() && !propertyTypeFilterCheck.isSelected())
                    Sistema.pegarInstancia().criarListaFiltradaParaUsuario();

                frame.setCenter(new HomeCenterPanel(frame));
            }
            catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this,
                        "Preço inválido",
                        "Campo incorreto",
                        JOptionPane.PLAIN_MESSAGE);
            }
            catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(this,
                        "Campo vazio",
                        "Campo incorreto",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == districtFilterCheck) {
            if(e.getStateChange() == ItemEvent.SELECTED)
                districtSearch.setEnabled(true);
            else
                districtSearch.setEnabled(false);
        }
        if(e.getSource() == priceFilterCheck) {
            if(e.getStateChange() == ItemEvent.SELECTED){
                priceSearch_1.setEnabled(true);
                priceSearch_2.setEnabled(true);
            }
            else{
                priceSearch_1.setEnabled(false);
                priceSearch_2.setEnabled(false);
            }
        }
        if(e.getSource() == propertyTypeFilterCheck) {
            if(e.getStateChange() == ItemEvent.SELECTED)
                propertyTypeBox.setEnabled(true);
            else
                propertyTypeBox.setEnabled(false);
        }
    }
}
