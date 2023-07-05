package Object;

import MyUses.Uses;
import java.util.ArrayList;
import java.util.List;

public class List_Student {

    List list_student = new ArrayList();

    public void addStudent() {
        String code;
        String name;
        double mark;

        int n;
        do {
            n = Uses.getInt("Enter the number of student to add: ", 0);
        } while (n <= 0);

        for (int i = 0; i < n; i++) {
            boolean check = true;
            do {
                //Check mã code được nhập vô từ người dùng theo đúng định dạng
                code = Uses.getStringRegex("Enter code (S000): ", "^S\\d{3}$", "Code is not null", "Code is not format (FSXXXXX");
                if (checkCode(code, list_student) >= 0) {
                    System.out.println("Code is duplicated.");
                } else {
                    check = false; // nếu chưa thì sẽ thoát khỏi vòng lặp và add mã code vô ds
                }
            } while (check);

            name = Uses.getString("Enter name: ", "Name is not blank");
            mark = Uses.getDouble_Mark("Enter mark: ", 0, 10);

            Student stu = new Student(code, name, mark);
            list_student.add(stu);
        }
        System.out.println("Added student successfully!");
    }

    //Search student base on code
    public void searchStudent() {
        String code;

        boolean check = true;
        do {
            //Check mã code được nhập vô từ người dùng theo đúng định dạng
            code = Uses.getStringRegex("Enter code to search: ", "^S\\d{3}$", "Code is not null", "Code is not format (FSXXXXX");

            int studentIndex = checkCode(code, list_student);
            if (studentIndex >= 0) {
                System.out.println("Found student with code: " + code);
                Student s = (Student) list_student.get(studentIndex);
                s.printInfo();
                break;
            } else {
                System.out.println("No student found with code: " + code);
            }
        } while (check);

    }

    //Update name and mark of student base on code
    public void updateStudent() {
        String code;
        String newName;
        double newMark;

        boolean check = true;
        do {
            //Check mã code được nhập vô từ người dùng theo đúng định dạng
            code = Uses.getStringRegex("Enter code to update: ", "^S\\d{3}$", "Code is not null", "Code is not format (FSXXXXX");
            if (checkCode(code, list_student) >= 0) {
                Student student = (Student) list_student.get(checkCode(code, list_student));

                do {
                    newName = Uses.getString("Enter new name: ", "Name is not blank");
                } while (newName.isEmpty());
                student.setName(newName);

                do {
                    newMark = Uses.getDouble_Mark("Enter new mark (0-10): ", 0, 10);
                } while (newMark < 0 || newMark > 10);
                student.setMark(newMark);

                System.out.println("Updated student with code: " + code);
                student.printInfo();
                break;
            } else {
                check = false; // nếu chưa thì sẽ thoát khỏi vòng lặp và add mã code vô ds
                System.out.println("No student found this code: " + code);
            }
        } while (check);
    }

    //Remove Student base on code
    public void removeStudent() {
        String code;

        boolean check = true;
        do {
            //Check mã code được nhập vô từ người dùng theo đúng định dạng
            code = Uses.getStringRegex("Enter code to remove: ", "^S\\d{3}$", "Code is not null", "Code is not format (FSXXXXX");
            if (checkCode(code, list_student) >= 0) {
                list_student.remove(checkCode(code, list_student));
                System.out.println("Removed student with code: " + code);
                break;
            } else {
                System.out.println("No student found with code: " + code);
                check = false;
            }
        } while (check);
    }

    //Print ra ds tất cả các học sinh
    public void printInfo_Student() {
        for (int i = 0; i < list_student.size(); i++) {
            ((Student) list_student.get(i)).printInfo();
        }
    }

    private int checkCode(String code, List<Student> list_student) {
        //cho kt mã code và ds học sinh
        //Duyệt qua ds list_student, check xem coi có học sinh nào trùng với 
        // mã code cần check hay không
        for (int i = 0; i < list_student.size(); i++) {
            if ((list_student.get(i)).getCode().equalsIgnoreCase(code)) {
                return i; //nếu có
            }
        }
        return -1; // code chưa được sử dụng thì trả về -1

    }

    

}
