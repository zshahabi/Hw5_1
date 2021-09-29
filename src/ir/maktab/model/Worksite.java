package ir.maktab.model;

import java.util.ArrayList;

public class Worksite {
   private int worksiteId;
   private String worksiteName;
   private String phoneNumber;
   private ArrayList<Employee>employeeArrayList=new ArrayList<>();

    public Worksite(int worksiteId, String worksiteName, String phoneNumber) {
        this.worksiteId = worksiteId;
        this.worksiteName = worksiteName;
        this.phoneNumber = phoneNumber;
    }

    public int getWorksiteId() {
        return worksiteId;
    }

    public void setWorksiteId(int worksiteId) {
        this.worksiteId = worksiteId;
    }

    public String getWorksiteName() {
        return worksiteName;
    }

    public void setWorksiteName(String worksiteName) {
        this.worksiteName = worksiteName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeArrayList = employeeArrayList;
    }
}
