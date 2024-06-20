package javaSwing;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;

public class GUI implements ActionListener {

    ImageIcon logo;
    JFrame window;
    JPanel panelS;

    // Labels
    JLabel userNL;
    JLabel userPL;
    JLabel userPnL;
    JLabel fName;
    JLabel mName;
    JLabel lName;
    JLabel birthDate;
    JLabel gender;
    JLabel addressHome;
    JLabel fatherN;
    JLabel motherN;
    JLabel contactEmail;
    JLabel contactNumber;
    JLabel initialDep;

    // Fields
    JTextField userNF;
    JTextField fNameF;
    JTextField mNameF;
    JTextField lNameF;
    JPasswordField userPF;
    JPasswordField userPnF;
    JTextField addressHomeF;
    JTextField motherNF;
    JTextField fatherNF;
    JTextField contactEmailF;
    JTextField contactNumberF;
    JTextField initialDepF;

    // Buttons
    JButton submitButtn;
    JButton cancelButtn;

    // Font used
    Font montserratFont;

    // Date Dropdown
    JComboBox<String> dayComboBox;
    JComboBox<String> monthComboBox;
    JComboBox<String> yearComboBox;

    // Gender Dropdown
    JComboBox<String> genderDropdown;

    GUI() {
        try {
            InputStream is = getClass().getResourceAsStream("Montserrat-VariableFont_wght.ttf");
            montserratFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(12F);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(montserratFont);

        } catch (IOException | FontFormatException e) {
            System.out.println(e);
        }

        window = new JFrame();
        panelS = new JPanel();

        // window specifications
        logo = new ImageIcon("ICO-Test2.png");
        window.setIconImage(logo.getImage());
        window.setTitle("SignUp Window");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(900, 550);
        window.add(panelS);
        panelS.setLayout(null);

        // Labels; UserName, Pass, and Pin
        userNL = new JLabel();
        userNL.setText("User Name: ");
        userNL.setFont(montserratFont);
        userNL.setBounds(10, 20, 100, 25);
        panelS.add(userNL);

        userPL = new JLabel();
        userPL.setText("Password: ");
        userPL.setFont(montserratFont);
        userPL.setBounds(10, 50, 100, 25);
        panelS.add(userPL);

        userPnL = new JLabel();
        userPnL.setText("Pin: ");
        userPnL.setFont(montserratFont);
        userPnL.setBounds(10, 80, 100, 25);
        panelS.add(userPnL);

        // TextFields; UserName, Pass, and Pin
        userNF = new JTextField();
        userNF.setBounds(120, 20, 300, 25);
        userNF.setFont(montserratFont);
        panelS.add(userNF);

        userPF = new JPasswordField();
        userPF.setBounds(120, 50, 300, 25);
        userPF.setFont(montserratFont);
        panelS.add(userPF);

        userPnF = new JPasswordField();
        userPnF.setBounds(120, 80, 300, 25);
        userPnF.setFont(montserratFont);
        panelS.add(userPnF);

        // Label; fName, mName, and lName
        fName = new JLabel();
        fName.setText("First Name: ");
        fName.setFont(montserratFont);
        fName.setBounds(10, 110, 100, 25);
        panelS.add(fName);

        mName = new JLabel();
        mName.setText("Middle Name: ");
        mName.setFont(montserratFont);
        mName.setBounds(10, 140, 100, 25);
        panelS.add(mName);

        lName = new JLabel();
        lName.setText("Last Name:");
        lName.setFont(montserratFont);
        lName.setBounds(10, 170, 100, 25);
        panelS.add(lName);

        // TextFields; fNameF, mNameF, and lNameF
        fNameF = new JTextField();
        fNameF.setBounds(120, 110, 300, 25);
        fNameF.setFont(montserratFont);
        panelS.add(fNameF);

        mNameF = new JTextField();
        mNameF.setBounds(120, 140, 300, 25);
        mNameF.setFont(montserratFont);
        panelS.add(mNameF);

        lNameF = new JTextField();
        lNameF.setBounds(120, 170, 300, 25);
        lNameF.setFont(montserratFont);
        panelS.add(lNameF);

        // Label; birthDate, gender, addressHome
        birthDate = new JLabel();
        birthDate.setText("Date of Birth: ");
        birthDate.setFont(montserratFont);
        birthDate.setBounds(10, 200, 100, 25);
        panelS.add(birthDate);

        gender = new JLabel();
        gender.setText("Gender: ");
        gender.setFont(montserratFont);
        gender.setBounds(10, 230, 100, 25);
        panelS.add(gender);

        // Date Dropdown
        String[] daysOfMonth = new String[31]; // Assuming 31 days in the month
        for (int i = 0; i < 31; i++) {
            daysOfMonth[i] = String.valueOf(i + 1);
        }

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        String[] years = new String[104]; // Years from 1920 to 2023
        for (int i = 0; i < 104; i++) {
            years[i] = String.valueOf(1920 + i);
        }

        dayComboBox = new JComboBox<>(daysOfMonth);
        dayComboBox.setBounds(120, 200, 50, 25);
        dayComboBox.setFont(montserratFont);
        panelS.add(dayComboBox);

        monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(180, 200, 70, 25);
        monthComboBox.setFont(montserratFont);
        panelS.add(monthComboBox);

        yearComboBox = new JComboBox<>(years);
        yearComboBox.setBounds(260, 200, 70, 25);
        yearComboBox.setFont(montserratFont);
        panelS.add(yearComboBox);

        // Gender Dropdown
        String[] genders = {"Male", "Female", "Other"};

        genderDropdown = new JComboBox<>(genders);
        genderDropdown.setBounds(120, 230, 100, 25);
        panelS.add(genderDropdown);

        // Label; Address, motherN, and fatherN
        addressHome = new JLabel();
        addressHome.setText("Address: ");
        addressHome.setFont(montserratFont);
        addressHome.setBounds(450, 20, 100, 25);
        panelS.add(addressHome);

        motherN = new JLabel();
        motherN.setText("Mother's Name: ");
        motherN.setFont(montserratFont);
        motherN.setBounds(450, 50, 100, 25);
        panelS.add(motherN);

        fatherN = new JLabel();
        fatherN.setText("Father's name: ");
        fatherN.setFont(montserratFont);
        fatherN.setBounds(450, 80, 100, 25);
        panelS.add(fatherN);

        // TextField; Address, motherNF, and fatherNF
        addressHomeF = new JTextField();
        addressHomeF.setFont(montserratFont);
        addressHomeF.setBounds(560, 20, 300, 25);
        panelS.add(addressHomeF);

        motherNF = new JTextField();
        motherNF.setBounds(560, 50, 300, 25);
        motherNF.setFont(montserratFont);
        panelS.add(motherNF);

        fatherNF = new JTextField();
        fatherNF.setBounds(560, 80, 300, 25);
        fatherNF.setFont(montserratFont);
        panelS.add(fatherNF);

        // Label; ContactNumber & ContactEmail
        contactNumber = new JLabel();
        contactNumber.setText("Contact Number: ");
        contactNumber.setFont(montserratFont);
        contactNumber.setBounds(450, 110, 100, 25);
        panelS.add(contactNumber);

        contactEmail = new JLabel();
        contactEmail.setText("Contact Email: ");
        contactEmail.setFont(montserratFont);
        contactEmail.setBounds(450, 140, 100, 25);
        panelS.add(contactEmail);

        // TextField; ContactNumberF & ContactEmailF
        contactNumberF = new JTextField();
        contactNumberF.setBounds(560, 110, 300, 25);
        contactNumberF.setFont(montserratFont);
        panelS.add(contactNumberF);

        contactEmailF = new JTextField();
        contactEmailF.setBounds(560, 140, 300, 25);
        contactEmailF.setFont(montserratFont);
        panelS.add(contactEmailF);

        // Label; Initial Deposit
        initialDep = new JLabel();
        initialDep.setText("Initial Deposit:");
        initialDep.setFont(montserratFont);
        initialDep.setBounds(450, 170, 100, 25);
        panelS.add(initialDep);

        // TextField; initialDepF
        initialDepF = new JTextField();
        initialDepF.setBounds(560, 170, 300, 25);
        initialDepF.setFont(montserratFont);
        panelS.add(initialDepF);

        // Buttons; Submit and Cancel
        submitButtn = new JButton("Submit");
        submitButtn.setFont(montserratFont);
        submitButtn.setFocusable(false);
        submitButtn.addActionListener(this);

        cancelButtn = new JButton("Cancel");
        cancelButtn.setFont(montserratFont);
        cancelButtn.setFocusable(false);
        cancelButtn.addActionListener(this);

        // Add buttons to the panel
        panelS.add(submitButtn);
        panelS.add(cancelButtn);

        // Position the buttons
        int buttonWidth = 100;
        int buttonHeight = 25;
        int buttonSpacing = 20;
        int totalWidth = (buttonWidth * 2) + buttonSpacing;
        int startX = (window.getWidth() - totalWidth) / 2;
        int yPos = 450;

        submitButtn.setBounds(startX, yPos, buttonWidth, buttonHeight);
        cancelButtn.setBounds(startX + buttonWidth + buttonSpacing, yPos, buttonWidth, buttonHeight);

        // properties window; above code
        window.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) { // Check for button action command
            // Get user inputs from text fields
            String userName = userNF.getText().trim();
            String password = new String(userPF.getPassword());
            String pin = new String(userPnF.getPassword());
            String firstName = fNameF.getText().trim();
            String middleName = mNameF.getText().trim();
            String lastName = lNameF.getText().trim();
            String birthDate = (String) dayComboBox.getSelectedItem();
            String birthMonth = (String) monthComboBox.getSelectedItem();
            String birthYear = (String) yearComboBox.getSelectedItem();
            String genderSelect = (String) genderDropdown.getSelectedItem();
            String address = addressHomeF.getText().trim();
            String motherName = motherNF.getText().trim();
            String fatherName = fatherNF.getText().trim();
            String contactNumber = contactNumberF.getText().trim();
            String contactEmail = contactEmailF.getText().trim();
            String initialDeposit = initialDepF.getText().trim();

            // Validate if any required fields are empty
            if (userName.isEmpty()) {
                showErrorDialog("User Name");
                return;
            }
            if (password.isEmpty()) {
                showErrorDialog("Password");
                return;
            }
            if (pin.isEmpty()) {
                showErrorDialog("Pin");
                return;
            }
            if (firstName.isEmpty()) {
                showErrorDialog("First Name");
                return;
            }
            if (middleName.isEmpty()) {
                showErrorDialog("Middle Name");
                return;
            }
            if (lastName.isEmpty()) {
                showErrorDialog("Last Name");
                return;
            }
            if (birthDate.isEmpty()) {
                showErrorDialog("Birth Date");
                return;
            }
            if (birthMonth.isEmpty()) {
                showErrorDialog("Birth Month");
                return;
            }
            if (birthYear.isEmpty()) {
                showErrorDialog("Birth Year");
                return;
            }
            if (genderSelect.isEmpty()) {
                showErrorDialog("Gender");
                return;
            }
            if (address.isEmpty()) {
                showErrorDialog("Address");
                return;
            }
            if (motherName.isEmpty()) {
                showErrorDialog("Mother's Name");
                return;
            }
            if (fatherName.isEmpty()) {
                showErrorDialog("Father's Name");
                return;
            }
            if (contactNumber.isEmpty()) {
                showErrorDialog("Contact Number");
                return;
            }
            if (contactEmail.isEmpty()) {
                showErrorDialog("Contact Email");
                return;
            }
            if (initialDeposit.isEmpty()) {
                showErrorDialog("Initial Deposit");
                return;
            }

            // Generate unique file name
            int fileIndex = 1;
            String fileName = "user" + fileIndex + ".txt";
            File file = new File(fileName);

            // Check if the file exists, incrementing the index until a unique file name is found
            while (file.exists()) {
                fileIndex++;
                fileName = "user" + fileIndex + ".txt";
                file = new File(fileName);
            }

            // Write to file
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

                // Write each piece of information to the file
                writer.write("User Name: " + userName + "\n");
                writer.write("Password: " + password + "\n");
                writer.write("Pin: " + pin + "\n");
                writer.write("First Name: " + firstName + "\n");
                writer.write("Middle Name: " + middleName + "\n");
                writer.write("Last Name: " + lastName + "\n");
                writer.write("Birth Date: " + birthDate + " " + birthMonth + " " + birthYear + "\n");
                writer.write("Gender: " + genderSelect + "\n");
                writer.write("Address: " + address + "\n");
                writer.write("Mother's Name: " + motherName + "\n");
                writer.write("Father's Name: " + fatherName + "\n");
                writer.write("Contact Number: " + contactNumber + "\n");
                writer.write("Contact Email: " + contactEmail + "\n");
                writer.write("Initial Deposit: " + initialDeposit + "\n");

                writer.close();

                JOptionPane.showMessageDialog(window, "All inputs are valid! Data written to file: " + fileName, "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(window, "Error writing to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getActionCommand().equals("Cancel")) {
            // Clear all input fields
            userNF.setText("");
            userPF.setText("");
            userPnF.setText("");
            fNameF.setText("");
            mNameF.setText("");
            lNameF.setText("");
            dayComboBox.setSelectedIndex(0);
            monthComboBox.setSelectedIndex(0);
            yearComboBox.setSelectedIndex(0);
            genderDropdown.setSelectedIndex(0);
            addressHomeF.setText("");
            motherNF.setText("");
            fatherNF.setText("");
            contactNumberF.setText("");
            contactEmailF.setText("");
            initialDepF.setText("");
        }
    }

    private void showErrorDialog(String fieldName) {
        JOptionPane.showMessageDialog(window, fieldName + " is empty. Information is needed to be entered.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
