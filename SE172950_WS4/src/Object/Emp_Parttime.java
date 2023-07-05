
package Object;


public class Emp_Parttime extends Employee {
    int dailyWage;
    int present;

    public Emp_Parttime(int dailyWage, int present) {
        this.dailyWage = dailyWage;
        this.present = present;
    }

    public Emp_Parttime(int dailyWage, int present, String code, String name, String phone, String address, String department) {
        super(code, name, phone, address, department);
        this.dailyWage = dailyWage;
        this.present = present;
    }

    public int getDailyWage() {
        return dailyWage;
    }

    public void setDailyWage(int dailyWage) {
        this.dailyWage = dailyWage;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }
    
    @Override
    public int totalSalary(){
        return dailyWage *present;
    }
    
    @Override
    public void printInfo(){
        System.out.println(code + "-" + name + "-" + totalSalary());
    }
    
}
