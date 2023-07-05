
package Object;


public class Student {
    String code;
    String name;
    double mark = 0;

    public Student(String code, String name, double mark) {
        this.code = code;
        this.name = name;
        this.mark = mark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
    
    public void printInfo(){
        System.out.println(code + "-" + name + "-" + mark);
    }
}
