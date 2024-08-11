package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class LoginFrame extends JFrame {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passwordField.getPassword());

                if (USERNAME.equals(username) && PASSWORD.equals(password)) {
                    dispose();
                    try {
                        new Main();
                    } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
