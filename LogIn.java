package Java;
//for the sake of comments here in GITHUB
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LogIn extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textUsername;
    private JPasswordField textPassword;

    public LogIn() {
        setTitle("LogIn Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1350, 800);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel txtusername = new JLabel("Username:");
        txtusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtusername.setBounds(500, 219, 90, 32);
        contentPane.add(txtusername);

        JLabel txtpassword = new JLabel("Password:");
        txtpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtpassword.setBounds(503, 289, 90, 32);
        contentPane.add(txtpassword);

        textUsername = new JTextField();
        textUsername.setBounds(600, 227, 194, 20);
        contentPane.add(textUsername);
        textUsername.setColumns(10);

        textPassword = new JPasswordField();
        textPassword.setBounds(600, 297, 194, 20);
        contentPane.add(textPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textUsername.getText().trim();
                String password = new String(textPassword.getPassword()).trim();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username and Password cannot be blank");
                } else {
                    try {
                        if (validateCredentials(username, password)) {
                            // Proceed with successful login actions if needed
                        } else {
                            // Handle unsuccessful login (already handled in validateCredentials)
                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error reading user details", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnLogin.setFont(new Font("Arial Black", Font.BOLD, 11));
        btnLogin.setBounds(525, 452, 89, 23);
        contentPane.add(btnLogin);

        JLabel lblNewLabel_3 = new JLabel("Login System");
        lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 27));
        lblNewLabel_3.setBounds(530, 55, 300, 32);
        contentPane.add(lblNewLabel_3);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                JFrame WelcomPage = new WelcomePage();// Close the current window
                WelcomPage.setVisible(true);
            }
        });
        btnCancel.setBounds(675, 451, 89, 23);
        contentPane.add(btnCancel);
    }

    private boolean validateCredentials(String username, String password) throws IOException {
        int fileNumber = 1;
        boolean loggedIn = false;
        
        while (true) {
            File file = new File("user_details" + fileNumber + ".txt");
            
            if (!file.exists()) {
                break;
            }
            
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String storedUsername = reader.readLine();
                String storedPassword = reader.readLine();
                
                if (storedUsername != null && storedPassword != null) {
                    storedUsername = storedUsername.trim();
                    storedPassword = storedPassword.trim();
                    
                    if (username.equals(storedUsername) && password.equals(storedPassword)) {
                        JOptionPane.showMessageDialog(null, "Logged In Successfully!", "Notice", JOptionPane.INFORMATION_MESSAGE);
                        loggedIn = true;
                        setVisible(false);
                        JFrame HomePanel = new HomePanel(	);
                        HomePanel.setVisible(true);
                        break;  // Exit loop on successful login
                    }
                }
            }
            
            fileNumber++;
        }
        
        if (!loggedIn) {
            JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return loggedIn;
    }

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
}
