import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;

class viewclient extends JFrame implements ActionListener {

    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel insurance_due_date;
    private JComboBox<String> date;
    private JComboBox<String> month;
    private JComboBox<String> year;
    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;

    private JButton next;
    private JButton previous;
    private JButton backButton;

    private JLabel insurance;
    private JComboBox<String> tinsurance;
    private JLabel email;
    private JTextField temail;
    private JLabel model;
    private JTextField tmodel;
    private JLabel plate;
    private JTextField tplate;
    private JButton saveButton;
    String url, username, password;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    private String dates[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "July",
            "Aug", "Sep", "Oct", "Nov", "Dec"};
    private String years[] = {"2023","2024","2025","2026"," 2027","2028","2029","2030"};

    private String ins_type[] = {"Third-Party Only Insurance", "Third Party Fire and Theft Insurance", "Comprehensive Insurance"};
    private int user_id;
    public viewclient() {
        setTitle("View Client");
        setBounds(300, 90, 950, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("View Client");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(150, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(250, 100);
        c.add(tname);

        mno = new JLabel("Mobile Number");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(150, 20);
        mno.setLocation(100, 150);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(190, 20);
        tmno.setLocation(250, 150);
        c.add(tmno);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(150, 20);
        gender.setLocation(100, 200);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(250, 200);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(325, 200);
        c.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);
        insurance_due_date = new JLabel("insurance_due_date");
        insurance_due_date.setFont(new Font("Arial", Font.PLAIN, 20));
        insurance_due_date.setSize(150, 20);
        insurance_due_date.setLocation(100, 250);
        c.add(insurance_due_date);

        date = new JComboBox<>(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(250, 250);
        c.add(date);

        month = new JComboBox<>(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(300, 250);
        c.add(month);

        year = new JComboBox<>(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(360, 250);
        c.add(year);

        email = new JLabel("Email Address");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(150, 20);
        email.setLocation(100, 300);
        c.add(email);

        temail = new JTextField();
        temail.setFont(new Font("Arial", Font.PLAIN, 15));
        temail.setSize(190, 20);
        temail.setLocation(250, 300);
        c.add(temail);

        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(150, 20);
        add.setLocation(100, 350);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(200, 75);
        tadd.setLocation(250, 350);
        tadd.setLineWrap(true);
        c.add(tadd);

        model = new JLabel("Car Model");
        model.setFont(new Font("Arial", Font.PLAIN, 20));
        model.setSize(150, 20);
        model.setLocation(100, 450);
        c.add(model);

        tmodel = new JTextField();
        tmodel.setFont(new Font("Arial", Font.PLAIN, 15));
        tmodel.setSize(190, 20);
        tmodel.setLocation(250, 450);
        c.add(tmodel);

        plate = new JLabel("Number Plate");
        plate.setFont(new Font("Arial", Font.PLAIN, 20));
        plate.setSize(150, 20);
        plate.setLocation(100, 500);
        c.add(plate);

        tplate = new JTextField();
        tplate.setFont(new Font("Arial", Font.PLAIN, 15));
        tplate.setSize(190, 20);
        tplate.setLocation(250, 500);
        c.add(tplate);

        insurance = new JLabel("Insurance Type");
        insurance.setFont(new Font("Arial", Font.PLAIN, 20));
        insurance.setSize(150, 20);
        insurance.setLocation(100, 550);
        c.add(insurance);

        tinsurance = new JComboBox<>(ins_type);
        tinsurance.setFont(new Font("Arial", Font.PLAIN, 15));
        tinsurance.setSize(225, 20);
        tinsurance.setLocation(250, 550);
        c.add(tinsurance);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 590);
        c.add(term);

        next = new JButton("Next");
        next.setFont(new Font("Arial", Font.PLAIN, 15));
        next.setSize(100, 20);
        next.setLocation(390, 630);
        next.addActionListener(this);
        c.add(next);

        previous = new JButton("Previous");
        previous.setFont(new Font("Arial", Font.PLAIN, 15));
        previous.setSize(100, 20);
        previous.setLocation(150, 630);
        previous.addActionListener(this);
        c.add(previous);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 15));
        backButton.setSize(100, 20);
        backButton.setLocation(30, 630);
        backButton.addActionListener(this);
        c.add(backButton);

        saveButton = new JButton("Save");
        saveButton.setFont(new Font("Arial", Font.PLAIN, 15));
        saveButton.setSize(150, 20);
        saveButton.setLocation(250, 630);
        saveButton.addActionListener(this);
        c.add(saveButton);

        setVisible(true);
        url = "jdbc:mysql://localhost/login";
        username = "root";
        password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            String selectQuery = "SELECT * FROM registered_users";
            preparedStatement = connection.prepareStatement(selectQuery, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                displayData();
            } else {
                JOptionPane.showMessageDialog(this, "No records found.");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose(); // Close the current frame
            agenthome agentHome = new agenthome();
            agentHome.setVisible(true);
        } else if (e.getSource() == next) {
            try {
                if (resultSet.next()) {
                    displayData();
                } else {
                    resultSet.last();
                    JOptionPane.showMessageDialog(this, "End of records.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == previous) {
            try {
                if (resultSet.previous()) {
                    displayData();
                } else {
                    resultSet.first();
                    JOptionPane.showMessageDialog(this, "Start of records.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (e.getSource() == saveButton){
            try {
                updateData();
            } catch (Exception ex) {
                Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
    private void updateData() {
        try {
            // Get the edited values from the fields
            String newName = tname.getText();
            String newMobileNumber = tmno.getText();
            String newGender = male.isSelected() ? "Male" : "Female";

            int newDate = Integer.parseInt(date.getSelectedItem().toString());
            int newMonth = month.getSelectedIndex();
            int newYear = Integer.parseInt(year.getSelectedItem().toString());

            Calendar newDateOfBirth = Calendar.getInstance();
            newDateOfBirth.set(newYear, newMonth, newDate);
            Date newInsuranceDueDate = new Date(newDateOfBirth.getTimeInMillis());

            String newEmail = temail.getText();
            String newAddress = tadd.getText();
            String newCarModel = tmodel.getText();
            String newNumberPlate = tplate.getText();
            String newInsuranceType = tinsurance.getSelectedItem().toString();

            // Construct and execute SQL update statement
            String updateQuery = "UPDATE registered_users SET name=?, mobile_number=?, gender=?, insurance_due_date=?, email_address=?, address=?, car_model=?, number_plate=?, insurance_type=? WHERE user_id=?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, newName);
            updateStatement.setString(2, newMobileNumber);
            updateStatement.setString(3, newGender);
            updateStatement.setDate(4, newInsuranceDueDate);
            updateStatement.setString(5, newEmail);
            updateStatement.setString(6, newAddress);
            updateStatement.setString(7, newCarModel);
            updateStatement.setString(8, newNumberPlate);
            updateStatement.setString(9, newInsuranceType);
            // Assuming user_id is the primary key of the table, replace with your actual primary key column
            updateStatement.setInt(10, user_id);

            int rowsAffected = updateStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Update successful.");
            } else {
                JOptionPane.showMessageDialog(this, "Update done.");
            }
            // Update the current row in the ResultSet
            resultSet.updateString("name", newName);
            resultSet.updateString("mobile_number", newMobileNumber);
            resultSet.updateString("gender", newGender);
            resultSet.updateDate("insurance_due_date", newInsuranceDueDate);
            resultSet.updateString("email_address", newEmail);
            resultSet.updateString("address", newAddress);
            resultSet.updateString("car_model", newCarModel);
            resultSet.updateString("number_plate", newNumberPlate);
            resultSet.updateString("insurance_type", newInsuranceType);
            resultSet.updateRow();
        } catch (SQLException | NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while updating data.");
        }
    }

    private void displayData() throws SQLException {
        tname.setText(resultSet.getString("name"));
        tmno.setText(resultSet.getString("mobile_number"));
        String genderValue = resultSet.getString("gender");
        if (genderValue.equals("Male")) {
            male.setSelected(true);
            female.setSelected(false);
        } else {
            male.setSelected(false);
            female.setSelected(true);
        }
        Date insurance_due_dateValue = resultSet.getDate("insurance_due_date");
        Calendar cal = Calendar.getInstance();
        cal.setTime(insurance_due_dateValue);
        date.setSelectedItem(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
        month.setSelectedIndex(cal.get(Calendar.MONTH));
        year.setSelectedItem(String.valueOf(cal.get(Calendar.YEAR)));
        temail.setText(resultSet.getString("email_address"));
        tadd.setText(resultSet.getString("address"));
        tmodel.setText(resultSet.getString("car_model"));
        tplate.setText(resultSet.getString("number_plate"));
        tinsurance.setSelectedItem(resultSet.getString("insurance_type"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            viewclient frame = new viewclient();
            frame.setVisible(true);
        });
    }
}
