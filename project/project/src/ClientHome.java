import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientHome extends JFrame implements ActionListener {
    private JButton clientDetails;
    private JButton calculator;
    private JButton insuranceCovers;
    private JButton exitButton;
    private JPanel clientHomePanel;
    private String clientName;

    public ClientHome(String clientName) {
        this.clientName = clientName;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        clientHomePanel = new JPanel(); // Initialize the JPanel
        setContentPane(clientHomePanel);

        clientDetails = new JButton("Client Details");
        calculator = new JButton("Calculator");
        insuranceCovers = new JButton("Insurance Covers");
        exitButton = new JButton("Exit");

        clientHomePanel.add(clientDetails);
        clientHomePanel.add(calculator);
        clientHomePanel.add(insuranceCovers);
        clientHomePanel.add(exitButton);

        clientDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the ClientDetails window
                ClientDetails clientDetailsFrame = new ClientDetails(clientName);
                clientDetailsFrame.setSize(600, 900);
                clientDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                clientDetailsFrame.setVisible(true);
                dispose(); // Close the current ClientHome window
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the JFrame
            }
        });

        // Create the Insurance Covers button and its action listener
        insuranceCovers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openInsuranceCoversGUI();
            }
        });
        calculator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                openCalculator();
            }
        });
    }

    private void openInsuranceCoversGUI() {
        JFrame insuranceCoversFrame = new JFrame("Insurance Covers");
        insuranceCoversFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        insuranceCoversFrame.setSize(600, 400);

        // Add content specific to InsuranceCovers GUI
        // ... (Add your GUI components here)
        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setEditable(false);

        // Set the HTML content to display a table
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <style>\n" +
                "        table {\n" +
                "            border-collapse: collapse;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "\n" +
                "        th, td {\n" +
                "            padding: 8px;\n" +
                "            text-align: left;\n" +
                "            border-bottom: 1px solid #DDD;\n" +
                "        }\n" +
                "\n" +
                "        tr:hover {background-color: #D6EEEE;}\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h2>Insurance rates</h2>\n" +
                "<p>The following are the insurance rates as per the car model</p>\n" +
                "\n" +
                "<table>\n" +
                "    <tr>\n" +
                "        <th>Car value</th>\n" +
                "        <th>Third Party Only</th>\n" +
                "        <th>Third Party Fire and theft</th>\n" +
                "        <th>Comprehensive</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Bronze</td>\n" +
                "        <td>100000</td>\n" +
                "        <td>350000</td>\n" +
                "        <td>500000</td>\n" +
                "\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Silver</td>\n" +
                "        <td>500000</td>\n" +
                "        <td>700000</td>\n" +
                "        <td>850000</td>\n" +
                "\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Gold</td>\n" +
                "        <td>850000</td>\n" +
                "        <td>1000000</td>\n" +
                "        <td>1500000</td>\n" +
                "\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Platinum</td>\n" +
                "        <td>500000</td>\n" +
                "        <td>3000000</td>\n" +
                "        <td>5000000</td>\n" +
                "\n" +
                "    </tr>\n" +
                "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n" +
                "\n";
        // Set the HTML content in the editor pane
        editorPane.setText(htmlContent);

        // Add the editorPane to the frame
        insuranceCoversFrame.getContentPane().add(new JScrollPane(editorPane));

        insuranceCoversFrame.setVisible(true);
    }
    private void openCalculator() {
        // Create an instance of the Calculator class and show it
        Calculator.main(new String[]{});

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String clientName = "?";
            ClientHome start = new ClientHome(clientName);
            start.setVisible(true);
            start.setSize(450, 400);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
