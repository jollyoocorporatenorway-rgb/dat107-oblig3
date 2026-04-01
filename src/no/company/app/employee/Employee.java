package no.company.app.employee;

public class Employee {
    private long employeeID;
    private String username;
    private String firstName;
    private String lastName;
    private String position;
    private double salary;
    private int divisionID;

    public Employee(long employeeID, String username, String firstName, String lastName,
                    String position, double salary, int divisionID) {
        this.employeeID = employeeID;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
        this.divisionID = divisionID;
    }

    @Override
    public String toString() {
        return employeeID + " - " + firstName + " " + lastName + " (" + position + ")";
    }
}