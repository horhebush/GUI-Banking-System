package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HomePanel extends JFrame implements ActionListener {
    private JPanel homePanel, depositPanel, withdrawPanel, accountInfoPanel;
    private JLabel balanceLabel, accountNumberLabel, balanceValueLabel, depositBalanceLabel, withdrawBalanceLabel;
    private JButton accountInfoButton, depositButton, withdrawalButton, logoutButton, depositActionButton, withdrawActionButton, exitButton;
    private JTextField depositTextField, withdrawTextField;
    private JTextField[] accountInfoFields;
    private JDialog PinDialog;
    private JTextField pinField;
    private double balance;
    private static long AccountNumber = 2024100000;
    private String username, pin;

    public void parameters(String username, double balance, String accountNumber, String pin) {
    	this.username = username;
        this.balance = balance;
        if (accountNumber != null && !accountNumber.isEmpty()) {
            AccountNumber = Long.parseLong(accountNumber);
        }
        this.pin = pin;
        initializeUI();
        loadUserInfo();
    }

    public HomePanel() {
       parameters(pin, balance, pin, "123456");
    }
    private void initializeUI() {
        setTitle("Federal Reserve Bank of the World");
        setSize(1350, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new CardLayout());

        // Home Panel
        homePanel = new JPanel(new BorderLayout());

        // Log out button
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        logoutButton = new JButton("Log out");
        logoutButton.setActionCommand("Logout");
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

        balanceValueLabel = new JLabel("₱ " + String.format("%.2f", balance));
        balanceValueLabel.setFont(new Font("Serif", Font.BOLD, 50));
        balanceValueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(20)); // vertical space
        centerPanel.add(balanceValueLabel);

        accountNumberLabel = new JLabel("Account Number: " + AccountNumber);
        accountNumberLabel.setFont(new Font("Serif", Font.BOLD, 20));
        accountNumberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(20)); // vertical space
        centerPanel.add(accountNumberLabel);

        // Button panels
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));

        accountInfoButton = new JButton("Account Information");
        accountInfoButton.setActionCommand("AccountInfo");
        accountInfoButton.addActionListener(this);
        buttonPanel.add(accountInfoButton);

        depositButton = new JButton("Deposit");
        depositButton.setActionCommand("Deposit");
        depositButton.addActionListener(this);
        buttonPanel.add(depositButton);

        withdrawalButton = new JButton("Withdraw");
        withdrawalButton.setActionCommand("Withdraw");
        withdrawalButton.addActionListener(this);
        buttonPanel.add(withdrawalButton);

        centerPanel.add(Box.createVerticalStrut(50)); // vertical space
        centerPanel.add(buttonPanel);

        homePanel.add(centerPanel, BorderLayout.CENTER);

        // Adding all panels to the main frame
        add(homePanel, "Home");

        createDepositPanel();
        createWithdrawPanel();


        setVisible(true);
        setResizable(false);
    }

    private void createDepositPanel() {
        depositPanel = new JPanel();
        depositPanel.setLayout(null);

        JLabel label = new JLabel("Current Balance:");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        label.setBounds(525, 150, 250, 50);
        depositPanel.add(label);

        depositBalanceLabel = new JLabel("₱ " + String.format("%.2f", balance));
        depositBalanceLabel.setFont(new Font("Serif", Font.BOLD, 60));
        depositBalanceLabel.setBounds(525, 210, 300, 70);
        depositPanel.add(depositBalanceLabel);

        JLabel depositLabel = new JLabel("Enter Amount to Deposit:");
        depositLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        depositLabel.setBounds(425, 350, 350, 50);
        depositPanel.add(depositLabel);

        depositTextField = new JTextField();
        depositTextField.setPreferredSize(new Dimension(250, 40));
        depositTextField.setBounds(650, 366, 200, 25);
        depositPanel.add(depositTextField);

        depositActionButton = new JButton("Deposit Amount");
        depositActionButton.setFont(new Font("Calibri", Font.BOLD, 16));
        depositActionButton.setActionCommand("PerformDeposit");
        depositActionButton.addActionListener(this);
        depositActionButton.setFocusable(false);
        depositActionButton.setBounds(450, 500, 150, 40);
        depositPanel.add(depositActionButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Calibri", Font.BOLD, 16));
        exitButton.setActionCommand("ExitToHomeFromDeposit");
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        exitButton.setBounds(675, 500, 150, 40);
        depositPanel.add(exitButton);

        add(depositPanel, "Deposit");
    }

    private void createWithdrawPanel() {
        withdrawPanel = new JPanel();
        withdrawPanel.setLayout(null);

        JLabel label = new JLabel("Current Balance:");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        label.setBounds(525, 150, 250, 50);
        withdrawPanel.add(label);

        withdrawBalanceLabel = new JLabel("₱ " + String.format("%.2f", balance));
        withdrawBalanceLabel.setFont(new Font("Serif", Font.BOLD, 60));
        withdrawBalanceLabel.setBounds(525, 210, 300, 70);
        withdrawPanel.add(withdrawBalanceLabel);

        JLabel withdrawLabel = new JLabel("Enter Amount to Withdraw:");
        withdrawLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        withdrawLabel.setBounds(425, 350, 350, 50);
        withdrawPanel.add(withdrawLabel);

        withdrawTextField = new JTextField();
        withdrawTextField.setPreferredSize(new Dimension(250, 40));
        withdrawTextField.setBounds(650, 366, 200, 25);
        withdrawPanel.add(withdrawTextField);

        withdrawActionButton = new JButton("Withdraw");
        withdrawActionButton.setFont(new Font("Calibri", Font.BOLD, 16));
        withdrawActionButton.setActionCommand("PerformWithdraw");
        withdrawActionButton.addActionListener(this);
        withdrawActionButton.setFocusable(false);
        withdrawActionButton.setBounds(450, 500, 150, 40);
        withdrawPanel.add(withdrawActionButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Calibri", Font.BOLD, 16));
        exitButton.setActionCommand("ExitToHomeFromWithdraw");
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        exitButton.setBounds(675, 500, 150, 40);
        withdrawPanel.add(exitButton);

        add(withdrawPanel, "Withdraw");
    }

    private void createAccountInfoPanel() {
    	dispose();
    	new AccountInfo();   
    }

    private void loadUserInfo() {
        File file = new File("C:\\Users\\Jamaine\\eclipse-workspace\\IntermediateProg\\user_details.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null && index < accountInfoFields.length) {
                accountInfoFields[index].setText(line);
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void createPinDialog(Object source) {
        JDialog pinDialog = new JDialog(this, "Enter PIN", true);
        pinDialog.setSize(300, 150);
        pinDialog.setLocationRelativeTo(this);

        JPanel pinPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel pinLabel = new JLabel("Enter your 6-digit PIN:");
        pinPanel.add(pinLabel);

        JPasswordField pinField = new JPasswordField(6);
        pinPanel.add(pinField);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] enteredPinChars = pinField.getPassword();
                String enteredPin = new String(enteredPinChars);
                if (validatePin(enteredPin)) {
                    pinDialog.dispose();
                    handleAction(source);
                } else {
                    JOptionPane.showMessageDialog(pinDialog, "Invalid PIN. Try again.");
                    pinField.setText("");
                }
            }
        });
        pinPanel.add(okButton);

        pinDialog.add(pinPanel);
        pinDialog.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "AccountInfo":
            case "Deposit":
            case "Withdraw":
                createPinDialog(e.getSource()); // Pass the button source to identify action
                break;
            case "Logout":
                dispose();
                JFrame WelcomePage = new WelcomePage();
                WelcomePage.setVisible(true);
                break;
            case "PerformDeposit":
                handleDeposit();
                break;
            case "PerformWithdraw":
                handleWithdraw();
                break;
            case "ExitToHomeFromDeposit":
            case "ExitToHomeFromWithdraw":
            case "ExitToHomeFromAccountInfo":
                cl.show(getContentPane(), "Home");
                break;
            default:
                break;
        }
    }

    private boolean validatePin(String enteredPin) {
        return enteredPin.equals(pin); // Compare entered PIN with stored PIN
    }

    private void handleAction(Object source) {
        String actionCommand = ((JButton) source).getActionCommand();
        CardLayout cl = (CardLayout) getContentPane().getLayout();

        switch (actionCommand) {
            case "AccountInfo":
                cl.show(getContentPane(), "AccountInfo");
                createAccountInfoPanel();
                break;
            case "Deposit":
                cl.show(getContentPane(), "Deposit");
                break;
            case "Withdraw":
                cl.show(getContentPane(), "Withdraw");
                break;
            default:
                break;
        }
    }


    private void handleDeposit() {
        try {
            double depositAmount = Double.parseDouble(depositTextField.getText());
            if (depositAmount <= 0) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
                return;
            }
            balance += depositAmount;
            balanceValueLabel.setText("₱ " + String.format("%.2f", balance));
            depositBalanceLabel.setText("₱ " + String.format("%.2f", balance));
            depositTextField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleWithdraw() {
        try {
            double withdrawAmount = Double.parseDouble(withdrawTextField.getText());
            if (withdrawAmount <= 0 || withdrawAmount > balance) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
                return;
            }
            balance -= withdrawAmount;
            balanceValueLabel.setText("₱ " + String.format("%.2f", balance));
            withdrawBalanceLabel.setText("₱ " + String.format("%.2f", balance));
            withdrawTextField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new HomePanel();
    }
}
