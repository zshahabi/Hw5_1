package ir.maktab.model;

import java.sql.Date;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String employeeLastName;
    private int personalNumber;
    private Date birthDate;
    private Worksite worksite;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String employeeLastName, int personalNumber, Date birthDate, Worksite worksite) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeLastName = employeeLastName;
        this.personalNumber = personalNumber;
        this.birthDate = birthDate;
        this.worksite = worksite;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Worksite getWorksite() {
        return worksite;
    }

    public void setWorksite(Worksite worksite) {
        this.worksite = worksite;
    }
}
