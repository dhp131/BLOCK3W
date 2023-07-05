package Employees_Mng;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends ArrayList<String> {

    public Menu() {
        super();
    }

    public int getUserChoice() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        for (int i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + "-" + this.get(i));
        }

        System.out.println("_________________________________");

        do {
            System.out.println("Select 1..6: ");
            try {
                choice = Integer.parseInt(sc.nextLine());

                if (choice < 1 || choice > 6) {
                    System.out.println("**Number from 1 to 6");
                }
            } catch (NumberFormatException e) {
                System.out.println("**Number format");
            }
        } while (choice < 1 || choice > 6);
        return choice;
    }
}


