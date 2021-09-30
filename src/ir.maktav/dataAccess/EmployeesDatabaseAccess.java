package ir.maktab.dataAccess;

import ir.maktab.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeesDatabaseAccess {
    private Connection connection;

    public EmployeesDatabaseAccess() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee&workunit", "root", "Nasim1374");
    }

    public int save(Employee employee) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQuary = String.format("INSERT INTO employees (first_name,last_name,person_id,date_of_birth,work_unit_id_fk) " +
                            "VALUES ('%s' , '%s' , %i , '%tF' , %s)", employee.getFirstName(), employee.getLastName(),
                    employee.getPersonalID(), employee.getDateOfBirth(), employee.getWorkUnit().getWorkUnitID());
            int i = statement.executeUpdate(sqlQuary);
            return i;
        } else {
            return 0;
        }
    }

    public void updateEmployee(int id, String newFirstName, String newLastName) throws SQLException {
        if (connection != null) {
            String sqlQuary = String.format("UPDATE employees SET first_name = ? , last_name = ? WHERE employee_id = ?");
            PreparedStatement update = connection.prepareStatement(sqlQuary);
            update.setString(1, newFirstName);
            update.setString(2, newLastName);
            update.setInt(3, id);
            update.executeUpdate();

        }
    }

    public void findEmployeeWorkUnit(int workUnitID) throws SQLException {
        if (connection != null) {
            String sqlQuery = String.format("SELECT * FROM employees WHERE work_unit_id_fk=?");
            PreparedStatement find = connection.prepareStatement(sqlQuery);
            find.setInt(1, workUnitID);
            ResultSet resultSet = find.executeQuery();
            ArrayList<Employee> arrayList = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4), resultSet.getDate(5));
                arrayList.add(employee);
            }
            for (Employee employee : arrayList) {
                System.out.println("ID:" + employee.getEmployeeID() + ",");
                System.out.println("first name:" + employee.getFirstName() + ",");
                System.out.println("last name:" + employee.getLastName() + ",");
                System.out.println("personal ID:" + employee.getPersonalID() + ",");
                System.out.println("date of birth:" + employee.getDateOfBirth() + ",");
            }

        }

    }

}

