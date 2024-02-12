import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class First extends JFrame implements ActionListener {
    private JButton CLIENTButton;
    private JButton AGENTButton;
    private JButton EXITButton;
    private JPanel First;

    public First() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setContentPane(First);
        AGENTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agentlogin start = new agentlogin();
                start.setVisible(true);
                start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                start.setSize(500, 500);
                dispose(); // Close the First window


            }
        });
        CLIENTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientlogin start = new clientlogin();
                start.setVisible(true);
                start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                start.setSize(500, 500);
                dispose(); // Close the First window

            }
        });
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose(); // Close the JFrame
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                First start = new First();
                start.setVisible(true);
                start.setSize(450, 400);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
