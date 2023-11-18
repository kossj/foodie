package main.java.food;

import javax.swing.*;
import java.awt.*;

public class MySwingProject extends JFrame {
    public MySwingProject() {
        setTitle("My Swing Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Create components
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton calculateButton = new JButton("Calculate");
        JLabel largeLabel = new JLabel("Large Label");

        // Set layouts
        setLayout(new BorderLayout());

        // Buttons on the right stacked vertically using BoxLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        // Large label on the left using GridLayout
        JPanel labelPanel = new JPanel(new GridLayout(1, 1));
        labelPanel.add(largeLabel);

        // Calculate button at the bottom using FlowLayout
        JPanel calculateButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        calculateButtonPanel.add(calculateButton);

        // Add panels to the main frame
        add(buttonPanel, BorderLayout.EAST);
        add(labelPanel, BorderLayout.WEST);
        add(calculateButtonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center the frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MySwingProject example = new MySwingProject();
            example.setVisible(true);
        });
    }
}
