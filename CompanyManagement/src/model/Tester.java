package model;

public class Tester extends Employee {

    protected double bonusRate;
    protected String type;

    public Tester (String empID, String empName, int baseSal, double bonusRate, String type) {
        super(empID, empName, baseSal);
        this.bonusRate = bonusRate;
        this.type = type;
    }
    public double getBonusRate() {
        return bonusRate;
    }
    public String getType() {
        return type;
    }
    @Override
    public double getSalary() {
        return (int)(baseSal * (1 + bonusRate));
    }

}
