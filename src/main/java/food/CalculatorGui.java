package main.java.food;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * ButtonDemo.java requires the following files:
 *   images/right.gif
 *   images/middle.gif
 *   images/left.gif
 */
public class CalculatorGui extends JPanel implements ActionListener {
    protected JButton b1, b2, b3, calculate;
    protected ButtonStyle calculateButtons;

    protected JTextField name, proteins, carbs, fats;
    protected TextStyle rightText;

    public CalculatorGui() {
        calculateButtons = new ButtonStyle(Color.BLACK, new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20), "", null);
        rightText = new TextStyle(Color.BLACK, new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20), "", null);

        calculate = calculateButtons.getButtonFromStyle("calculate");
        calculate.setActionCommand("calculate");
        calculate.addActionListener(this);

        add(calculate);

        name = rightText.getTextFieldFromStyle("name");
        add(name);
    }

    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("ButtonDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        CalculatorGui newContentPane = new CalculatorGui();

        newContentPane.setOpaque(true); //content panes must be opaque
        newContentPane.setLayout(new BoxLayout(newContentPane, BoxLayout.Y_AXIS));
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if ("calculate".equals(e.getActionCommand())) {
            Food a = new Food("Hamburger", 10, 10, 10, 10);
            System.out.println(a.toString());
        } else {
            b2.setEnabled(true);
            b1.setEnabled(true);
            b3.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
