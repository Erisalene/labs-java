package com.example;

public class InternEmployee extends Employee {
    private String mentorName;

    public InternEmployee(String name, Position position, double salary, int experience, String mentorName) {
        super(name, position, salary, experience);
        this.classType = "InternEmployee";
        this.mentorName = mentorName;
    }
    public String getMentorName() {
        return mentorName;
    }
    @Override
    public String toString() {
        return "InternEmployee: " + name + ", Mentor: " + mentorName + ", Stipend: " + salary;
    }
}