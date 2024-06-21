package Java;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class depositPanel extends JFrame implements ActionListener{
	
	public double balance=500;
	public double deposit;
	public String jOption;
	JButton depositButton; 
	JButton exitButton;
	JLabel balanceLabel;
	JLabel label;
	JLabel depositLabel;
	JPanel centerPanel;
	JPanel DepositPanel;
	JTextField textField;
	
	depositPanel(){
		
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
		textField.setPreferredSize(new Dimension(250,40));
		textField.setBounds(650, 366, 200, 25);
		DepositPanel.add(textField);
		
		depositButton = new JButton("Deposit Amount");
		depositButton.setFont(new Font("Calibri", Font.BOLD,16));
		depositButton.addActionListener(this);
		depositButton.setFocusable(false);
		depositButton.setBounds(450, 500, 150, 40);
		DepositPanel.add(depositButton);
		
		exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Calibri", Font.BOLD,16));
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
				deposit = Double.parseDouble(textField.getText());
				balance += deposit;
				JOptionPane.showMessageDialog(null, "Amount Deposited!", "Notice", JOptionPane.INFORMATION_MESSAGE);
				textField.setText("");
				balanceLabel.setText("₱ " + String.format("%.2f", balance)); // Update the balanceLabel
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == exitButton) {
			// return to home page (idk pa pano babalik cuz d pa naka compile)
		}
	}

	public static void main(String[] args) {
		new depositPanel();
	}
}



