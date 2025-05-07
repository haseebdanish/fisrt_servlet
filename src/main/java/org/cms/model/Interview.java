package org.cms.model;

public class Interview {

	private int id;
    private String username;
    private String companyName;
    private String interviewDate;
    private String location;

    // Default constructor
    public Interview() {}

    // Constructor with parameters
    public Interview(int id, String username, String companyName, String interviewDate, String location) {
        this.id = id;
        this.username = username;
        this.companyName = companyName;
        this.interviewDate = interviewDate;
        this.location = location;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
