package no.company.app.department;

public class Department {
    private int departmentID;
    private String departmentName;
    private long managerID;

    public Department(int departmentID, String departmentName, long managerID) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.managerID = managerID;
    }
}