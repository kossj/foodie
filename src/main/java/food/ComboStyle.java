package main.java.food;

import javax.swing.*;
import java.awt.*;

public class ComboStyle {
    Color foregroundColor;
    Font font;
    String text;

    public ComboStyle(Color foregroundColor, Font font, String text, Icon icon) {
        this.foregroundColor = foregroundColor;
        this.font = font;
        this.text = text;
    }

    public JComboBox getComboFromStyle(String[] items) {
        JComboBox ret = new JComboBox(items);
        ret.setForeground(foregroundColor);
        ret.setFont(font);
        return ret;
    }
}
