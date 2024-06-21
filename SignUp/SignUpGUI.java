package javaSwing;

import javax.swing.*;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

// This class provides the graphical user interface for user sign-up.
public class SignUpGUI implements ActionListener {

    ImageIcon logo;
    JFrame window;
    JPanel panelS;
    Font montserratFont;
    musicPlayer player; // Reference to the musicPlayer instance passed from GUI.java
    boolean isMuted = false;
    UserDetailsChecker detailsChecker; // UserDetailsChecker instance for duplicate checking

    // Labels
    JLabel userNL, userPL, userPnL, fName, mName,
    lName, birthDate, gender, addressHome, fatherN, motherN,
    contactEmail, contactNumber, initialDep;
    // Fields
    JTextField userNF, fNameF, mNameF, lNameF,
    addressHomeF, motherNF, fatherNF, 
    contactEmailF, contactNumberF, initialDepF;

    JPasswordField userPF, userPnF;
    JButton submitButtn, cancelButtn, muteButton;
    JComboBox<String> dayComboBox, monthComboBox, yearComboBox, genderDropdown;

    public SignUpGUI(musicPlayer player) {
        this.player = player; // Initialize the player instance passed from GUI.java
        loadFont();
        initializeWindow();
        initializePanel();
        addComponents();
        window.setVisible(true);
        
        // Initialize UserDetailsChecker
        detailsChecker = new UserDetailsChecker();
    }

    private void loadFont() {
        try {
            InputStream is = getClass().getResourceAsStream("Montserrat-VariableFont_wght.ttf");
            montserratFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(12F);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(montserratFont);
        } catch (IOException | FontFormatException e) {
            System.out.println(e);
        }
    }

    private void initializeWindow() {
        window = new JFrame();
        logo = new ImageIcon("ICO-Test2.png");
        window.setIconImage(logo.getImage());
        window.setTitle("SignUp Window");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(900, 360);
    }

    private void initializePanel() {
        panelS = new JPanel();
        panelS.setLayout(null);
        window.add(panelS);
    }

