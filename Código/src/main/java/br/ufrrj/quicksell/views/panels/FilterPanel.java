package br.ufrrj.quicksell.views.panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FilterPanel extends JPanel {
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

    public FilterPanel() {
        this.setLayout(new GridBagLayout());
        Border padding = BorderFactory.createEmptyBorder(5, 40, 0, 50);
        Border border = BorderFactory.createTitledBorder("Search Filter");
        this.setBorder(BorderFactory.createCompoundBorder(padding, border));
        GridBagConstraints gbc = new GridBagConstraints();
        {
            districtFilterContainer = new JPanel();
            districtFilterContainer.setLayout(new GridBagLayout());
            GridBagConstraints gbcCont = new GridBagConstraints();
            {
                districtFilterCheck = new JCheckBox("District:");
                {
                    gbcCont.gridx = 0;
                }
                districtFilterContainer.add(districtFilterCheck, gbcCont);

                districtSearch = new JTextField(10);
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
                priceFilterCheck = new JCheckBox("Price: ");
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
                propertyTypeFilterCheck = new JCheckBox("Property Type:");
                {
                    gbcCont.gridx = 0;
                }
                typeFilterContainer.add(propertyTypeFilterCheck, gbcCont);

                String[] stringArr = new String[2];
                stringArr[0] = "Residential";
                stringArr[1] = "Comercial";
                propertyTypeBox = new JComboBox<String>(stringArr);
                {
                    gbcCont.gridx = 1;
                }
                typeFilterContainer.add(propertyTypeBox, gbcCont);

                gbc.gridx = 2;
            }
            this.add(typeFilterContainer, gbc);


            filterButton = new JButton("Filter");
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
}
