package Employees_Mng;

import MyUses.Uses;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class EmpList {

    List<Employee> listemp = new ArrayList(); //tạo một danh sách

    public EmpList() {
        super();
    }

    //Add from file txt
    public void AddFromFile(String fName) {
        try {
            File f = new File(fName);
            if (!f.exists()) {
                return; //nếu không có thì thoát ct luôn
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                if (stk.countTokens() < 3) {
                    // handle the error, e.g., by logging it or throwing an exception
                    continue;
                }
                String code = stk.nextToken().toUpperCase();
                String name = stk.nextToken().toUpperCase();
                int salary = Integer.parseInt(stk.nextToken());
                Employee emp = new Employee(code, name, salary);
                listemp.add(emp);

            }
            bf.close();
            fr.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    //Lưu vào file
    public void saveToFile(String fName) {
        if (listemp.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Employee x : listemp) {
                pw.println(x.getCode() + "," + x.getName() + "," + x.getSalary());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//Tìm kiếm mã code
    private int find(String aCode) {
        //cho kt mã code và ds học sinh
        //Duyệt qua ds list_student, check xem coi có học sinh nào trùng với 
        // mã code cần check hay không
        for (int i = 0; i < listemp.size(); i++) {
            if (listemp.get(i).getCode().equals(aCode.toUpperCase())) {
                return i; //nếu có
            }
        }
        return -1;
    }

    //Add thêm nhân viên vô danh sách
    public void addEmp() {
        String newCode;
        String newName;
        int salary;

        System.out.println("Enter new employee details: ");
        boolean check = true;
        do {
            //Check mã code được nhập vô từ người dùng theo đúng định dạng
            newCode = Uses.getStringRegex("Enter code (SEXXXXX): ", "^SE\\d{6}$", "Code is not null", "Code is not format (SEXXXXXX");
            if (find(newCode) >= 0) {
                System.out.println("Code is duplicated.");
            } else {
                check = false; // nếu chưa thì sẽ thoát khỏi vòng lặp và add mã code vô ds
            }
        } while (check);

        newName = Uses.getString("Enter name: ", "Name is not blank");
        salary = Uses.getInt("Enter salary: ", 1000);

        listemp.add(new Employee(newCode.toUpperCase(), newName.toUpperCase(), salary));
        System.out.println("New employee has been added.");
    }

    //Remove Student base on code
    public void removeEmployee() {
        String dcode;
        dcode = Uses.getStringRegex("Enter code to remove: ", "^SE\\d{6}$", "Code is not null", "Code is not format (SEXXXXXX");

        int pos = find(dcode);
        if (pos < 0) {
            System.out.println("No employee found with code: " + dcode);

        } else {
            listemp.remove(listemp.get(pos));
            System.out.println("Removed employee with code: " + dcode);
        }
    }

    //Promote
    public void promote() {
        String code;
        code = Uses.getStringRegex("Enter code (SEXXXXX): ", "^SE\\d{6}$", "Code is not null", "Code is not format (SEXXXXXX");

        int pos = find(code);
        if (pos < 0) {
            System.out.println("This code does not exist.");

        } else {
            int oldSalary = listemp.get(pos).getSalary();
            int newSalary;

            System.out.println("Old salary: " + oldSalary);
            newSalary = Uses.getInt("Enter a new salary: ", oldSalary);

            listemp.get(pos).setSalary(newSalary);
            System.out.println("The employee " + code + " has been updated.");

        }
    }

    public void printInfo() {
        if (listemp.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        Collections.sort(listemp);
        System.out.println("\nEMPLOYEE LIST");
        System.out.println("----------------------------------");
        for (Employee x : listemp) {
            x.print();
        }
    }

}

//    private int checkCode(String code, List<Employee> list_emp)  {
//        //cho kt mã code và ds học sinh
//        //Duyệt qua ds list_student, check xem coi có học sinh nào trùng với 
//        // mã code cần check hay không
//        for (int i = 0; i < list_emp.size(); i++) {
//            if ((list_emp.get(i)).getCode().equalsIgnoreCase(code)) {
//                return i; //nếu có
//            }
//        }
//        return -1; // code chưa được sử dụng thì trả về -1
//
//    }
