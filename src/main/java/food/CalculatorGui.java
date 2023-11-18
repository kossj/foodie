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
        calculateButtons = new ButtonStyle(Color.BLACK, new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20), "Calculate", null);
        rightText = new TextStyle(Color.BLACK, new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20), "", null);
        labelStyle = new LabelStyle(Color.BLACK, new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20), "", null);
        comboStyle = new ComboStyle(Color.BLACK, new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20), "", null);

        setLayout(new BorderLayout());

        JPanel titlePanel = createTitlePanel();
        add(titlePanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new BorderLayout());

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

        JLabel titleLabel = new JLabel("Nutrition Calculator");
        titleLabel.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 35));
        titlePanel.add(titleLabel);

        ImageIcon icon = new ImageIcon("assets/yippee.png");  // Replace with the path to your icon
        JLabel iconLabel = new JLabel(icon);
        titlePanel.add(iconLabel);

        return titlePanel;
    }

    private JPanel createRightDataPanel() {
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));

        // Adding buttons to the panel
        name = rightText.getTextFieldFromStyle("name");
        dataPanel.add(name);

        dataPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        type = comboStyle.getComboFromStyle(new String[]{"Meat", "Fish", "Poultry", "Vegetables", "Fruits", "Dairy", "Grains", "Legumes", "Nuts", "Sweets", "Beverages", "Misc"});
        dataPanel.add(type);

        dataPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        proteins = rightText.getTextFieldFromStyle("proteins");
        dataPanel.add(proteins);

        // Add an empty label for vertical spacing
        dataPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        carbs = rightText.getTextFieldFromStyle("carbs");
        dataPanel.add(carbs);

        // Add another empty label for vertical spacing
        dataPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        fats = rightText.getTextFieldFromStyle("fats");
        dataPanel.add(fats);

        return dataPanel;
    }

    private JPanel createLabelPanel() {
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Adding label to the panel
        result = labelStyle.getLabelFromStyle("Enter information about your food!");
        labelPanel.add(result);

        return labelPanel;
    }

    private JPanel createCalculateButtonPanel() {
        JPanel calculateButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Creating the calculate button
        calculate = new JButton("Calculate");
        calculate.setActionCommand("calculate");
        calculate.addActionListener(this);

        // Customizing the button appearance
        calculate.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20));
        calculate.setBackground(Color.BLUE); // Set your desired background color
        calculate.setForeground(Color.WHITE); // Set your desired text color
        calculate.setPreferredSize(new Dimension(200, 40)); // Set your desired size

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
        calculatorPane.setOpaque(true);
        calculatorPane.setBackground(Color.blue);

        frame.setContentPane(calculatorPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGui::createAndShowGUI);
    }
}
