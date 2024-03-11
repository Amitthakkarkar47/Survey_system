package com.project.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginUI() {
        frame = new JFrame("Login");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement authentication logic here
                authenticateUser(usernameField.getText(), new String(passwordField.getPassword()));
            }
        });

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void authenticateUser(String username, String password) {
        // Implement user authentication logic
        // Check against a database, compare credentials, etc.
        // For simplicity, let's assume there is a predefined user
        if ("admin".equals(username) && "password".equals(password)) {
            // Authentication successful, proceed to the next screen (e.g., showSurveyCreation())
            JOptionPane.showMessageDialog(frame, "Authentication successful!");
            frame.dispose(); // Close the login window
            // Call the next screen (e.g., new SurveyCreationUI())
            new SurveyCreationUI();
        } else {
            JOptionPane.showMessageDialog(frame, "Authentication failed. Please check your credentials.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginUI());
    }
}
