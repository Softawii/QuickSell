package br.ufrrj.quicksell.entities;

import br.ufrrj.quicksell.utils.Adress;
import br.ufrrj.quicksell.utils.Date;

import javax.swing.*;
import java.util.List;

public class Property {
    int area;
    int value;
    String description;
    Adress adress;
    Date registerDate;
    List<ImageIcon> images;

    public Property(int area, int value, String description, Adress adress, Date registerDate) {
        this.area = area;
        this.value = value;
        this.description = description;
        this.adress = adress;
        this.registerDate = registerDate;
    }
}
