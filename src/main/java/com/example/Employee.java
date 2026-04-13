package com.example;

import java.util.Objects;

public class Employee {
    private String name;
    private String position;
    private double salary;
    private int experience;
    public Employee(String name, String position, double salary, int experience) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.experience = experience;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }

    @Override
    public String toString() {
        return String.format("Employee[Name: %s, Pos: %s, Sal: %.2f, Exp: %d]", name, position, salary, experience);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, salary);
    }
}