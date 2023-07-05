
package Viewer;

import MyUses.Uses;
import Object.List_Employee;


public class Demo_Emp {
    public static void main(String[] args) {
        List_Employee Objlist = new List_Employee();
        
        int choice = 0;
        do{
            System.out.println("-------------------Main Menu------------------");
            System.out.println("1- Create a list of Full time employee");
            System.out.println("2- Create a list of Part time employee");
            System.out.println("3- Print a list of Full time employee");
            System.out.println("4- Print a list of Part time employee");
            System.out.println("5- Exit");
            
            choice = Uses.getInt("Enter choice: ", 0);
            
            switch(choice){
                case 1:
                    for (int i = 0; i < 3; i++) {
                        Objlist.InputEmp_Fulltime();
                    }
                    break;
                case 2:
                    for (int i = 0; i <2; i++) {
                        Objlist.InputEmp_Parttime();
                    }
                    break;
                case 3:
                    for (int i = 0; i < 3; i++) {
                        Objlist.printInfoFulltime();
                    }
                    break;
                case 4:
                    for (int i = 0; i < 3; i++) {
                        Objlist.printInfoParttime();
                    }
                    break; 
            }
        } while (choice >=1 && choice <=4);
        
    }
}
