package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader; 
import java.io.IOException;

public class AccountInfo {
    private JFrame frame;
    private JPanel panel;

    private JTextField userNameField;
    private JTextField passWordField;
    private JTextField pinCodeField;
    private JTextField firstNameField;
    private JTextField middleNameField;
    private JTextField lastNameField;
    private JTextField birthDateField;
    private JTextField genderField;
    private JTextField addressField;
    private JTextField fatherNameField;
    private JTextField motherNameField;
    private JTextField contactEmailField;
    private JTextField contactNumberField;
    private JTextField initialDepositField;
    private JTextField accNumberField;

    public AccountInfo() {
        initializeUI();
        loadUserInfo();
    }

    private void initializeUI() {
        frame = new JFrame("Account Information Panel");
        frame.setSize(1350, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(50, 0, 1250, 750);
        frame.add(panel);

        int labelWidth = 200;
        int fieldWidth = 600;
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);

        userNameField = createTextField(260, 30, fieldWidth, 30, fieldFont);
        passWordField = createTextField(260, 70, fieldWidth, 30, fieldFont);
        pinCodeField = createTextField(260, 110, fieldWidth, 30, fieldFont);
        firstNameField = createTextField(260, 150, fieldWidth, 30, fieldFont);
        middleNameField = createTextField(260, 190, fieldWidth, 30, fieldFont);
        lastNameField = createTextField(260, 230, fieldWidth, 30, fieldFont);
        birthDateField = createTextField(260, 270, fieldWidth, 30, fieldFont);
        genderField = createTextField(260, 310, fieldWidth, 30, fieldFont);
        addressField = createTextField(260, 350, fieldWidth, 30, fieldFont);
        fatherNameField = createTextField(260, 390, fieldWidth, 30, fieldFont);
        motherNameField = createTextField(260, 430, fieldWidth, 30, fieldFont);
        contactEmailField = createTextField(260, 470, fieldWidth, 30, fieldFont);
        contactNumberField = createTextField(260, 510, fieldWidth, 30, fieldFont);
        initialDepositField = createTextField(260, 550, fieldWidth, 30, fieldFont);
        accNumberField = createTextField(260, 590, fieldWidth, 30, fieldFont);
	accNumberField.setText("20240001");

        JLabel userNameLabel = createLabel("User Name:", 50, 30, labelWidth, 30, labelFont);
        JLabel passWordLabel = createLabel("Password:", 50, 70, labelWidth, 30, labelFont);
        JLabel pinCodeLabel = createLabel("Pin:", 50, 110, labelWidth, 30, labelFont);
        JLabel firstNameLabel = createLabel("First Name:", 50, 150, labelWidth, 30, labelFont);
        JLabel middleNameLabel = createLabel("Middle Name:", 50, 190, labelWidth, 30, labelFont);
        JLabel lastNameLabel = createLabel("Last Name:", 50, 230, labelWidth, 30, labelFont);
        JLabel birthDateLabel = createLabel("Birth Date:", 50, 270, labelWidth, 30, labelFont);
        JLabel genderLabel = createLabel("Gender:", 50, 310, labelWidth, 30, labelFont);
        JLabel addressLabel = createLabel("Address:", 50, 350, labelWidth, 30, labelFont);
        JLabel fatherNameLabel = createLabel("Father's Name:", 50, 390, labelWidth, 30, labelFont);
        JLabel motherNameLabel = createLabel("Mother's Name:", 50, 430, labelWidth, 30, labelFont);
        JLabel contactEmailLabel = createLabel("Contact Email:", 50, 470, labelWidth, 30, labelFont);
        JLabel contactNumberLabel = createLabel("Contact Number:", 50, 510, labelWidth, 30, labelFont);
        JLabel initialDepositLabel = createLabel("Initial Deposit:", 50, 550, labelWidth, 30, labelFont);
        JLabel accNumberLabel = createLabel("Account Number:", 50, 590, labelWidth, 30, labelFont);

        
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(1150, 700, 100, 30);
        exitButton.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) {
        	AccountInfo.setVisible(false);
        	JFrame HomePanel = new HomePanel();
        	HomePanel.setVisible(true);
        }
        });

        panel.add(exitButton);
        panel.add(userNameLabel);
        panel.add(passWordLabel);
        panel.add(pinCodeLabel);
        panel.add(firstNameLabel);
        panel.add(middleNameLabel);
        panel.add(lastNameLabel);
        panel.add(birthDateLabel);
        panel.add(genderLabel);
        panel.add(addressLabel);
        panel.add(fatherNameLabel);
        panel.add(motherNameLabel);
        panel.add(contactEmailLabel);
        panel.add(contactNumberLabel);
        panel.add(initialDepositLabel);
        panel.add(accNumberLabel);

        panel.add(userNameField);
        panel.add(passWordField);
        panel.add(pinCodeField);
        panel.add(firstNameField);
        panel.add(middleNameField);
        panel.add(lastNameField);
        panel.add(birthDateField);
        panel.add(genderField);
        panel.add(addressField);
        panel.add(fatherNameField);
        panel.add(motherNameField);
        panel.add(contactEmailField);
        panel.add(contactNumberField);
        panel.add(initialDepositField);
        panel.add(accNumberField);

        frame.setVisible(true);
    }

    protected static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private JLabel createLabel(String text, int x, int y, int width, int height, Font font) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(font);
        return label;
    }

    private JTextField createTextField(int x, int y, int width, int height, Font font) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setFont(font);
        textField.setEditable(false);
        textField.setFocusable(false);
        textField.setBackground(Color.WHITE);
        return textField;
    }

    private void loadUserInfo() {
        File directory = new File(".");
        File[] files = directory.listFiles((dir, name) -> name.startsWith("user_details") && name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    int lineNumber = 0;
                    while ((line = reader.readLine()) != null) {
                        switch (lineNumber) {
                            case 0:
                                userNameField.setText(line);
                                break;
                            case 1:
                                passWordField.setText(line);
                                break;
                            case 2:
                                pinCodeField.setText(line);
                                break;
                            case 3:
                                firstNameField.setText(line);
                                break;
                            case 4:
                                middleNameField.setText(line);
                                break;
                            case 5:
                                lastNameField.setText(line);
                                break;
                            case 6:
                                birthDateField.setText(line);
                                break;
                            case 7:
                                genderField.setText(line);
                                break;
                            case 8:
                                addressField.setText(line);
                                break;
                            case 9:
                                fatherNameField.setText(line);
                                break;
                            case 10:
                                motherNameField.setText(line);
                                break;
                            case 11:
                                contactEmailField.setText(line);
                                break;
                            case 12:
                                contactNumberField.setText(line);
                                break;
                            case 13:
                                try {
                                    double initialDeposit = Double.parseDouble(line);
                                    initialDepositField.setText(line);
                                } catch (NumberFormatException e) {
                                    System.err.println("Invalid initial deposit value: " + line);
                                }
                                break;
                            case 14:
                                accNumberField.setText("2024100000"); // Set the account number
                                break;
                        }
                        lineNumber++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public double getInitialDeposit() {
        double initialDeposit = 0.0;
        try {
            initialDeposit = Double.parseDouble(initialDepositField.getText());
        } catch (NumberFormatException e) {
            System.err.println("Invalid initial deposit value: " + initialDepositField.getText());
        }
        return initialDeposit;
    }

    public String getAccountDetails() {
        // Example method to get all account details as a formatted string
        return "User Name: " + userNameField.getText() + "\n" +
                "Password: " + passWordField.getText() + "\n" +
                "Pin: " + pinCodeField.getText() + "\n" +
                "First Name: " + firstNameField.getText() + "\n" +
                "Middle Name: " + middleNameField.getText() + "\n" +
                "Last Name: " + lastNameField.getText() + "\n" +
                "Birth Date: " + birthDateField.getText() + "\n" +
                "Gender: " + genderField.getText() + "\n" +
                "Address: " + addressField.getText() + "\n" +
                "Father's Name: " + fatherNameField.getText() + "\n" +
                "Mother's Name: " + motherNameField.getText() + "\n" +
                "Contact Email: " + contactEmailField.getText() + "\n" +
                "Contact Number: " + contactNumberField.getText() + "\n" +
                "Initial Deposit: " + initialDepositField.getText() + "\n" +
                "Account Number: " + accNumberField.getText();
    }
    
  

    
   public class intialDept {
	   
	  public double intdept = Double.parseDouble(initialDepositField.getText());
	  public double bal = intdept;
    	
    }
   public class pinCode {
	   
		  public String pin = pinCodeField.getText();
		 
	    	
	    }

   public class firstName {
	   
		  public String name = firstNameField.getText();
		 
	    	
	    }
}
