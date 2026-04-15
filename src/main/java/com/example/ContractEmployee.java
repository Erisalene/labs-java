package com.example;

public class ContractEmployee extends Employee {

    private int contractDuration;

    public ContractEmployee(String name, Position position, double salary, int experience, int contractDuration) {
        super(name, position, salary, experience); 
        this.contractDuration = contractDuration;
    }
    public int getContractDuration() {
        return contractDuration;
    }
    @Override
    public String toString() {
        return "ContractEmployee: " + name +
                ", Salary: " + salary +
                ", Duration: " + contractDuration + " months";
    }
}
