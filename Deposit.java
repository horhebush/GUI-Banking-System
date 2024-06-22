package bankingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposit extends JFrame implements ActionListener {
    private double balance;
    private JButton depositButton;
    private JButton exitButton;
    private JLabel balanceLabel;
    private JLabel label;
    private JLabel depositLabel;
    private JPanel DepositPanel;
    private JTextField textField;
    private HomePanel homePanel;

    Deposit(double initialDeposit, HomePanel homePanel) {
        this.homePanel = homePanel;
        this.balance += initialDeposit; // Add initial deposit to balance
        deposit();
    }

    public void deposit() {
        DepositPanel = new JPanel();
        DepositPanel.setBounds(0, 0, 1350, 800);
        DepositPanel.setLayout(null);

        label = new JLabel("Current Balance:");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        label.setBounds(525, 150, 250, 50);
        DepositPanel.add(label);

        balanceLabel = new JLabel("₱ " + String.format("%.2f", balance));
        balanceLabel.setFont(new Font("Serif", Font.BOLD, 60));
        balanceLabel.setBounds(525, 210, 300, 70);
        DepositPanel.add(balanceLabel);

        depositLabel = new JLabel("Enter Amount to deposit:");
        depositLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        depositLabel.setBounds(425, 350, 350, 50);
        DepositPanel.add(depositLabel);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setBounds(650, 366, 200, 25);
        DepositPanel.add(textField);

        depositButton = new JButton("Deposit Amount");
        depositButton.setFont(new Font("Calibri", Font.BOLD, 16));
        depositButton.addActionListener(this);
        depositButton.setFocusable(false);
        depositButton.setBounds(450, 500, 150, 40);
        DepositPanel.add(depositButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Calibri", Font.BOLD, 16));
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        exitButton.setBounds(675, 500, 150, 40);
        DepositPanel.add(exitButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1350, 800);
        this.setVisible(true);
        this.add(DepositPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            try {
                double deposit = Double.parseDouble(textField.getText());
                balance += deposit;
                JOptionPane.showMessageDialog(null, "Amount Deposited!", "Notice", JOptionPane.INFORMATION_MESSAGE);
                textField.setText("");
                balanceLabel.setText("₱ " + String.format("%.2f", balance)); // Update the balanceLabel
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                textField.setText("");
            }
        } else if (e.getSource() == exitButton) {
            setVisible(false);
            homePanel.setVisible(true); // Show the HomePanel again
        }
    }

    public static void main(String[] args) {
        // Instantiate AccountInfo to get initial deposit
        AccountInfo accountInfo = new AccountInfo();
        
        // Example usage with initial deposit of 5000.0
        new Deposit(5000.0, null); // Pass null because we are not using HomePanel instance in main method
    }
}
