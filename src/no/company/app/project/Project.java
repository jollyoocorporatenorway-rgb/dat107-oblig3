package no.company.app.project;

public class Project {
    private int projectID;
    private String projectName;
    private String description;

    public Project(int projectID, String projectName, String description) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.description = description;
    }
}