package Viewer;
import MyUses.Uses;
import Object.List_Student;
public class Demo_Student {
    public static void main(String[] args) {
        List_Student Objlist = new List_Student();
        int choice = 0;
        do {
            System.out.println("\n-------------------Main Menu------------------\n");
            System.out.println("1- Add new student.");
            System.out.println("2- Search a student based on his/her code.");
            System.out.println("3- Update name and mark of a student based on his/her code.");
            System.out.println("4- Remove a student based on his/her code.");
            System.out.println("5- List all students.");
            System.out.println("6- Exit.");
            System.out.println("\n-----------------------------------------------\n");
            choice = Uses.getInt("Enter choice: ", 0);
            switch (choice) {
                case 1:
                    Objlist.addStudent();
                    break;
                case 2:
                    Objlist.searchStudent();
                    break;
                case 3:
                    Objlist.updateStudent();
                    break;
                case 4:
                    Objlist.removeStudent();
                    break;
                case 5:
                    Objlist.printInfo_Student();
                    break;
                case 6:
                    System.out.println("Done!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        } while (choice >= 1 && choice <= 5);
    }
}
