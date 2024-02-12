import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class MyFrame extends JFrame implements ActionListener {

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
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    private JLabel insurance;
    private JComboBox<String> tinsurance;
    private JLabel email;
    private JTextField temail;
    private JLabel model;
    private JTextField tmodel;
    private JLabel plate;
    private JTextField tplate;

    private JButton backButton;


    String url, username, password;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    private String dates[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    private String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "July",
            "Aug", "Sep", "Oct", "Nov", "Dec" };
    private String years[] = { "2023","2024","2025","2026"," 2027","2028","2029","2030"};

    private String ins_type[] = { "Third-Party Only Insurance", "Third Party Fire and Theft Insurance", "Comprehensive Insurance" };

    public MyFrame() {
        setTitle("Registration Form");
        setBounds(300, 90, 950, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Registration Form");
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

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 630);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 630);
        reset.addActionListener(this);
        c.add(reset);



        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 550);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 660);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);


        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 15));
        backButton.setSize(100, 20);
        backButton.setLocation(30, 630);
        backButton.addActionListener(this);
        c.add(backButton);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            url = "jdbc:mysql://localhost/login";
            username = "root";
            password = "";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);

                String insertQuery = "INSERT INTO registered_users (name, mobile_number, gender, insurance_due_date, email_address, address, car_model, number_plate, insurance_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(insertQuery);

                preparedStatement.setString(1, tname.getText());
                preparedStatement.setString(2, tmno.getText());
                preparedStatement.setString(3, male.isSelected() ? "Male" : "Female");
                String dateString = year.getSelectedItem() + "-" + (month.getSelectedIndex() + 1) + "-" + date.getSelectedItem();
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date utilDate = sdf.parse(dateString);
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                    preparedStatement.setDate(4, sqlDate);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    res.setText("Error occurred during date parsing.");
                    return; // Stop execution if date parsing fails
                }
               preparedStatement.setString(5, temail.getText());
                preparedStatement.setString(6, tadd.getText());
                preparedStatement.setString(7, tmodel.getText());
                preparedStatement.setString(8, tplate.getText());
                preparedStatement.setString(9, tinsurance.getSelectedItem().toString());

                preparedStatement.executeUpdate();

                tout.setText(getRegistrationData());
                tout.setEditable(false);
                res.setText("Registration Successful.");

                preparedStatement.close();
                connection.close();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                res.setText("Error occurred during registration.");
            }
        } else if (e.getSource() == reset) {
            resetForm();
        }
        else if (e.getSource() == backButton) {
            dispose(); // Close the current frame
            agenthome agentHome = new agenthome();
            agentHome.setVisible(true);
        }

    }

    private String getRegistrationData() {
        String data = "Name: " + tname.getText() + "\n"
                + "Mobile Number: " + tmno.getText() + "\n"
                + "Gender: " + (male.isSelected() ? "Male" : "Female") + "\n"
                + "insurance_due_date: " + date.getSelectedItem() + " " + month.getSelectedItem() + " " + year.getSelectedItem() + "\n"
                + "Email Address: " + temail.getText() + "\n"
                + "Address: " + tadd.getText() + "\n"
                + "Car Model: " + tmodel.getText() + "\n"
                + "Number Plate: " + tplate.getText() + "\n"
                + "Insurance Type: " + tinsurance.getSelectedItem().toString();
        return data;
    }

    private void resetForm() {
        tname.setText("");
        tmno.setText("");
        male.setSelected(true);
        date.setSelectedIndex(0);
        month.setSelectedIndex(0);
        year.setSelectedIndex(0);
        temail.setText("");
        tadd.setText("");
        tmodel.setText("");
        tplate.setText("");
        tinsurance.setSelectedIndex(0);
        term.setSelected(false);
        tout.setText("");
        res.setText("");
        resadd.setText("");
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyFrame frame = new MyFrame();
            frame.setVisible(true);
        });
    }
}
