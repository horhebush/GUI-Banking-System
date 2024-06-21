package GUIBank;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    private double balance;
    private static long AccountNumber = 2024100000;
    private String pin;

    public HomePanel(String username, double balance, String accountNumber, String pin) {
        this.username = username;
        this.balance = balance;
        AccountNumber = Long.parseLong(accountNumber);
        this.pin = pin;
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

        JLabel balanceLabel = new JLabel("₱ " + String.format("%.2f", balance));
        balanceLabel.setFont(new Font("Serif", Font.BOLD, 50));
        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(20)); // vertical space
        centerPanel.add(balanceLabel);

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

        JLabel pinLabel = new JLabel("Enter your 4-digit PIN:");
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
                            DepositPanel();
                        } else if (object == withdrawalButton) {
                            WithdrawPanel();
                        } else if (object == accountInfoButton) {
                            AccountInfo();
                        }
                    } else {
                        JOptionPane.showMessageDialog(pinDialog, "Invalid PIN");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(pinDialog, "PIN must be a 4-digit number");
                }
            }
        });
        pinPanel.add(okButton, BorderLayout.SOUTH);

        pinDialog.add(pinPanel);
        pinDialog.setVisible(true);
    }

    private boolean validatePin(String pin) {
        if (pin.length() != 4) {
            throw new NumberFormatException();
        }
        return pin.equals(this.pin);
    }

    private void DepositPanel() {
        // for Deposit Panel
       
    }

    private void WithdrawPanel() {
        // for Withdraw panel
      
    }

    private void displayAccountInformation() {
        new AccountInformation ();
        
    }

    // for testing purposes
    public static void main(String[] args) {
        new HomePanel("Jasmine", 500.00, "2024100000", "1234"); 
    }
}