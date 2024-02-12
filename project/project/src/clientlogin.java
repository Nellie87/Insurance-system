import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class clientlogin extends JFrame implements ActionListener {

    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    JButton loginButton, delete, backButton;
    JTextField email;
    JPasswordField password;

    JLabel loginLabel, emailLabel, passwordLabel;

    public void doConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String host = "jdbc:mysql://localhost/login";
            String username = "root";
            String password = "";

            conn = DriverManager.getConnection(host, username, password);

            String SQL = "SELECT * FROM registered_users";
            pstmt = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = pstmt.executeQuery();

            rs.next();
            this.email.setText(rs.getString("email_address"));

        } catch (SQLException | ClassNotFoundException err) {
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
    }

    public clientlogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        loginLabel = new JLabel("LOGIN");
        loginLabel.setBounds(200, 0, 100, 25);
        add(loginLabel);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 50, 100, 25);
        add(emailLabel);

        email = new JTextField();
        email.setBounds(151, 50, 100, 25);
        add(email);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 25);
        add(passwordLabel);

        password = new JPasswordField();
        password.setBounds(151, 100, 100, 25);
        add(password);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(300, 50, 100, 25);
        add(loginButton);
        loginButton.addActionListener(this);

        delete = new JButton("CLEAR");
        delete.setBounds(300, 100, 100, 25);
        add(delete);
        delete.addActionListener(this);

        backButton = new JButton("BACK");
        backButton.setBounds(300, 150, 100, 25);
        add(backButton);
        backButton.addActionListener(this);

        doConnect();
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == loginButton) {
            try {
                String SQL = "SELECT * FROM registered_users WHERE email_address = ? AND number_plate = ?";
                pstmt = conn.prepareStatement(SQL);
                pstmt.setString(1, email.getText());
                pstmt.setString(2, new String(password.getPassword()));
                rs = pstmt.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "LOGGED IN");
                    loginButton.setEnabled(false);

                    // Pass client name to ClientDetails window

                    String clientName = rs.getString("name");
                    // Navigate to the ClientHome window
                    ClientHome clientHomeFrame = new ClientHome(clientName);
                    clientHomeFrame.setVisible(true);
                    clientHomeFrame.setSize(500, 500);
                    dispose(); // Close the current login window

                    // Close the current login window
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid email or password");
                }

            } catch (SQLException err) {
                JOptionPane.showMessageDialog(this, err.getMessage());
                System.out.println(err.getMessage());
            }
        }

        if (evt.getSource() == delete) {
            email.setText("");
            password.setText("");
        }


        if (evt.getSource() == backButton) {
            // Go back to the previous window
            // Replace "PreviousWindow" with the name of your previous window class
            First previousWindow = new First();
            previousWindow.setVisible(true);
            this.dispose(); // Close the current window
        }
    }

    public static void main(String[] args) {
        clientlogin login = new clientlogin();
        login.setVisible(true);
    }
}
