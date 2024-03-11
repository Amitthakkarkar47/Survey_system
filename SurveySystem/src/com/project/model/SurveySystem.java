package com.project.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class SurveySystem extends JFrame {
    private List<String> surveyQuestions = new ArrayList<>();
    private List<String> surveyResponses = new ArrayList<>();

    public SurveySystem() {
        setTitle("Survey System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createSurveyPanel();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createSurveyPanel() {
        JPanel surveyPanel = new JPanel();
        surveyPanel.setLayout(new GridLayout(0, 1));

        JLabel titleLabel = new JLabel("Survey Creation");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        surveyPanel.add(titleLabel);

        JButton addQuestionButton = new JButton("Add Question");
        addQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String question = JOptionPane.showInputDialog("Enter the survey question:");
                if (question != null && !question.trim().isEmpty()) {
                    surveyQuestions.add(question);
                }
            }
        });
        surveyPanel.add(addQuestionButton);

        JButton collectResponsesButton = new JButton("Collect Responses");
        collectResponsesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectResponses();
            }
        });
        surveyPanel.add(collectResponsesButton);

        add(surveyPanel);
    }

    private void collectResponses() {
        for (String question : surveyQuestions) {
            String response = JOptionPane.showInputDialog("Question: " + question);
            if (response != null) {
                surveyResponses.add(response);
            }
        }

        displayResponses();
    }

    private void displayResponses() {
        StringBuilder responseMessage = new StringBuilder("Survey Responses:\n");

        for (int i = 0; i < surveyQuestions.size(); i++) {
            responseMessage.append(surveyQuestions.get(i)).append(": ").append(surveyResponses.get(i)).append("\n");
        }

        JOptionPane.showMessageDialog(this, responseMessage.toString(), "Survey Responses", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SurveySystem();
            }
        });
    }
}

