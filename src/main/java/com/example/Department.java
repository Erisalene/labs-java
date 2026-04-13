package com.example;
import java.util.ArrayList;


public class Department {
    private String departmentName;
    private ArrayList<Employee> employees;

    public Department(String departmentName) {
        if (departmentName == null || departmentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва відділу не може бути порожньою");
        }
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        if (emp != null) {
            employees.add(emp);
        }
    }

    public void showAllEmployees() {
        System.out.println("Відділ: " + departmentName);
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).toString());
        }
    }
}