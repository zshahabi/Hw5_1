package ir.maktab.access;

import ir.maktab.model.Employee;
import ir.maktab.model.Worksite;

import java.sql.*;
import java.util.ArrayList;


public class EmployeeAccess {
    private Statement statement;

    public EmployeeAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/emplotee-exercise", "root", "zo60na84");
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllRecordsEmployee() {
        //sql statement for inserting record
        String sql = "SELECT * FROM employee";
        //Creating a collection form employee list for storing all employee record
        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        try {

            //creating and executing our statement
            ResultSet result = statement.executeQuery(sql);
            //iterating over the rows in the result
            while (result.next()) {

                //storing single result in employee object
                Employee employee = new Employee();
                employee.setEmployeeId(Integer.parseInt(result.getString(1)));
                employee.setEmployeeName(result.getString(2));
                employee.setEmployeeLastName(result.getString(3));
                employee.setPersonalNumber(Integer.parseInt(result.getString(4)));
                employee.setBirthDate(result.getDate(5));

                //adding employee in employee list
                employeeList.add(employee);
            }
            //caalling function to display all record
            displayRecordEmployee(employeeList);
        } catch (Exception e) {

        }
    }

    private void displayRecordEmployee(ArrayList<Employee> employees) {
        //iterating over employee list and displaying all employees data
        for (int i = 0; i < employees.size(); i++) {
            System.out.println("Id: " + employees.get(i).getEmployeeId());
            System.out.println("First Name: " + employees.get(i).getEmployeeName());
            System.out.println("Last Name: " + employees.get(i).getEmployeeLastName());
            System.out.println("personalNumber: " + employees.get(i).getPersonalNumber());
            System.out.println("birthDate: " + employees.get(i).getBirthDate());


        }

    }


    public void insertRecord(Employee employee, Worksite worksite) {
        //sql statement for inserting record


        try {
            String sql = "INSERT INTO `emplotee-exercise`.`employee`\n" +
                    "(`employee-id`,\n" +
                    "`employee-name`,\n" +
                    "`employee-lastname`,\n" +
                    "`personal-number`,\n" +
                    "`birthdate`,\n" +
                    "`unitwork-id`)\n" +
                    "VALUES\n" +
                    "(%s," +
                    "%s," +
                    "%s," +

                    "%s," +
                    "%s," +
                    "%s)";
            String sql_worksite = "INSERT INTO `emplotee-exercise`.`unitwork`" +
                    "(`unitwork-id`," +
                    "`unitwork-name`," +
                    "`phonnumber`," +
                    "`employee-id`)" +
                    "VALUES(%s,%s,%s,%s)";

            sql=String.format(sql, employee.getEmployeeId()+"", employee.getEmployeeName() + "", employee.getEmployeeLastName() + "",
                    employee.getPersonalNumber() + "", employee.getBirthDate() + "", worksite.getWorksiteId());
           sql_worksite= String.format(sql_worksite, worksite.getWorksiteId() + "", worksite.getWorksiteName() + "",
                    worksite.getPhoneNumber() + "", employee.getEmployeeId());
            //setting parameter values
           /* statement.setInt(1, employee.getEmployeeId());
            statement.setString(2, employee.getEmployeeName());
            statement.setString(3, employee.getEmployeeLastName());
            statement.setInt(4, employee.getPersonalNumber());
            statement.setDate(5, employee.getBirthDate());
            statement.setInt(6, worksite.getWorksiteId());

            statement.setInt(1, worksite.getWorksiteId());
            statement.setString(2, worksite.getWorksiteName());
            statement.setString(3, worksite.getPhoneNumber());
            statement.setInt(4, employee.getEmployeeId());
            //executing query which will return an integer value
            int rowsInserted = statement.executeUpdate();
            //if rowInserted is greater then 0 mean rows are inserted*/
            boolean rowsInserted = statement.execute(sql);
            boolean rowsInsertedWorkunit = statement.execute(sql_worksite);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void updateRecord(int id, String firstName, String lastName) {
        String sql = "UPDATE `emplotee-exercise`.`employee`\n" +
                "SET\n" +
                "`employee-name` = " + firstName + ",\n" +
                "`employee-lastname` = " + lastName + ",\n" +
                "WHERE `employee-id` = " + id;
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateWorksiteRecord(int idOfWorksite, String nameOfWorksite) {
        String sqlw = "UPDATE `emplotee-exercise`.`unitwork`\n" +
                "SET\n" +
                "`unitwork-name` = <{unitwork-name: }>,\n" +
                "WHERE `unitwork-id` = ?";
    }

    public void showEmployeeByWorksite(int id) {
String sqlShow="SELECT `employee`.`employee-id`,\n" +
        "    `employee`.`employee-name`,\n" +
        "    `employee`.`employee-lastname`,\n" +
        "    `employee`.`personal-number`,\n" +
        "    `employee`.`birthdate`,\n" +
        "    `employee`.`unitwork-id`\n" +
        "FROM `emplotee-exercise`.`employee` WHERE unitwork-id"+id;
        try {
            ResultSet resultSet=statement.executeQuery(sqlShow);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
