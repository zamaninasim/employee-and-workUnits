package ir.maktab.model;

import java.sql.Date;

public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private int personalID;
    private Date dateOfBirth;
    private WorkUnit workUnit;

    public Employee() {
    }

    public Employee(String firstName, String lastName, int personalID, Date dateOfBirth, WorkUnit workUnit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalID = personalID;
        this.dateOfBirth = dateOfBirth;
        this.workUnit = workUnit;
    }

    public Employee(int employeeID, String firstName, String lastName, int personalID, Date dateOfBirth) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalID = personalID;
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getPersonalID() {
        return personalID;
    }

    public void setPersonalID(int personalID) {
        this.personalID = personalID;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public WorkUnit getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(WorkUnit workUnit) {
        this.workUnit = workUnit;
    }

    public int getEmployeeID() {
        return employeeID;
    }
}
