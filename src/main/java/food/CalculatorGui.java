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
    protected JComboBox<String> type;

    public CalculatorGui() {
        calculateButtons = new ButtonStyle(Color.WHITE, new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20), "Calculate", null);
        rightText = new TextStyle(Color.BLUE, new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20), "", null);
        labelStyle = new LabelStyle(Color.BLUE, new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20), "", null);
        comboStyle = new ComboStyle(Color.BLUE, new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20), "", null);

        setLayout(new BorderLayout());
        setBackground(new Color(173, 216, 230)); // Light Blue Background

        JPanel titlePanel = createTitlePanel();
        add(titlePanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(new Color(173, 216, 230));

        JPanel topPanel = createLabelPanel();
        contentPanel.add(topPanel, BorderLayout.CENTER);

        JPanel dataPanel = createRightDataPanel();
        contentPanel.add(dataPanel, BorderLayout.EAST);

        add(contentPanel, BorderLayout.CENTER);

        JPanel calculateButtonPanel = createCalculateButtonPanel();
        add(calculateButtonPanel, BorderLayout.SOUTH);
    }

    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(new Color(70, 130, 180));

        JLabel titleLabel = new JLabel("Nutrition Calculator");
        titleLabel.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 35));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        ImageIcon icon = new ImageIcon("assets/yippee.png");
        JLabel iconLabel = new JLabel(icon);
        titlePanel.add(iconLabel);

        return titlePanel;
    }

    private JPanel createRightDataPanel() {
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        dataPanel.setBackground(new Color(173, 216, 230));

        name = rightText.getTextFieldFromStyle("name");
        dataPanel.add(name);

        dataPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        type = comboStyle.getComboFromStyle(new String[]{"Meat", "Fish", "Poultry", "Vegetables", "Fruits", "Dairy", "Grains", "Legumes", "Nuts", "Sweets", "Beverages", "Misc"});
        dataPanel.add(type);

        dataPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        proteins = rightText.getTextFieldFromStyle("proteins");
        dataPanel.add(proteins);

        dataPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        carbs = rightText.getTextFieldFromStyle("carbs");
        dataPanel.add(carbs);

        dataPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        fats = rightText.getTextFieldFromStyle("fats");
        dataPanel.add(fats);

        return dataPanel;
    }

    private JPanel createLabelPanel() {
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelPanel.setBackground(new Color(173, 216, 230));

        result = labelStyle.getLabelFromStyle("Enter information about your food!");
        result.setForeground(Color.WHITE);
        labelPanel.add(result);

        return labelPanel;
    }

    private JPanel createCalculateButtonPanel() {
        JPanel calculateButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        calculateButtonPanel.setBackground(new Color(70, 130, 180)); // Steel Blue

        calculate = new JButton("Calculate");
        calculate.setActionCommand("calculate");
        calculate.addActionListener(this);

        calculate.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20));
        calculate.setBackground(Color.WHITE);
        calculate.setForeground(new Color(70, 130, 180)); // Steel Blue
        calculate.setPreferredSize(new Dimension(200, 40));

        calculateButtonPanel.add(calculate);

        return calculateButtonPanel;
    }

    public void actionPerformed(ActionEvent e) {
        if ("calculate".equals(e.getActionCommand())) {
            String name = this.name.getText();
            String type = (String)this.type.getSelectedItem();
            double proteins = Double.parseDouble(this.proteins.getText());
            double carbs = Double.parseDouble(this.carbs.getText());
            double fats = Double.parseDouble(this.fats.getText());

            Food a = new Food(name, proteins, carbs, fats);
            a.setFoodType(type);
            result.setText("<html>" + a.toGUIString().replace("\n", "<br/>") + "</html>");
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Calculator GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(550, 500));

        CalculatorGui calculatorPane = new CalculatorGui();
        frame.setContentPane(calculatorPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGui::createAndShowGUI);
    }
}
