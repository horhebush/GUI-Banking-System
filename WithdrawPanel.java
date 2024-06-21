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

public class withdrawPanel extends JFrame implements ActionListener {
	public double balance=500;
	public double withdraw;
	public String jOption;
	JButton withdrawButton; 
	JButton exitButton;
	JLabel balanceLabel;
	JLabel label;
	JLabel withdrawLabel;
	JPanel centerPanel;
	JPanel withdrawPanel;
	JTextField textField;
	
	withdrawPanel(){
		
				withdraw();
}

	public void withdraw() {
		
		withdrawPanel = new JPanel();
 		withdrawPanel.setBounds(0, 0, 1350, 800);
		withdrawPanel.setLayout(null);
		   
		label = new JLabel("Current Balance:");
		label.setFont(new Font("Serif", Font.BOLD, 30));
        label.setBounds(525, 150, 250, 50);
        withdrawPanel.add(label);

        balanceLabel = new JLabel("₱ " + String.format("%.2f", balance));
		balanceLabel.setFont(new Font("Serif", Font.BOLD, 60));
		balanceLabel.setBounds(525, 210, 300, 70);
        withdrawPanel.add(balanceLabel);
        
        withdrawLabel = new JLabel("Enter Amount to Withdraw:");
		withdrawLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		withdrawLabel.setBounds(425, 350, 350, 50);
		withdrawPanel.add(withdrawLabel);
        
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(250,40));
		textField.setBounds(650, 366, 200, 25);
		withdrawPanel.add(textField);
		
		withdrawButton = new JButton();
		withdrawButton.setText("Withdraw Amount");
		withdrawButton.setFont(new Font("Calibri", Font.BOLD,16));
		withdrawButton.addActionListener(this);
		withdrawButton.setFocusable(false);
		withdrawButton.setBounds(450, 500, 150, 40);
		withdrawPanel.add(withdrawButton);
		
		exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Calibri", Font.BOLD,16));
		exitButton.addActionListener(this);
		exitButton.setFocusable(false);
		exitButton.setBounds(675, 500, 150, 40);
		withdrawPanel.add(exitButton);
		
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setLayout(null);
        this.setSize(1350, 800); 
        this.setVisible(true); 				
		this.add(withdrawPanel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == withdrawButton) {
			try {
				withdraw = Double.parseDouble(textField.getText());
				if(balance>withdraw) {
					balance -= withdraw;
					JOptionPane.showMessageDialog(null, "Amount Withdrawed!", "Notice", JOptionPane.INFORMATION_MESSAGE);
					textField.setText("");
					balanceLabel.setText("₱ " + String.format("%.2f", balance));  // Update the balanceLabel
				}
				else if(balance<withdraw) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance!", "Notice", JOptionPane.INFORMATION_MESSAGE);
					textField.setText("");
				}
				
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
			}
		} else if (e.getSource() == exitButton) {
			// return to home page (idk pa pano babalik cuz d pa naka compile)
		}
	}

	public static void main(String[] args) {
		new withdrawPanel();
	}
}


	
	
