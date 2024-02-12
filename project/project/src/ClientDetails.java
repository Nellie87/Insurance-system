import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class ClientDetails extends JFrame implements ActionListener {

    private Container c;
    private JLabel title;

    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel gender;
    private JLabel email;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel insurance_due_date;

    private JLabel balanceLabel;



    private JComboBox<String> date;
    private JComboBox<String> month;
    private JComboBox<String> year;

    private String clientName;
    private String url, username, password;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private String dates[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "July",
            "Aug", "Sep", "Oct", "Nov", "Dec"};
    private String years[] = {"2023","2024","2025","2026"," 2027","2028","2029","2030"};
    private String ins_type[] = {"Third-Party Only Insurance", "Third Party Fire and Theft Insurance", "Comprehensive Insurance"};

    private JLabel insurance;
    private JComboBox<String> tinsurance;
    private JTextField temail;
    private JLabel model;
    private JTextField tmodel;

    private JTextField balanceField;
    private JLabel plate;
    private JTextField tplate;
    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton backButton;


    public ClientDetails(String clientName) {
        this.clientName = clientName;

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Client Details");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Client Details");
        name.setFont(new Font("Arial", Font.PLAIN, 30));
        name.setSize(150, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(250, 100);
        tname.setEditable(false); // Make it non-editable
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
        tmno.setEditable(false); // Make it non-editable
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
        male.setEnabled(false); // Make it non-editable
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(325, 200);
        female.setEnabled(false); // Make it non-editable
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
        date.setEnabled(false); // Make it non-editable
        c.add(date);

        month = new JComboBox<>(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(300, 250);
        month.setEnabled(false); // Make it non-editable
        c.add(month);

        year = new JComboBox<>(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(360, 250);
        year.setEnabled(false); // Make it non-editable
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
        temail.setEnabled(false);
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
        tadd.setEnabled(false);
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
        tmodel.setEnabled(false);
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
        tplate.setEnabled(false);
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
        tinsurance.setEnabled(false);
        c.add(tinsurance);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 590);
        term.setEnabled(false);
        c.add(term);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 15));
        backButton.setSize(100, 20);
        backButton.setLocation(30, 630);
        backButton.addActionListener(this);
        c.add(backButton);

        balanceLabel = new JLabel("Balance: ");
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        balanceLabel.setSize(150, 20);
        balanceLabel.setLocation(100, 630);
        c.add(balanceLabel);


        balanceField = new JTextField("");
        balanceField.setFont(new Font("Arial", Font.PLAIN, 20));
        balanceField.setSize(150, 20);
        balanceField.setLocation(100, 700);
        c.add(balanceField);


        initializeClientDetails();
    }

    private void initializeClientDetails() {
        // Retrieve client details from the database
        retrieveClientDetails();

        // Display client details in the form
        initComponents();
        checkInsuranceDueDate();

        setVisible(true);
    }

    private void retrieveClientDetails() {
        url = "jdbc:mysql://localhost/login";
        username = "root";
        password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            String selectQuery = "SELECT * FROM registered_users WHERE name = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, clientName);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                JOptionPane.showMessageDialog(this, "No records found for " + clientName);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void adjustFrameSize() {
        pack(); // Sizes the frame based on its content
        setLocationRelativeTo(null); // Centers the frame on the screen
        setVisible(true);
    }
    private void checkInsuranceDueDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        String dueDateStr = date.getSelectedItem() + " " + month.getSelectedItem() + " " + year.getSelectedItem();
        try {
            Date dueDate = dateFormat.parse(dueDateStr);
            Date currentDate = new Date();

            // Calculate remaining days
            long diffInMillies = Math.abs(dueDate.getTime() - currentDate.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            // Check insurance type and display corresponding balance
            String insuranceType = (String) tinsurance.getSelectedItem();
            int balance = 0;
            String balanceMessage = "";

            switch (insuranceType) {
                case "Third-Party Only Insurance":
                    balance = 20000;
                    balanceMessage = "Balance: $20,000";
                    break;
                case "Third Party Fire and Theft Insurance":
                    balance = 50000;
                    balanceMessage = "Balance: $50,000";
                    break;
                case "Comprehensive Insurance":
                    balance = 100000;
                    balanceMessage = "Balance: $100,000";
                    break;
                default:
                    // Handle unknown insurance types if needed
                    break;
            }

            if (currentDate.after(dueDate)) {
                // Deadline has passed
                balanceMessage = "The insurance due date has passed. Please pay as soon as possible!\n" + balanceMessage;
            } else if (currentDate.equals(dueDate)) {
                // Due date is today
                balanceMessage = "Pay the insurance today!\n" + balanceMessage;
            } else {
                // Display days remaining for insurance payment
                balanceMessage = "Days remaining for insurance payment: " + diff + "\n" + balanceMessage;
            }

            // Display the message
            JOptionPane.showMessageDialog(this, balanceMessage);

            // Display the balance
            balanceLabel.setText("Balance: $" + balance);

        } catch (ParseException e) {
            e.printStackTrace(); // Handle the parsing exception as needed
        }
    }


    private void initComponents() {
        try {
            // Move the processing of the ResultSet inside this method after the retrieval
            if (resultSet != null) {
                tname.setText(resultSet.getString("name"));
                tmno.setText(resultSet.getString("mobile_number"));
                // ... (initialize other components and display data as needed)
                String genderValue = resultSet.getString("gender");
                if (genderValue.equals("Male")) {
                    male.setSelected(true);
                    female.setSelected(false);
                } else {
                    male.setSelected(false);
                    female.setSelected(true);
                }                // ...

                Date insurance_due_dateValue = resultSet.getDate("insurance_due_date");
                Calendar cal = Calendar.getInstance();
                cal.setTime(insurance_due_dateValue);
                date.setSelectedItem(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                month.setSelectedIndex(cal.get(Calendar.MONTH));
                year.setSelectedItem(String.valueOf(cal.get(Calendar.YEAR)));

                String email = resultSet.getString("email_address");
                temail.setText(email);

                String address = resultSet.getString("address");
                tadd.setText(address);

                String carModel = resultSet.getString("car_model");
                tmodel.setText(carModel);

                String numberPlate = resultSet.getString("number_plate");
                tplate.setText(numberPlate);

                String insuranceType = resultSet.getString("insurance_type");
                tinsurance.setSelectedItem(insuranceType);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception as per your application's needs
        } finally {
            // Close the database connection
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClientDetails frame = new ClientDetails("John Doe");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.adjustFrameSize();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose(); // Close the current frame
            ClientHome clientHomeFrame = new ClientHome(clientName);
            clientHomeFrame.setVisible(true);


        }
}}

