package Object;

import MyUses.Uses;
import java.util.ArrayList;
import java.util.List;

public class List_Employee {

    List list_emp = new ArrayList(); //tạo một danh sách

    public void InputEmp_Fulltime() {
        String code;
        String name;
        String phone;
        String address;
        String department;
        int salary;
        int absent;

        boolean check = true;
        do {
            //Check mã code được nhập vô từ người dùng theo đúng định dạng
            code = Uses.getStringRegex("Enter code: ", "^FS\\d{5}$", "Code is not null", "Code is not format (FSXXXXX");
            if (checkCode(code) >= 0) {
                System.out.println("Code is not duplicate");
            } else {
                check = false;
            }
        } while (check);

        name = Uses.getString("Enter name: ", "Name is not null");
        phone = Uses.getStringRegex("Enter phone: ", "^0\\d{9,11}$", "Phone is not null", "Number phone must be 10 or 12 digit!");
        address = Uses.getString("Enter address: ", "Address is not null");
        department = Uses.getString("Enter department: ", "Department is not null");
        salary = Uses.getInt("Enter salary: ", 1500);
        absent = Uses.getInt("Enter absent: ", 0);

        Employee emp = new Emp_Fulltime(salary, absent, code, name, phone, address, department);
        list_emp.add(emp);
        System.out.println("Added Fulltime successfully!");
    }

    public void InputEmp_Parttime() {
        String code;
        String name;
        String phone;
        String address;
        String department;
        int dailyWage;
        int present;

        boolean check = true;
        do {
            //Check mã code được nhập vô từ người dùng theo đúng định dạng
            code = Uses.getStringRegex("Enter code: ", "^FS\\d{5}$", "Code is not null", "Code is not format (FSXXXXX");
            if (checkCode(code) >= 0) {
                System.out.println("Code is not duplicate");
            } else {
                check = false;
            }
        } while (check);

        name = Uses.getString("Enter name: ", "Name is not null");
        phone = Uses.getStringRegex("Enter phone: ", "^0\\d{9,11}$", "Phone is not null", "Number phone must be 10 or 12 digit!");
        address = Uses.getString("Enter address: ", "Address is not null");
        department = Uses.getString("Enter department: ", "Department is not null");
        dailyWage = Uses.getInt("Enter salary: ", 10);
        present = Uses.getInt("Enter absent: ", 1);

        Employee emp = new Emp_Parttime(dailyWage, present, code, name, phone, address, department);
        list_emp.add(emp);
        System.out.println("Added Parttime successfully!");
    }

    private int checkCode(String code) {
        for (int i = 0; i < list_emp.size(); i++) {
            if (list_emp.get(i) instanceof Emp_Fulltime) {
                if (((Emp_Fulltime) list_emp.get(i)).getCode().equalsIgnoreCase(code)) {
                    return i;
                }
            }

            if (list_emp.get(i) instanceof Emp_Parttime) {
                if (((Emp_Parttime) list_emp.get(i)).getCode().equalsIgnoreCase(code)) {
                    return i;
                }
            }

        }

        return -1;
    }

    public void printInfoFulltime() {
        for (int i = 0; i < list_emp.size(); i++) {
            if (list_emp.get(i) instanceof Emp_Fulltime) {
                ((Emp_Fulltime) list_emp.get(i)).printInfo();
            }
        }
    }

    public void printInfoParttime() {
        for (int i = 0; i < list_emp.size(); i++) {
            if (list_emp.get(i) instanceof Emp_Parttime) {
                ((Emp_Parttime) list_emp.get(i)).printInfo();
            }
        }
    }

}
