package com.example;

import java.util.Objects;

public class Employee {
    private String name;
    private String position;
    private double salary;
    private int experience;
    private static int totalCount = 0;
    private Position position;

    public Employee(String name, String position, double salary, int experience) {
        setName(name);
        setPosition(position);
        setSalary(salary);
        setExperience(experience);
        this.position = position;
        totalCount++;
    }
    public static int getTotalCount() {
        return totalCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ім'я не може бути порожнім");
        }
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("Посада не може бути порожньою");
        }
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не може бути від'ємною");
        }
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        if (experience < 0 || experience > 50) {
            throw new IllegalArgumentException("Стаж повинен бути в межах від 0 до 50 років");
        }
        this.experience = experience;
    }

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
                experience == employee.experience &&
                Objects.equals(name, employee.name) &&
                Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, position, salary, experience);
    }
}