import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class agentlogin extends JFrame implements ActionListener {

    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    JButton loginButton, delete, backButton;
    JTextField username;
    JPasswordField password;

    JLabel loginLabel, usernameLabel, passwordLabel;

    public void doConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String host = "jdbc:mysql://localhost/login";
            String dbUsername = "root";
            String dbPassword = "";

            conn = DriverManager.getConnection(host, dbUsername, dbPassword);

            String SQL = "SELECT * FROM agent";
            pstmt = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = pstmt.executeQuery();

            rs.next();
            this.username.setText(rs.getString("Username"));

        } catch (SQLException | ClassNotFoundException err) {
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
    }

    public agentlogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        loginLabel = new JLabel("LOGIN");
        loginLabel.setBounds(200, 0, 100, 25);
        add(loginLabel);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 100, 25);
        add(usernameLabel);

        username = new JTextField();
        username.setBounds(151, 50, 100, 25);
        add(username);

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
        backButton.setBounds(200, 150, 100, 25);
        add(backButton);
        backButton.addActionListener(this);

        doConnect();
    }
    public void actionPerformed(ActionEvent evt) {

  if (evt.getSource() == loginButton) {
      String enteredUsername = username.getText();
      String enteredPassword = new String(password.getPassword());

      if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
          JOptionPane.showMessageDialog(this, "Please enter both username and password");
      } else {
          try {
              String SQL = "SELECT * FROM agent WHERE username = ? AND password = ?";
              pstmt = conn.prepareStatement(SQL);
              pstmt.setString(1, enteredUsername);
              pstmt.setString(2, enteredPassword);
              rs = pstmt.executeQuery();

              if (rs.next()) {
                  JOptionPane.showMessageDialog(this, "LOGGED IN");
                  loginButton.setEnabled(false);

                  // Open the agenthome window
                  agenthome agentHome = new agenthome();
                  agentHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  agentHome.setVisible(true);

                  dispose(); // Close the current frame
              } else {
                  JOptionPane.showMessageDialog(this, "Invalid username or password");
              }

          } catch (SQLException err) {
              JOptionPane.showMessageDialog(this, err.getMessage());
              System.out.println(err.getMessage());
          }
      }
  }

        if (evt.getSource() == delete) {
            username.setText("");
            password.setText("");
        }

        if (evt.getSource() == backButton) {
            First start = new First();
            start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            start.setVisible(true);
            dispose(); // Close the current frame
        }

    }
    public static void main(String[] args) {
        agentlogin login = new agentlogin();
        login.setVisible(true);
    }
    }
