package com.project.ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SurveyCreationUI extends JFrame {
    private JTextField titleField;
    private JTextArea questionArea;
    private JButton addQuestionButton;
    private JButton saveSurveyButton;

    public SurveyCreationUI() {
        setTitle("Survey Creation");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel(new FlowLayout());
        JLabel titleLabel = new JLabel("Survey Title:");
        titleField = new JTextField(20);
        titlePanel.add(titleLabel);
        titlePanel.add(titleField);

        // Question Panel
        JPanel questionPanel = new JPanel(new BorderLayout());
        JLabel questionLabel = new JLabel("Survey Questions:");
        questionArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(questionArea);
        questionPanel.add(questionLabel, BorderLayout.NORTH);
        questionPanel.add(scrollPane, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        addQuestionButton = new JButton("Add Question");
        saveSurveyButton = new JButton("Save Survey");
        buttonPanel.add(addQuestionButton);
        buttonPanel.add(saveSurveyButton);

        // Add components to the main panel
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(questionPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        addQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to add a question
                String questionText = JOptionPane.showInputDialog("Enter a question:");
                if (questionText != null && !questionText.trim().isEmpty()) {
                    questionArea.append(questionText + "\n");
                }
            }
        });

        saveSurveyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to save the survey to the database
                String surveyTitle = titleField.getText();
                String surveyQuestions = questionArea.getText();

                // Placeholder logic to demonstrate saving the survey details
                JOptionPane.showMessageDialog(SurveyCreationUI.this,
                        "Survey saved:\nTitle: " + surveyTitle + "\nQuestions:\n" + surveyQuestions,
                        "Survey Saved", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Set the main panel as the content pane of the frame
        setContentPane(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SurveyCreationUI();
            }
        });
    }
}
