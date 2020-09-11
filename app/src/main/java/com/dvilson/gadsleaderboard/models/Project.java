package com.dvilson.gadsleaderboard.models;

public class Project {

    private String firstName ;
    private String lastName;
    private String emailAddress;
    private String projectLink ;

    public Project(String name, String lastName, String emailAddress, String projectLink) {
        this.firstName = name;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.projectLink = projectLink;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLink() {
        return projectLink;
    }

    public void setLink(String link) {
        this.projectLink = link;
    }
}
