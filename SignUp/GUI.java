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
import java.util.regex.Pattern;
import javax.swing.*;

public class SignUpGUI implements ActionListener {

    ImageIcon logo;
    JFrame window;
    JPanel panelS;
    Font montserratFont;
    musicPlayer player; // Reference to the musicPlayer instance passed from GUI.java
    boolean isMuted = false;

    // Labels 
    JLabel userNL, userPL, userPnL, fName, mName, 
    lName, birthDate, gender, addressHome, fatherN, motherN, 
    contactEmail, contactNumber, initialDep;
    // Fields
    JTextField userNF, fNameF, mNameF, lNameF, 
    addressHomeF, motherNF, fatherNF, contactEmailF, contactNumberF, initialDepF;
    
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

    private int getNextFileNumber() {
        int fileNumber = 1;
        while (new File("user_details" + fileNumber + ".txt").exists()) {
            fileNumber++;
        }
        return fileNumber;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButtn) {
            String username = userNF.getText();
            String password = new String(userPF.getPassword());
            String pin = new String(userPnF.getPassword());
            String firstName = fNameF.getText();
            String middleName = mNameF.getText();
            String lastName = lNameF.getText();
            String dobDay = (String) dayComboBox.getSelectedItem();
            String dobMonth = (String) monthComboBox.getSelectedItem();
            String dobYear = (String) yearComboBox.getSelectedItem();
            String gender = (String) genderDropdown.getSelectedItem();
            String address = addressHomeF.getText();
            String fatherName = fatherNF.getText();
            String motherName = motherNF.getText();
            String contactEmail = contactEmailF.getText();
            String contactNumber = contactNumberF.getText();
            String initialDeposit = initialDepF.getText();

            // Validate the PIN as a 6-digit number
            if (!Pattern.matches("\\d{6}", pin)) {
                JOptionPane.showMessageDialog(null, "PIN must be a 6-digit number");
                return;
            }

            int fileNumber = getNextFileNumber();
            String fileName = "user_details" + fileNumber + ".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName)))) {
                writer.write(username + "\n");
                writer.write(password + "\n");
                writer.write(pin + "\n");
                writer.write(firstName + "\n");
                writer.write(middleName + "\n");
                writer.write(lastName + "\n");
                writer.write(dobDay + "/" + dobMonth + "/" + dobYear + "\n");
                writer.write(gender + "\n");
                writer.write(address + "\n");
                writer.write(fatherName + "\n");
                writer.write(motherName + "\n");
                writer.write(contactEmail + "\n");
                writer.write(contactNumber + "\n");
                writer.write(initialDeposit + "\n");

                JOptionPane.showMessageDialog(null, "Data submitted successfully!");

                // Clear all fields after successful submission
                clearFields();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == cancelButtn) {
            window.dispose();
        }
    }

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
