package model;

import java.util.ArrayList;

public class TeamLeader extends Developer {
    private double bonus_rate;
    public TeamLeader(String empID, String empName, int baseSal, String teamName, ArrayList<String> programmingLanguages, int expYear, double bonus_rate) {
        super(empID, empName, baseSal, teamName, programmingLanguages, expYear);
        this.bonus_rate = bonus_rate;
    }
    public double getBonusRate() {
        return bonus_rate;
    }
    @Override
    public double getSalary() {
        return (int)(baseSal * (1 + bonus_rate));
    }
}
