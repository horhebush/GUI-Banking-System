package Java;

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
    MusicPlayer player; // Reference to the musicPlayer instance passed from GUI.java
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

    public SignUpGUI(MusicPlayer player) {
        this.player = player; // Initialize the player instance passed from GUI.java
        loadFont();
        initializeWindow();
        initializePanel();
        addComponents();
        window.setVisible(true);
        
        // Initialize UserDetailsChecker
        detailsChecker = new UserDetailsChecker();
        
        // Center the window on the screen
        window.setLocationRelativeTo(null);
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
        window.setResizable(true);
        window.setSize(1350, 800);
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
        userNL.setBounds(10, 20, 150, 30);
        panelS.add(userNL);

        userNF = new JTextField();
        userNF.setBounds(170, 20, 450, 30);
        userNF.setFont(montserratFont);
        panelS.add(userNF);

        userPL = new JLabel("Password:");
        userPL.setFont(montserratFont);
        userPL.setBounds(10, 60, 150, 30);
        panelS.add(userPL);

        userPF = new JPasswordField();
        userPF.setBounds(170, 60, 450, 30);
        userPF.setFont(montserratFont);
        panelS.add(userPF);

        userPnL = new JLabel("Pin:");
        userPnL.setFont(montserratFont);
        userPnL.setBounds(10, 100, 150, 30);
        panelS.add(userPnL);

        userPnF = new JPasswordField();
        userPnF.setBounds(170, 100, 450, 30);
        userPnF.setFont(montserratFont);
        panelS.add(userPnF);

        fName = new JLabel("First Name:");
        fName.setFont(montserratFont);
        fName.setBounds(10, 140, 150, 30);
        panelS.add(fName);

        fNameF = new JTextField();
        fNameF.setBounds(170, 140, 450, 30);
        fNameF.setFont(montserratFont);
        panelS.add(fNameF);

        mName = new JLabel("Middle Name:");
        mName.setFont(montserratFont);
        mName.setBounds(10, 180, 150, 30);
        panelS.add(mName);

        mNameF = new JTextField();
        mNameF.setBounds(170, 180, 450, 30);
        mNameF.setFont(montserratFont);
        panelS.add(mNameF);

        lName = new JLabel("Last Name:");
        lName.setFont(montserratFont);
        lName.setBounds(10, 220, 150, 30);
        panelS.add(lName);

        lNameF = new JTextField();
        lNameF.setBounds(170, 220, 450, 30);
        lNameF.setFont(montserratFont);
        panelS.add(lNameF);

        birthDate = new JLabel("Date of Birth:");
        birthDate.setFont(montserratFont);
        birthDate.setBounds(10, 260, 150, 30);
        panelS.add(birthDate);

        dayComboBox = new JComboBox<>(generateDays());
        dayComboBox.setBounds(170, 260, 60, 30);
        dayComboBox.setFont(montserratFont);
        panelS.add(dayComboBox);

        monthComboBox = new JComboBox<>(new String[]{"Jan", "Feb", "Mar", "Apr", 
        "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        monthComboBox.setBounds(240, 260, 80, 30);
        monthComboBox.setFont(montserratFont);
        panelS.add(monthComboBox);

        yearComboBox = new JComboBox<>(generateYears(1920, 2023));
        yearComboBox.setBounds(330, 260, 80, 30);
        yearComboBox.setFont(montserratFont);
        panelS.add(yearComboBox);

        gender = new JLabel("Gender:");
        gender.setFont(montserratFont);
        gender.setBounds(10, 300, 150, 30);
        panelS.add(gender);

        genderDropdown = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        genderDropdown.setBounds(170, 300, 100, 30);
        genderDropdown.setFont(montserratFont);
        panelS.add(genderDropdown);

        addressHome = new JLabel("Address:");
        addressHome.setFont(montserratFont);
        addressHome.setBounds(650, 20, 150, 30);
        panelS.add(addressHome);

        addressHomeF = new JTextField();
        addressHomeF.setBounds(810, 20, 450, 30);
        addressHomeF.setFont(montserratFont);
        panelS.add(addressHomeF);

        motherN = new JLabel("Mother's Name:");
        motherN.setFont(montserratFont);
        motherN.setBounds(650, 60, 150, 30);
        panelS.add(motherN);

        motherNF = new JTextField();
        motherNF.setBounds(810, 60, 450, 30);
        motherNF.setFont(montserratFont);
        panelS.add(motherNF);

        fatherN = new JLabel("Father's Name:");
        fatherN.setFont(montserratFont);
        fatherN.setBounds(650, 100, 150, 30);
        panelS.add(fatherN);

        fatherNF = new JTextField();
        fatherNF.setBounds(810, 100, 450, 30);
        fatherNF.setFont(montserratFont);
        panelS.add(fatherNF);

        contactNumber = new JLabel("Contact Number:");
        contactNumber.setFont(montserratFont);
        contactNumber.setBounds(650, 140, 150, 30);
        panelS.add(contactNumber);

        contactNumberF = new JTextField();
        contactNumberF.setBounds(810, 140, 450, 30);
        contactNumberF.setFont(montserratFont);
        panelS.add(contactNumberF);

        contactEmail = new JLabel("Contact Email:");
        contactEmail.setFont(montserratFont);
        contactEmail.setBounds(650, 180, 150, 30);
        panelS.add(contactEmail);

        contactEmailF = new JTextField();
        contactEmailF.setBounds(810, 180, 450, 30);
        contactEmailF.setFont(montserratFont);
        panelS.add(contactEmailF);

        initialDep = new JLabel("Initial Deposit:");
        initialDep.setFont(montserratFont);
        initialDep.setBounds(650, 220, 150, 30);
        panelS.add(initialDep);

        initialDepF = new JTextField();
        initialDepF.setBounds(810, 220, 450, 30);
        initialDepF.setFont(montserratFont);
        panelS.add(initialDepF);

        submitButtn = new JButton("Submit");
        submitButtn.setBounds(900, 600, 150, 30);
        submitButtn.setFont(montserratFont);
        panelS.add(submitButtn);
        submitButtn.addActionListener(this);
        panelS.add(submitButtn);

        cancelButtn = new JButton("Cancel");
        cancelButtn.setBounds(1100, 600, 150, 30);
        cancelButtn.setFont(montserratFont);
        cancelButtn.addActionListener(this);
        panelS.add(cancelButtn);

        // Mute Button
        muteButton = new JButton("Mute");
        muteButton.setBounds(10, 600, 100, 30);
        muteButton.setFont(montserratFont);
        panelS.add(muteButton);

        // Anonymous ActionListener for the mute button
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
                clearFields();
                window.setVisible(false);
                JFrame LogIn = new LogIn ();
                LogIn.setVisible(true);
                
               	
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error saving data", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }

        cancelButtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cancelButtn) {
                    window.setVisible(false); // Close the current window
                    WelcomePage welcomePage = new WelcomePage();
                    welcomePage.setVisible(true);
                }
            }
        });
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