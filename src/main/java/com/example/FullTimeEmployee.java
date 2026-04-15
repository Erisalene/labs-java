package com.example;

public class FullTimeEmployee extends Employee {

    private double bonus;

    public FullTimeEmployee(String name, Position position, double salary, int experience, double bonus) {
        super(name, position, salary, experience);
        this.classType = "FullTimeEmployee";
        this.bonus = bonus;
    }
    public double getBonus() {
        return bonus;
    }
    @Override
    public String toString() {
        return "FullTimeEmployee: " + name +
                ", Salary: " + salary +
                ", Bonus: " + bonus;
    }
}
