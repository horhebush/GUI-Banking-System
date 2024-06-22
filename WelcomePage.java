package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class WelcomePage extends JFrame {
    private MusicPlayer player;
    private Font orbitronFont;

    public WelcomePage() {
        setTitle("Federal Reserve Bank of the World");
        setSize(1350, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loadFont();

        GradientPanel contentPane = new GradientPanel();
        contentPane.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setOpaque(false);

        JLabel titleLabel = new JLabel("<html><div style='text-align: center;'>Federal Reserve Bank<br>of the World</div></html>");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(orbitronFont.deriveFont(Font.BOLD, 60f));

        titlePanel.add(titleLabel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 30));
        buttonPanel.setOpaque(false);

        JButton signInButton = createStyledButton("Sign In", 200, 60);
        JButton signUpButton = createStyledButton("Sign Up", 200, 60);

        buttonPanel.add(signInButton);
        buttonPanel.add(signUpButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 50, 50));
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        contentPane.add(titlePanel, BorderLayout.CENTER);
        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadFont() {
        try {
            File fontFile = new File("Orbitron-VariableFont_wght.ttf");
            orbitronFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(orbitronFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            orbitronFont = new Font("Arial", Font.PLAIN, 30);
        }
    }

    private JButton createStyledButton(String text, int width, int height) {
        JButton button = new JButton(text);
        button.setFont(orbitronFont.deriveFont(Font.BOLD, 24f));
        button.setPreferredSize(new Dimension(width, height));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

        button.setOpaque(true);
        button.setBackground(new Color(30, 30, 30, 200));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(100, 100, 100, 200));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(30, 30, 30, 200));
            }
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (text.equals("Sign In")) {
                    LogIn loginFrame = new LogIn();
                    setVisible(false);
                    loginFrame.setVisible(true); // Display the login frame
                } else if (text.equals("Sign Up")) {
                	setVisible(false);
                    new SignUpGUI(player);
                }
            }
        });

        return button;
    }

    class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int width = getWidth();
            int height = getHeight();

            Color color1 = new Color(0, 0, 20);
            Color color2 = new Color(18, 18, 50);
            GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);

            // Draw stars
            drawStars(g2d, width, height);

            g2d.dispose();
        }

        private void drawStars(Graphics2D g2d, int width, int height) {
            g2d.setColor(Color.WHITE);
            for (int i = 0; i < 100; i++) {
                int x = (int) (Math.random() * width);
                int y = (int) (Math.random() * height);
                int size = (int) (Math.random() * 2) + 1;
                g2d.fillRect(x, y, size, size);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WelcomePage();
            }
        });
    }
}
