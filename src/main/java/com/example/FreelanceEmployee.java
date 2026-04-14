package com.example;

public class FreelanceEmployee extends Employee {
    private double hourlyRate;

    public FreelanceEmployee(String name, Position position, double salary, int experience, double hourlyRate) {
        super(name, position, salary, experience); // salary тут может быть как базовый фикс
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "FreelanceEmployee: " + name + ", Rate: " + hourlyRate + "/hr";
    }
}