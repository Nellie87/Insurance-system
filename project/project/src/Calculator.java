import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Price Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 300); // Adjust the frame size

            // Set the layout to null (absolute positioning)
            frame.setLayout(null);

            // Create and position components with appropriate sizes
            JLabel totalPriceLabel = new JLabel("Total Price:");
            JTextField totalPriceField = new JTextField();
            totalPriceLabel.setBounds(50, 30, 150, 30);
            totalPriceField.setBounds(200, 30, 150, 30);

            JLabel monthsLabel = new JLabel("Number of Months:");
            JTextField monthsField = new JTextField();
            monthsLabel.setBounds(50, 80, 150, 30);
            monthsField.setBounds(200, 80, 150, 30);

            JButton calculateButton = new JButton("Calculate");
            JLabel resultLabel = new JLabel("");
            calculateButton.setBounds(50, 130, 150, 30);
            resultLabel.setBounds(200, 130, 250, 30);

            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        double totalPrice = Double.parseDouble(totalPriceField.getText());
                        int numberOfMonths = Integer.parseInt(monthsField.getText());
                        double figure = totalPrice / numberOfMonths;
                        resultLabel.setText("The figure is: " + figure);
                    } catch (NumberFormatException ex) {
                        resultLabel.setText("Invalid input. Please enter valid numbers.");
                    }
                }
            });

            // Add components to the frame
            frame.add(totalPriceLabel);
            frame.add(totalPriceField);
            frame.add(monthsLabel);
            frame.add(monthsField);
            frame.add(calculateButton);
            frame.add(resultLabel);

            frame.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


