import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InsuranceCovers {

    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("Insurance Rates");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Create a JEditorPane
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
                "    </tr>\n" +
                "    <!-- Add other rows here -->\n" +
                "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        // Set the HTML content in the editor pane
        editorPane.setText(htmlContent);

        // Add the editorPane to the frame
        frame.getContentPane().add(new JScrollPane(editorPane));

        frame.setVisible(true);
    }
}
