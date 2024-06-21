package BankingSystem;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccountInformation {
	private JFrame frame;
    private JPanel panel;

    private JLabel userNameLabel;
    private JLabel passWordLabel;
    private JLabel pinCodeLabel;
    private JLabel firstNameLabel;
    private JLabel middleNameLabel;
    private JLabel lastNameLabel;
    private JLabel birthDateLabel;
    private JLabel genderLabel;
    private JLabel addressLabel;
    private JLabel fatherNameLabel;
    private JLabel motherNameLabel;
    private JLabel contactEmailLabel;
    private JLabel contactNumberLabel;
    private JLabel initialDepositLabel;

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

    public AccountInformation() {
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

        userNameLabel = createLabel("User Name:", 50, 30, labelWidth, 30, labelFont);
        passWordLabel = createLabel("Password:", 50, 70, labelWidth, 30, labelFont);
        pinCodeLabel = createLabel("Pin:", 50, 110, labelWidth, 30, labelFont);
        firstNameLabel = createLabel("First Name:", 50, 150, labelWidth, 30, labelFont);
        middleNameLabel = createLabel("Middle Name:", 50, 190, labelWidth, 30, labelFont);
        lastNameLabel = createLabel("Last Name:", 50, 230, labelWidth, 30, labelFont);
        birthDateLabel = createLabel("Birth Date:", 50, 270, labelWidth, 30, labelFont);
        genderLabel = createLabel("Gender:", 50, 310, labelWidth, 30, labelFont);
        addressLabel = createLabel("Address:", 50, 350, labelWidth, 30, labelFont);
        fatherNameLabel = createLabel("Father's Name:", 50, 390, labelWidth, 30, labelFont);
        motherNameLabel = createLabel("Mother's Name:", 50, 430, labelWidth, 30, labelFont);
        contactEmailLabel = createLabel("Contact Email:", 50, 470, labelWidth, 30, labelFont);
        contactNumberLabel = createLabel("Contact Number:", 50, 510, labelWidth, 30, labelFont);
        initialDepositLabel = createLabel("Initial Deposit:", 50, 550, labelWidth, 30, labelFont);

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

	JButton exitButton = new JButton("Exit");
        exitButton.setBounds(1150, 700, 100, 30);
        exitButton.addActionListener(e -> frame.dispose());
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

        frame.setVisible(true);
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
        try (BufferedReader reader = new BufferedReader(new FileReader("user_details4.txt"))) {
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
                        initialDepositField.setText(line);
                        break;
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AccountInformation());
    }
}
        
