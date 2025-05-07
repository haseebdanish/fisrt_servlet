package org.cms.model;

public class Application {
	private int id;
    private String username;
    private String jobTitle;
    private String companyName;
    private String status;
    private String dateApplied;

    // Default constructor
    public Application() {}

    // Constructor with parameters
    public Application(int id, String username, String jobTitle, String companyName, String status, String dateApplied) {
        this.id = id;
        this.username = username;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.status = status;
        this.dateApplied = dateApplied;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(String dateApplied) {
        this.dateApplied = dateApplied;
    }
}
