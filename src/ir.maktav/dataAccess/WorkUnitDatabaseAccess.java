package ir.maktab.dataAccess;

import ir.maktab.model.Employee;
import ir.maktab.model.WorkUnit;

import java.sql.*;
import java.util.ArrayList;

public class WorkUnitDatabaseAccess {
    private Connection connection;

    public WorkUnitDatabaseAccess() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee&workunit", "root", "Nasim1374");
    }

    public int save(WorkUnit workUnit) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQuary = String.format("INSERT INTO workUnits(name,phone_number)VALUES('%s','%s')", workUnit.getName(), workUnit.getPhoneNumber());
            int i = statement.executeUpdate(sqlQuary);
            return 1;
        } else {
            return 0;
        }
    }

    public void updateWorkUnitsName(String oldName, String newName) throws SQLException {
        if (connection != null) {
            String sQlQuary = String.format("UPDATE workUnits SET name = ? WHERE name = ?");
            PreparedStatement updateName = connection.prepareStatement(sQlQuary);
            updateName.setString(1, newName);
            updateName.setString(2, oldName);
            updateName.executeUpdate();

        }

    }

    public void addEmplyeesWorkUnit(String workUnitName, String firstName, String lastName, int personalID, Date dateOfBirth) throws SQLException, ClassNotFoundException {
        if (connection != null) {
            WorkUnit workUnit = new WorkUnit();
            String sqlQuery = "SELECT * FROM work_units WHERE name = ?";
            PreparedStatement findWorkUnit = connection.prepareStatement(sqlQuery);
            findWorkUnit.setString(1, workUnitName);
            ResultSet resultSet = findWorkUnit.executeQuery();
            boolean isFoundWorkUnit = false;
            while (resultSet.next()) {
                EmployeesDatabaseAccess employeesDS = new EmployeesDatabaseAccess();
                workUnit.setWorkUnitID(resultSet.getInt(1));
                workUnit.setName(resultSet.getString(2));
                workUnit.setPhoneNumber(resultSet.getString(3));
                Employee employee = new Employee(firstName, lastName, personalID, dateOfBirth, workUnit);
                System.out.println(employeesDS.save(employee));
                isFoundWorkUnit = true;

            }
            if (!isFoundWorkUnit) {
                System.out.println("work unit is not exist whit name' " + workUnitName + "'");
            }
        }
    }

    public int findIDOfWorkUnit(String name) throws SQLException {
        int id = 0;
        String sqlQuery = String.format("SELECT work_unit_id FROM work_units WHERE name = ?");
        PreparedStatement findIDOfWorkUnit = connection.prepareStatement(sqlQuery);
        findIDOfWorkUnit.setString(1, name);
        ResultSet resultSet = findIDOfWorkUnit.executeQuery();

        while (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        return id;
    }

    public void showAllWorkUnits() throws SQLException {
        if (connection != null) {
            String sqlQuery = String.format("SELECT * FROM work_units");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            ArrayList<WorkUnit> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                WorkUnit workUnit = new WorkUnit(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3));
                arrayList.add(workUnit);
            }
            for (WorkUnit workUnit : arrayList) {
                System.out.println("ID:" + workUnit.getWorkUnitID() + ",");
                System.out.println("name:" + workUnit.getName() + ",");
                System.out.println("phone number:" + workUnit.getPhoneNumber() + ",");
            }

        }
    }

}
