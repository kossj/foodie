package main.java.food;

import javax.swing.*;
import java.awt.*;

public class LabelStyle {
    Color foregroundColor, backgroundColor;
    Font font;
    String text;

    public LabelStyle(Color foregroundColor, Font font, String text, Icon icon) {
        this.foregroundColor = foregroundColor;
        this.font = font;
        this.text = text;
    }

    public JLabel getLabelFromStyle(String text) {
        JLabel ret = new JLabel();
        ret.setForeground(foregroundColor);
        ret.setFont(font);
        ret.setText(text);
        return ret;
    }
}