    private void addComponents() {
        // Labels and Fields
        userNL = new JLabel("User Name:");
        userNL.setFont(montserratFont);
        userNL.setBounds(10, 20, 100, 25);
        panelS.add(userNL);

        userNF = new JTextField();
        userNF.setBounds(120, 20, 300, 25);
        userNF.setFont(montserratFont);
        panelS.add(userNF);

        userPL = new JLabel("Password:");
        userPL.setFont(montserratFont);
        userPL.setBounds(10, 50, 100, 25);
        panelS.add(userPL);

        userPF = new JPasswordField();
        userPF.setBounds(120, 50, 300, 25);
        userPF.setFont(montserratFont);
        panelS.add(userPF);

        userPnL = new JLabel("Pin:");
        userPnL.setFont(montserratFont);
        userPnL.setBounds(10, 80, 100, 25);
        panelS.add(userPnL);

        userPnF = new JPasswordField();
        userPnF.setBounds(120, 80, 300, 25);
        userPnF.setFont(montserratFont);
        panelS.add(userPnF);

        fName = new JLabel("First Name:");
        fName.setFont(montserratFont);
        fName.setBounds(10, 110, 100, 25);
        panelS.add(fName);

        fNameF = new JTextField();
        fNameF.setBounds(120, 110, 300, 25);
        fNameF.setFont(montserratFont);
        panelS.add(fNameF);

        mName = new JLabel("Middle Name:");
        mName.setFont(montserratFont);
        mName.setBounds(10, 140, 100, 25);
        panelS.add(mName);

        mNameF = new JTextField();
        mNameF.setBounds(120, 140, 300, 25);
        mNameF.setFont(montserratFont);
        panelS.add(mNameF);

        lName = new JLabel("Last Name:");
        lName.setFont(montserratFont);
        lName.setBounds(10, 170, 100, 25);
        panelS.add(lName);

        lNameF = new JTextField();
        lNameF.setBounds(120, 170, 300, 25);
        lNameF.setFont(montserratFont);
        panelS.add(lNameF);

        birthDate = new JLabel("Date of Birth:");
        birthDate.setFont(montserratFont);
        birthDate.setBounds(10, 200, 100, 25);
        panelS.add(birthDate);

        dayComboBox = new JComboBox<>(generateDays());
        dayComboBox.setBounds(120, 200, 60, 25);
        dayComboBox.setFont(montserratFont);
        panelS.add(dayComboBox);

        monthComboBox = new JComboBox<>(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        monthComboBox.setBounds(190, 200, 80, 25);
        monthComboBox.setFont(montserratFont);
        panelS.add(monthComboBox);

        yearComboBox = new JComboBox<>(generateYears(1920, 2023));
        yearComboBox.setBounds(280, 200, 80, 25);
        yearComboBox.setFont(montserratFont);
        panelS.add(yearComboBox);

        gender = new JLabel("Gender:");
        gender.setFont(montserratFont);
        gender.setBounds(10, 230, 100, 25);
        panelS.add(gender);

        genderDropdown = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        genderDropdown.setBounds(120, 230, 100, 25);
        genderDropdown.setFont(montserratFont);
        panelS.add(genderDropdown);

        addressHome = new JLabel("Address:");
        addressHome.setFont(montserratFont);
        addressHome.setBounds(450, 20, 100, 25);
        panelS.add(addressHome);

        addressHomeF = new JTextField();
        addressHomeF.setBounds(560, 20, 300, 25);
        addressHomeF.setFont(montserratFont);
        panelS.add(addressHomeF);

        motherN = new JLabel("Mother's Name:");
        motherN.setFont(montserratFont);
        motherN.setBounds(450, 50, 100, 25);
        panelS.add(motherN);

        motherNF = new JTextField();
        motherNF.setBounds(560, 50, 300, 25);
        motherNF.setFont(montserratFont);
        panelS.add(motherNF);

        fatherN = new JLabel("Father's Name:");
        fatherN.setFont(montserratFont);
        fatherN.setBounds(450, 80, 100, 25);
        panelS.add(fatherN);

        fatherNF = new JTextField();
        fatherNF.setBounds(560, 80, 300, 25);
        fatherNF.setFont(montserratFont);
        panelS.add(fatherNF);

        contactNumber = new JLabel("Contact Number:");
        contactNumber.setFont(montserratFont);
        contactNumber.setBounds(450, 110, 100, 25);
        panelS.add(contactNumber);

        contactNumberF = new JTextField();
        contactNumberF.setBounds(560, 110, 300, 25);
        contactNumberF.setFont(montserratFont);
        panelS.add(contactNumberF);

        contactEmail = new JLabel("Contact Email:");
        contactEmail.setFont(montserratFont);
        contactEmail.setBounds(450, 140, 100, 25);
        panelS.add(contactEmail);

        contactEmailF = new JTextField();
        contactEmailF.setBounds(560, 140, 300, 25);
        contactEmailF.setFont(montserratFont);
        panelS.add(contactEmailF);

        initialDep = new JLabel("Initial Deposit:");
        initialDep.setFont(montserratFont);
        initialDep.setBounds(450, 170, 100, 25);
        panelS.add(initialDep);

        initialDepF = new JTextField();
        initialDepF.setBounds(560, 170, 300, 25);
        initialDepF.setFont(montserratFont);
        panelS.add(initialDepF);

        submitButtn = new JButton("Submit");
        submitButtn.setBounds(560, 200, 80, 25);
        submitButtn.setFont(montserratFont);
        panelS.add(submitButtn);
        submitButtn.addActionListener(this);

        cancelButtn = new JButton("Cancel");
        cancelButtn.setBounds(680, 200, 80, 25);
        cancelButtn.setFont(montserratFont);
        panelS.add(cancelButtn);
        cancelButtn.addActionListener(this);

        // Mute Button
        muteButton = new JButton("Mute");
        muteButton.setBounds(780, 290, 80, 25);
        muteButton.setFont(montserratFont);
        panelS.add(muteButton);

        // Anonymous ActionListener; only for the task of muting, basically
        muteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isMuted = !isMuted;
                if (isMuted) {
                    muteButton.setText("Unmute");
                    player.mute();
                } else {
                    muteButton.setText("Mute");
                    player.unmute();
                }
            }
        });
    }

    private String[] generateDays() {
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }
        return days;
    }

    private String[] generateYears(int startYear, int endYear) {
        int numberOfYears = endYear - startYear + 1;
        String[] years = new String[numberOfYears];
        for (int i = 0; i < numberOfYears; i++) {
            years[i] = String.valueOf(startYear + i);
        }
        return years;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButtn) {
            // Get user input
        	String username, password, pin, firstName, middleName, lastName,
        	dobDay, dobMonth, dobYear, gender, address, fatherName, motherName,
        	contactEmail, contactNumber, initialDeposit;
        	
            username = userNF.getText().trim();
            password = new String(userPF.getPassword());
            pin = new String(userPnF.getPassword());
            firstName = fNameF.getText().trim();
            middleName = mNameF.getText().trim();
            lastName = lNameF.getText().trim();
            dobDay = (String) dayComboBox.getSelectedItem();
            dobMonth = (String) monthComboBox.getSelectedItem();
            dobYear = (String) yearComboBox.getSelectedItem();
            gender = (String) genderDropdown.getSelectedItem();
            address = addressHomeF.getText().trim();
            fatherName = fatherNF.getText().trim();
            motherName = motherNF.getText().trim();
            contactEmail = contactEmailF.getText().trim();
            contactNumber = contactNumberF.getText().trim();
            initialDeposit = initialDepF.getText().trim();

            // Validate required fields
            if (username.isEmpty() || password.isEmpty() || pin.isEmpty() || firstName.isEmpty() ||
                    lastName.isEmpty() || dobDay == null || dobMonth == null || dobYear == null ||
                    gender == null || address.isEmpty() || fatherName.isEmpty() || motherName.isEmpty() ||
                    contactEmail.isEmpty() || contactNumber.isEmpty() || initialDeposit.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please fill out all required fields", "Missing Information", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Validate the PIN as a 6-digit number
            if (!pin.matches("\\d{6}")) {
                JOptionPane.showMessageDialog(null, "PIN must be a 6-digit number", "Invalid PIN", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Check for duplicates
            if (detailsChecker.isDuplicate(username) ||
                    detailsChecker.isDuplicateFirstName(firstName) ||
                    detailsChecker.isDuplicateMiddleName(middleName) ||
                    detailsChecker.isDuplicateLastName(lastName)) {

                    JOptionPane.showMessageDialog(null, "There is an account with this information already", "Duplicate Information", JOptionPane.WARNING_MESSAGE);
                    return;
                }

            // Continue with saving data if all validations pass
            int fileNumber = getNextFileNumber();
            String fileName = "user_details" + fileNumber + ".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName)))) {
                // Write user data to file
                writer.write(username + "\n");
                writer.write(password + "\n");
                writer.write(pin + "\n");
                writer.write(firstName + "\n");
                writer.write(middleName + "\n");
                writer.write(lastName + "\n");
                writer.write(dobDay + "/" + dobMonth + "/" + dobYear + "\n");
                writer.write(gender + "\n");
                writer.write(address + "\n");
                writer.write(motherName + "\n");
                writer.write(fatherName + "\n");
                writer.write(contactNumber + "\n");
                writer.write(contactEmail + "\n");
                writer.write(initialDeposit + "\n");

                JOptionPane.showMessageDialog(null, "Data submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Clear all fields after successful submission
                clearFields();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error saving data", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }

        if (e.getSource() == cancelButtn) {
            window.dispose();
        }
    }

    private int getNextFileNumber() {
        int fileNumber = 1;
        while (new File("user_details" + fileNumber + ".txt").exists()) {
            fileNumber++;
        }
        return fileNumber;
    }

    // Clears all input fields after successful data submission.
    private void clearFields() {
        userNF.setText("");
        userPF.setText("");
        userPnF.setText("");
        fNameF.setText("");
        mNameF.setText("");
        lNameF.setText("");
        addressHomeF.setText("");
        motherNF.setText("");
        fatherNF.setText("");
        contactEmailF.setText("");
        contactNumberF.setText("");
        initialDepF.setText("");
    }
}
