package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.*;
import model.Developer;
import model.TeamLeader;
import model.Tester;
import model.Employee;

public class CompanyManagement {

    private ArrayList<Employee> empList;

    // Contructor and read file
    public CompanyManagement(String path1, String path2) throws Exception {
        empList = getEmployeeFromFile(path1, path2);
    }

    // reads from the file into the empList
    public ArrayList<Employee> getEmployeeFromFile(String path1, String path2) throws Exception {
        ArrayList<Employee> arrEmp = new ArrayList<Employee>();
        HashMap<String, ArrayList<String>> proL = new HashMap<String, ArrayList<String>>();
        try {
            //Get programming languages from Employee ID first
            File fProL = new File(path2);
            Scanner sc = new Scanner(fProL);
            while(sc.hasNextLine()) {
                String record = sc.nextLine();
                String[] split = record.split(","); //tach thang record -> empID va proL
                ArrayList<String> programmingLanguages = new ArrayList<String>();
                for (int i=1;i<split.length;i++) {
                    programmingLanguages.add(split[i].trim());
                }
                proL.put(split[0].trim(), programmingLanguages);
            }
            File fEmpList = new File(path1);
            sc = new Scanner(fEmpList);
            String fullPath = fEmpList.getAbsolutePath();
            while (sc.hasNextLine()) {
                Employee emp = null;
                String record = sc.nextLine();
                String[] split = record.split(",");
                if (split.length == 8) { //TeamLeader
                    String id = split[1].trim();
                    String name = split[2].trim();
                    String team = split[3].trim();
                    int expY = Integer.parseInt(split[4].trim());
                    double bonusRate = Double.parseDouble(split[6].trim());
                    int baseSal = Integer.parseInt(split[7].trim());
                    ArrayList<String> programmingLanguages = proL.get(id);
                    emp = new TeamLeader(id, name, baseSal, team, programmingLanguages, expY, bonusRate);
                }
                else if(split[1].trim().charAt(0) == 'D') { //Developer
                    String id = split[1].trim();
                    String name = split[2].trim();
                    String team = split[3].trim();
                    int expY = Integer.parseInt(split[4].trim());
                    int baseSal = Integer.parseInt(split[5].trim());
                    ArrayList<String> programmingLanguages = proL.get(id);
                    emp = new Developer(id, name, baseSal, team, programmingLanguages, expY);
                }
                else if (split[1].trim().charAt(0) == 'T') { //Tester
                    String id = split[1].trim();
                    String name = split[2].trim();
                    double bonusRate = Double.parseDouble(split[3].trim());
                    //System.out.println(bonusRate);
                    String type = split[4].trim();
                    int baseSal = Integer.parseInt(split[5].trim());
                    emp = new Tester(id, name, baseSal, bonusRate, type);
                }
                //nhet emp vao Employee list
                arrEmp.add(emp);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return arrEmp;
    }

    // list of programmers who are proficient in the input pl programmingLanguage.
    public ArrayList<Employee> getDeveloperByProgrammingLanguage(String pl) { //search dev co programmingLanguage cho truoc
        ArrayList<Employee> devList = new ArrayList<Employee>();
        for (int i=0;i<empList.size();i++) {
            Employee amongus = empList.get(i);
            //neu la Developer -> fetch ProgrammingLanguages va check xem co cai pl nao ko
            if (amongus instanceof Developer) {
                Developer dev = (Developer) amongus;
                ArrayList<String> fetchPL = dev.getProgrammingLanguages();
                for (String str : fetchPL) {
                    if (str.equals(pl)) {
                        //System.out.println("hi mom"); //TOP 10 CACH DEBUG
                        devList.add(dev);
                        break;
                    }
                }
            }
            
        }
        return devList;
    }

    // list of testers whose total salary is greater than the value of the parameter
    public ArrayList<Tester> getTestersHaveSalaryGreaterThan(double value) throws Exception {
        ArrayList<Tester> testerList = new ArrayList<Tester>();
        for (int i=0;i<empList.size();i++) {
            Employee emp = empList.get(i);
            if (emp instanceof Tester) {
                Tester tester = (Tester) emp;
                if (tester.getSalary() > value) {
                    testerList.add(tester);
                }
            }
        }
        return testerList;
    }

    public Employee getEmployeeWithHighestSalary() throws Exception {
        Employee highestEmp = null;
        double hSal = 0;
        for (Employee e : empList) {
            double salary = e.getBaseSal();
            if (salary > hSal) {
                hSal = salary;
                highestEmp = e;
            }
        }
        return highestEmp;
    }

    // get the team leader of the group with the most programmers
    public TeamLeader getLeaderWithMostEmployees() throws Exception {
        TeamLeader leader = null;
        ArrayList<TeamLeader> leaderList = new ArrayList<TeamLeader>();
        ArrayList<String> teamList = new ArrayList<String>();
        //fetch lists of Leaders and Teams
        for (Employee e : empList) {
            if (e instanceof Developer) {
                Developer dev = (Developer) e;
                if (dev instanceof TeamLeader) {
                    leaderList.add((TeamLeader) dev);
                }
                String devTeam = dev.getTeamName();
                teamList.add(devTeam);
            }
        }
        HashMap<String, Integer> teamCount = new HashMap<String, Integer>();
        //counting team members
        for (String team : teamList) {
            if (teamCount.get(team) == null) {
                teamCount.put(team, 0);
            }
            else {
                int count = teamCount.get(team);
                teamCount.put(team, count+1);
            }
        }
        //get leader with max team members
        int maxEmp = 0;
        String leaderMax = null;
        for (String i : teamCount.keySet()) {
            if (teamCount.get(i) > maxEmp) {
                maxEmp = teamCount.get(i);
                leaderMax = i;
            }
        }
        for (TeamLeader l : leaderList) {
            if (l.getTeamName().equals(leaderMax)) {
                leader = l;
                break;
            }
        }
        return leader;
    }

    // Sort Employees as descending salary
    public ArrayList<Employee> sorted() throws Exception {
        ArrayList<Employee> sortedList = null;
        
        return sortedList;
    }

    // print empList
    public void printEmpList() {
        for (Employee emp : empList) {
            System.out.println(emp);
        }
    }

    // write emplist
    public <E> boolean writeFile(String path, ArrayList<E> list) throws Exception {
        FileWriter writeFile = new FileWriter(path);
        ArrayList<Employee> empReq = new ArrayList<Employee>();
        if (list == null) {
            empReq = empList;
        }
        else for (E l : list) {
            empReq.add((Employee) l);
        }
        for (int i=0;i<empReq.size();i++) {
            Employee emp = empReq.get(i);
            String outp = (i+1) + ", " + emp.getEmpID() + ", " + emp.getEmpName() + ", ";
            if (emp instanceof Developer) {
                Developer dev = (Developer) emp;
                outp += dev.getTeamName() + ", " + dev.getExpYear() + ", ";
                if (dev instanceof TeamLeader) {
                    TeamLeader leader = (TeamLeader) dev;
                    outp += "L" + ", " + leader.getBonusRate() + ", ";
                }
            }
            else if (emp instanceof Tester) {
                Tester tester = (Tester) emp;
                outp += tester.getBonusRate() + ", " + tester.getType() + ", ";
            }
            outp += emp.getBaseSal() + "\n";
            writeFile.write(outp);
        }
        writeFile.close();
        return true;
    }
    public <E> boolean writeFile(String path, E object) throws Exception {
        FileWriter writeFile = new FileWriter(path);
        ArrayList<Employee> req = new ArrayList<Employee>();
        for (Employee e : empList) {
            if (e.getBaseSal() > 4700000) {
                req.add(e);
                //System.out.println("hi mom");
            }
        }
        writeFile(path, req);
        return true;
    }
}
