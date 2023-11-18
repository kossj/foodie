package main.java.food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGui extends JPanel implements ActionListener {
    protected JButton calculate;
    protected JLabel result;
    protected ButtonStyle calculateButtons;
    protected TextStyle rightText;
    protected LabelStyle labelStyle;
    protected ComboStyle comboStyle;
    protected JTextField name, proteins, carbs, fats;
    protected JComboBox type;

    public CalculatorGui() {
        calculateButtons = new ButtonStyle(Color.BLACK, new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20), "Calculate", null);
        rightText = new TextStyle(Color.BLACK, new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20), "", null);
        labelStyle = new LabelStyle(Color.BLACK, new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20), "", null);
        comboStyle = new ComboStyle(Color.BLACK, new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20), "", null);


        setLayout(new BorderLayout());

        // Buttons on the right stacked vertically using BoxLayout
        JPanel buttonPanel = createRightDataPanel();
        add(buttonPanel, BorderLayout.EAST);

        // Large label on the left using GridLayout
        JPanel labelPanel = createLabelPanel();
        add(labelPanel, BorderLayout.WEST);

        // Calculate button at the bottom using FlowLayout
        JPanel calculateButtonPanel = createCalculateButtonPanel();
        add(calculateButtonPanel, BorderLayout.SOUTH);
    }

    private JPanel createRightDataPanel() {
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));

        // Adding buttons to the panel
        name = rightText.getTextFieldFromStyle("name");
        dataPanel.add(name);

        type = comboStyle.getComboFromStyle(new String[]{"Oil", "Poultry", "Misc"});
        dataPanel.add(type);

        proteins = rightText.getTextFieldFromStyle("proteins");
        dataPanel.add(proteins);

        carbs = rightText.getTextFieldFromStyle("carbs");
        dataPanel.add(carbs);

        fats = rightText.getTextFieldFromStyle("fats");
        dataPanel.add(fats);

        return dataPanel;
    }

    private JPanel createLabelPanel() {
        JPanel labelPanel = new JPanel(new GridLayout(1, 1));

        // Adding label to the panel

        result = labelStyle.getLabelFromStyle("label");
        labelPanel.add(result);

        return labelPanel;
    }

    private JPanel createCalculateButtonPanel() {
        JPanel calculateButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Adding calculate button to the panel
        calculate = calculateButtons.getButtonFromStyle("calculate");
        calculate.setActionCommand("calculate");
        calculate.addActionListener(this);
        calculateButtonPanel.add(calculate);

        return calculateButtonPanel;
    }

    public void actionPerformed(ActionEvent e) {
        if ("calculate".equals(e.getActionCommand())) {
            Food a = new Food("Hamburger", 10, 10, 10, 10);
            result.setText("<html>" + a.toGUIString().replace("\n","<br/>") + "</html>");
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Calculator GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CalculatorGui calculatorPane = new CalculatorGui();
        calculatorPane.setOpaque(true);
        frame.setContentPane(calculatorPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGui::createAndShowGUI);
    }
}
