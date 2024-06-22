package bankingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JFrame implements ActionListener {
    private JPanel homePanel;
    private JLabel balanceLabel;
    private JLabel accountNumberLabel;
    private JButton accountInfoButton;
    private JButton depositButton;
    private JButton withdrawalButton;
    private JButton logoutButton;
    private JDialog pinDialog;
    private JTextField pinField;

    private String username;
    private static double balance;
    private static long AccountNumber = 2024100000;
    private String pin;
    private double initialDeposit;
    private AccountInfo accountInfo; // Instance of AccountInfo

    public HomePanel(String username, double balance, String accountNumber, String pin, AccountInfo accountInfo) {
        this.username = username;
        this.balance = balance;
        if (accountNumber != null && !accountNumber.isEmpty()) {
            AccountNumber = Long.parseLong(accountNumber);
        }
        this.pin = pin;
        this.accountInfo = accountInfo;
        this.initialDeposit = accountInfo.getInitialDeposit(); // Fetch initial deposit from AccountInfo
        GUI();
    }

    private void GUI() {
        setTitle("Federal Reserve Bank of the World");
        setSize(1350, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());

        // Log out button
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        logoutButton = new JButton("Log out");
        logoutButton.addActionListener(this);
        topPanel.add(logoutButton);
        homePanel.add(topPanel, BorderLayout.NORTH);

        // Center panel with user info
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 30));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(100)); // vertical space
        centerPanel.add(welcomeLabel);

        balanceLabel = new JLabel("Current Balance:");
        balanceLabel.setFont(new Font("Serif", Font.BOLD, 20));
        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(20)); // vertical space
        centerPanel.add(balanceLabel);

        JLabel balanceValueLabel = new JLabel("₱ " + String.format("%.2f", balance + initialDeposit)); // Update balance computation as needed
        balanceValueLabel.setFont(new Font("Serif", Font.BOLD, 50));
        balanceValueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(20)); // vertical space
        centerPanel.add(balanceValueLabel);

        long accountNumber = AccountNumber;
        AccountNumber++;
        accountNumberLabel = new JLabel("Account Number: " + AccountNumber);
        accountNumberLabel.setFont(new Font("Serif", Font.BOLD, 20));
        accountNumberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(20)); // vertical space
        centerPanel.add(accountNumberLabel);

        // Button panels
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

        accountInfoButton = new JButton("Account Information");
        accountInfoButton.addActionListener(this);
        buttonPanel.add(accountInfoButton);

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);
        buttonPanel.add(depositButton);

        withdrawalButton = new JButton("Withdraw");
        withdrawalButton.addActionListener(this);
        buttonPanel.add(withdrawalButton);

        centerPanel.add(Box.createVerticalStrut(50)); // vertical space
        centerPanel.add(buttonPanel);

        homePanel.add(centerPanel, BorderLayout.CENTER);

        add(homePanel);
        setVisible(true);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            dispose();
            System.exit(0);
        } else if (e.getSource() == accountInfoButton || e.getSource() == depositButton || e.getSource() == withdrawalButton) {
            createPinDialog(e.getSource());
        }
    }

    private void createPinDialog(Object object) {
        pinDialog = new JDialog(this, "Enter PIN", true);
        pinDialog.setSize(200, 150);

        JPanel pinPanel = new JPanel();
        pinPanel.setLayout(new BorderLayout());

        JLabel pinLabel = new JLabel("Enter your 6-digit PIN:");
        pinPanel.add(pinLabel, BorderLayout.NORTH);

        pinField = new JTextField(10);
        pinPanel.add(pinField, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredPin = pinField.getText();
                try {
                    if (validatePin(enteredPin)) {
                        pinDialog.dispose();
                        if (object == depositButton) {
                            new Deposit(initialDeposit, HomePanel.this); // Pass HomePanel instance
                        } else if (object == withdrawalButton) {
                            // Implement withdrawal functionality
                            JOptionPane.showMessageDialog(null, "Withdrawal functionality not implemented.", "Notice", JOptionPane.INFORMATION_MESSAGE);
                        } else if (object == accountInfoButton) {
                            displayAccountInformation();
                        }
                    } else {
                        JOptionPane.showMessageDialog(pinDialog, "Invalid PIN");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(pinDialog, "PIN must be a 6-digit number");
                }
            }
        });
        pinPanel.add(okButton, BorderLayout.SOUTH);

        pinDialog.add(pinPanel);
        pinDialog.setVisible(true);
    }

    private boolean validatePin(String pin) {
        if (pin.length() != 6) {
            throw new NumberFormatException();
        }
        return pin.equals(this.pin);
    }

    private void displayAccountInformation() {
        String accountDetails = accountInfo.getAccountDetails(); // Assuming AccountInfo has a method to fetch account details
        JOptionPane.showMessageDialog(this, accountDetails, "Account Information", JOptionPane.INFORMATION_MESSAGE);
    }

    // For testing purposes
    public static void main(String[] args) {
        // Example usage:
        AccountInfo accountInfo = new AccountInfo(); // Instantiate AccountInfo
        new HomePanel("Jasmine", 0, "2024100000", "123456", accountInfo);
    }
}