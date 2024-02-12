import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class agenthome extends JFrame implements ActionListener {
    private JPanel agenthome;
    private JButton REGISTERCLIENTButton;
    private JButton VIEWCLIENTButton;
    private JButton LOGOUTButton;

    public agenthome() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setContentPane(agenthome);

        REGISTERCLIENTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame start = new MyFrame();
                start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                start.setSize(10000, 100001);
                start.setVisible(true);
                dispose();
            }
        });

        VIEWCLIENTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewclient start = new viewclient();
                start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                start.setSize(10000, 100001);
                start.setVisible(true);
                dispose();
            }
        });

        LOGOUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                First start = new First();
                start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                start.setSize(10000, 100001);
                start.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                agenthome start = new agenthome();
                start.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
