package model;

import java.util.ArrayList;

public class Developer extends Employee {

    protected String teamName;
    protected ArrayList<String> programmingLanguages;
    protected int expYear;
    public Developer(String empID, String empName, int baseSal, String teamName, ArrayList<String> programmingLanguages, int expYear) {
        super(empID, empName, baseSal);
        this.teamName = teamName;
        this.programmingLanguages = programmingLanguages;
        this.expYear = expYear;
    }
    public String getTeamName() {
        return teamName;
    }
    public ArrayList<String> getProgrammingLanguages() {
        return programmingLanguages;
    }
    public int getExpYear() {
        return expYear;
    }
    @Override
    public double getSalary() {
        if (expYear >= 5) {
            return (baseSal + expYear*2000000);
        }
        else if (expYear >= 3 && expYear < 5) {
            return (baseSal + expYear*1000000);
        }
        return baseSal;
    }
    public String toString() {
        String programmingLanguagesList = "";
        //System.out.println(programmingLanguages);
        for (int i=0;i<programmingLanguages.size();i++) {
            programmingLanguagesList += programmingLanguages.get(i);
            if (i != programmingLanguages.size()-1) {
                programmingLanguagesList += ", ";
            }
        }
        return empID + "_" + empName + "_" + getBaseSal() + "_" + teamName + "_" + "[" + programmingLanguagesList + "]" + "_" + expYear;
    }
}
