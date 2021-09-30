package ir.maktab;

import ir.maktab.dataAccess.WorkUnitDatabaseAccess;
import ir.maktab.dataAccess.EmployeesDatabaseAccess;
import ir.maktab.model.WorkUnit;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        EmployeesDatabaseAccess employeeDB = new EmployeesDatabaseAccess();
        WorkUnitDatabaseAccess workUnitDB = new WorkUnitDatabaseAccess();
        Scanner input = new Scanner(System.in);
        System.out.println("********* Choose an option *********");
        System.out.println("1)add employee \n2)add work unit \n3)update employees first name & last name \n4)update work unit" +
                "\n5)show work units list \n6)Show employees of a work unit");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                //WorkUnit workUnits = new WorkUnit();
                System.out.println("enter work unit:");
                String workUnit = input.next();
                System.out.println("enter first name:");
                String firstname = input.next();
                System.out.println("enter last name:");
                String lastName = input.next();
                System.out.println("enter personal ID :");
                int personalID = input.nextInt();
                System.out.println("enter Date Of Birth :");
                Date dateOfBirth = Date.valueOf(input.next());
                workUnitDB.addEmplyeesWorkUnit(workUnit, firstname, lastName, personalID, dateOfBirth);
                break;
            case 2:
                System.out.println("enter work units name:");
                String name = input.next();
                System.out.println("enter work units phone number:");
                String phoneNumber = input.next();
                WorkUnit workUnit2 = new WorkUnit(name, phoneNumber);
                System.out.println(workUnitDB.save(workUnit2));
                break;
            case 3:
                System.out.println("enter id of employee you want to update: ");
                int id = input.nextInt();
                System.out.println("enter new first name: ");
                String newFirstName = input.next();
                System.out.println("enter new last name: ");
                String newLastName = input.next();
                employeeDB.updateEmployee(id, newFirstName, newLastName);
                break;
            case 4:
                System.out.println("enter name of work unit you want to change: ");
                String oldName = input.next();
                System.out.println("enter  new name:");
                String newName = input.next();
                workUnitDB.updateWorkUnitsName(oldName, newName);
                break;
            case 5:
                workUnitDB.showAllWorkUnits();
                break;
            case 6:
                System.out.println("enter work units name :");
                int workUnitID = workUnitDB.findIDOfWorkUnit(input.next());
                employeeDB.findEmployeeWorkUnit(workUnitID);
                break;
            default:
                System.out.println("you are enter invalid number!");
        }
    }
}
