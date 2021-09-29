package ir.maktab;

import ir.maktab.access.EmployeeAccess;
import ir.maktab.model.Employee;
import ir.maktab.model.Worksite;
import jdk.nashorn.internal.runtime.Context;
import oracle.jrockit.jfr.VMJFR;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        EmployeeAccess employeeAccess=new EmployeeAccess();

      //  employeeAccess.getAllRecords();


        Scanner input= new Scanner(System.in);
        System.out.println("select action 1-Add New Employee  and Add new work unit " +
                "2-update employee 3-update worksite 4-show list for worksites " +
                "5-show list for employee");
        String inputChoice=input.next();
        int choice=Integer.parseInt(inputChoice);
        switch (choice){
            case 1:
                //getting input from user


                System.out.println("Enter employeeId");
                int employeeId = input.nextInt();
                System.out.println("Enter First name");
                String fName = input.next();
                System.out.println("Enter Last name");
                String lName = input.next();
                System.out.println("Enter personalNumber");
                int personalNumber = input.nextInt();
                System.out.println("Enter birthDate");
                int birthDay=input.nextInt();
                int birthMonth=input.nextInt();
                int birthYear=input.nextInt();
                Date birthDate= new Date(birthYear,birthMonth,birthDay);

                System.out.println("Enter worksite Id");
                int worksiteId=input.nextInt();
                System.out.println("Enter worksitName" );
                String worksiteName=input.next();
                System.out.println("Enter phoneNumber");
                String phoneNumber=input.next();

                Worksite worksite=new Worksite(worksiteId,worksiteName,phoneNumber);
                Employee employee=new Employee(employeeId,fName,lName,personalNumber,birthDate,worksite);
               employeeAccess.insertRecord(employee,worksite);

                break;
            case 2:
                System.out.println("Enter id of employee to update");
                int id=input.nextInt();
                System.out.println("Enter First name");
                String firstName=input.next();
                System.out.println("Enter Last name");
                String lastName=input.next();
               employeeAccess.updateRecord(id,firstName,lastName);

                break;
            case 3:
                System.out.println("Enter id of worksite to update");
                int idOfWorksite=input.nextInt();
                System.out.println("Enter First name");
                String nameOfWorksite=input.next();
                employeeAccess.updateWorksiteRecord(idOfWorksite,nameOfWorksite);

                break;
            case 4:
                employeeAccess.getAllRecordsEmployee();
                break;
            case 5:
                System.out.println("Enter your unitwok id");
                int unitworkId=input.nextInt();
                employeeAccess.showEmployeeByWorksite(unitworkId);
                break;
        }


       //


    }









  /*  public void insertRecord() {
        //sql statement for inserting record
        String sql = "INSERT INTO employee (employeeName,employeeLastName,personalNumber,birthDate) VALUES (?, ?,?,?)";
        //getting input from user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter First name");
        String fName = input.next();
        System.out.println("Enter Last name");
        String lName = input.next();
        System.out.println("Enter personalId");
        String personalId = input.next();
        Connection connection;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, fName);
        statement.setString(2, lName);
        stmt.setString(2, lName);
    }
    public void displayRecord(ArrayList<Employee> employees) {
    }*/

}
