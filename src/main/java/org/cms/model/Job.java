package org.cms.model;

public class Job {

	 private int id;
	    private String title;
	    private String companyName;
	    private String jobDescription;
	    private String location;
	    private String datePosted;

	    // Default constructor
	    public Job() {}

	    // Constructor with parameters
	    public Job(int id, String title, String companyName, String jobDescription, String location, String datePosted) {
	        this.id = id;
	        this.title = title;
	        this.companyName = companyName;
	        this.jobDescription = jobDescription;
	        this.location = location;
	        this.datePosted = datePosted;
	    }

	    // Getters and setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getCompanyName() {
	        return companyName;
	    }

	    public void setCompanyName(String companyName) {
	        this.companyName = companyName;
	    }

	    public String getJobDescription() {
	        return jobDescription;
	    }

	    public void setJobDescription(String jobDescription) {
	        this.jobDescription = jobDescription;
	    }

	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }

	    public String getDatePosted() {
	        return datePosted;
	    }

	    public void setDatePosted(String datePosted) {
	        this.datePosted = datePosted;
	    }
}
