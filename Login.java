package bankingGUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LogIn extends JFrame {
		
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public LogIn() {
		setTitle("LogIn Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtusername = new JLabel("Username:");
		txtusername.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtusername.setBounds(545, 219, 90, 32);
		contentPane.add(txtusername);
		
		JLabel txtpassword = new JLabel("Password:");
		txtpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpassword.setBounds(545, 289, 90, 32);
		contentPane.add(txtpassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(645, 227, 194, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(645, 297, 194, 20);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String password = textPassword.getText().trim(); 
		        String username = textUsername.getText().trim(); 
		       
		        if (password.isEmpty() || username.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Username and Password cannot be blank");
		        }
		        else if (password.equals("BankPhil") && username.equals("FedBankPH")) {
		            JOptionPane.showMessageDialog(null, "Login Success!");
		        }
		        else {
		            JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
				
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLogin.setBounds(750, 451, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(186, 296, 194, 14);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(65, 125, 1200, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(65, 421, 1200, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_3 = new JLabel("Login System");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 27));
		lblNewLabel_3.setBounds(587, 55, 211, 32);
		contentPane.add(lblNewLabel_3);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnCancel) {
                	setVisible(false);
                	new WelcomePage();
                }
            }
        });
		
		btnCancel.setBounds(617, 452, 89, 23);
		contentPane.add(btnCancel);
	}
}
