package br.ufrrj.quicksell.utils;

import javax.swing.*;
import java.awt.*;

import static java.util.Objects.requireNonNull;

public class Util {
    public static ImageIcon getImageWidth(String path, int width, int height) {
        Util o = new Util();
        ImageIcon image = new ImageIcon(requireNonNull(o.getClass().getClassLoader().getResource(path)));
        return new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    }
}
