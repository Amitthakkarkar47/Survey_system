package com.project.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SurveyManager {
    private List<Survey> surveys;
    private Map<User, UserRole> userRoles;

    public SurveyManager() {
        this.surveys = new ArrayList<>();
        this.userRoles = new HashMap<>();
    }

    // Methods for survey creation, distribution, and response collection

    public void createSurvey(User creator, Survey survey) {
        if (userRoles.get(creator) == UserRole.SURVEY_CREATOR) {
            surveys.add(survey);
            System.out.println("Survey created successfully by " + creator.getUsername());
        } else {
            System.out.println("Insufficient permissions to create a survey.");
        }
    }

    public void distributeSurvey(User sender, User recipient, Survey survey) {
        if (userRoles.get(sender) == UserRole.SURVEY_CREATOR && userRoles.get(recipient) == UserRole.RESPONDENT) {
            // Implement survey distribution logic (e.g., send an email invitation)
            System.out.println("Survey sent to " + recipient.getUsername() + " by " + sender.getUsername());
        } else {
            System.out.println("Insufficient permissions to distribute the survey.");
        }
    }

    public void collectResponse(User respondent, Survey survey, Map<Question, String> responses) {
        if (userRoles.get(respondent) == UserRole.RESPONDENT && surveys.contains(survey)) {
            // Validate and store responses in the database or survey object
            System.out.println("Response collected from " + respondent.getUsername());
        } else {
            System.out.println("Invalid respondent or survey for response collection.");
        }
    }

    // Other methods for managing surveys and users

    public void assignUserRole(User user, UserRole role) {
        // Assign a role to a user (e.g., Admin, Survey Creator, Respondent)
        userRoles.put(user, role);
        System.out.println(user.getUsername() + " assigned the role of " + role);
    }

    public void viewSurveyResults(User user, Survey survey) {
        if (userRoles.get(user) == UserRole.ADMIN || userRoles.get(user) == UserRole.SURVEY_CREATOR) {
            // Display survey results or generate a report
            System.out.println("Viewing survey results for " + survey.getTitle());
        } else {
            System.out.println("Insufficient permissions to view survey results.");
        }
    }
}

