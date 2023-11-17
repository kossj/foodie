package main.java.food;

import javax.swing.*;
import java.awt.*;

public class ButtonStyle {
    Color foregroundColor;
    Font font;
    String text;

    public ButtonStyle(Color foregroundColor, Font font, String text, Icon icon) {
        this.foregroundColor = foregroundColor;
        this.font = font;
        this.text = text;
    }

    public JButton getButtonFromStyle(String text) {
        JButton ret = new JButton();
        ret.setForeground(foregroundColor);
        ret.setFont(font);
        ret.setText(text);
        return ret;
    }
}
