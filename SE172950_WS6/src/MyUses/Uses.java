package MyUses;

import java.util.Scanner;

public class Uses {

    //Nhập một chuỗi vào
    public static String getString(String welcome, String mess) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println(mess);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    //Nhập một chuỗi dựa trên cái định dạng của chương trình cho sẵn
    public static String getStringRegex(String welcome, String pattern, String mess, String messRegex) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println(mess);
            } else if (!result.matches(pattern)) {
                System.out.println(messRegex);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    //Nhập số vào chương trình 
    public static int getInt(String welcome, int min) {
        boolean check = true;
        int number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try{ 
                System.out.println(welcome);
                number = Integer.parseInt(sc.nextLine()); //cho số nhập dưới dạng nextLine() để loại bỏ Enter
                if (number<min) {
                    System.out.println("Number must be larger than " + min );
                } else {
                    check = false;
                }
            } catch(NumberFormatException e){
                System.out.println("Enter number !!!");
            }
        } while (check || number < min);
        return number;
    }
    
    public static float getFloat(String welcome, int min) {
        boolean check = true;
        float number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try{ 
                System.out.println(welcome);
                number = Float.parseFloat(sc.nextLine()); //cho số nhập dưới dạng nextLine() để loại bỏ Enter
                if (number<min) {
                    System.out.println("Number must be larger than " + min );
                } else {
                    check = false;
                }
            } catch(NumberFormatException e){
                System.out.println("Enter number !!!");
            }
        } while (check || number < min);
        return number;
    }

    
}
