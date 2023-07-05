package Viewer;

import Employees_Mng.EmpList;
import Employees_Mng.Menu;
import java.util.Scanner;

public class Manage_Program {

    public static void main(String[] args) {
        String filename = "employees.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();

        menu.add("Adding new employee");
        menu.add("Removing employee based on his/her code.");
        menu.add("Promoting the salary of an employee based on his/her code.");
        menu.add("Print a list of employees in descending order of salarye");
        menu.add("Save the list to file");
        menu.add("Quit.");

        int userChoice;
        boolean changed = false;
        EmpList listobj = new EmpList();
        listobj.AddFromFile(filename);

        do {
            System.out.println("\n-------------------EMPLOYEE MÂNGER------------------\n");
            userChoice = menu.getUserChoice();

            switch (userChoice) {
                case 1:
                    listobj.addEmp();
                    changed = true;
                    break;
                case 2:
                    listobj.removeEmployee();
                    changed = true;
                    break;
                case 3:
                    listobj.promote();
                    changed = true;
                    break;
                case 4:
                    listobj.printInfo();
                    break;
                case 5:
                    listobj.saveToFile(filename);
                    changed = false;
                    break;
                case 6:
                    System.out.println("Quit!");
                    break;
                default:
                    if (changed) {
                        System.out.println("Save changes Y/N?");
                        String response = sc.nextLine().toUpperCase();
                        if (response.startsWith("Y")) {
                            listobj.saveToFile(filename);
                        }
                    }
            }
        } while (userChoice >= 1 && userChoice <= 5);

    }
}
