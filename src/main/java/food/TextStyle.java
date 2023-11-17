package main.java.food;

import javax.swing.*;
import java.awt.*;

public class TextStyle {
    Color foregroundColor;
    Font font;
    String text;

    public TextStyle(Color foregroundColor, Font font, String text, Icon icon) {
        this.foregroundColor = foregroundColor;
        this.font = font;
        this.text = text;
    }

    public JTextField getTextFieldFromStyle(String text) {
        JTextField ret = new JTextField();
        ret.setForeground(foregroundColor);
        ret.setFont(font);
        ret.setText(text);
        return ret;
    }
}
