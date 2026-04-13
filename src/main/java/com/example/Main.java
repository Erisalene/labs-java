package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();

        System.out.print("Введіть кількість співробітників: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Введення даних для співробітника #" + (i + 1) + ":");

            System.out.print("Ім'я: ");
            String n = scanner.nextLine();

            System.out.print("Посада: ");
            String p = scanner.nextLine();

            System.out.print("Зарплата: ");
            double s = scanner.nextDouble();
            scanner.nextLine();
            list.add(new Employee(n, p, s));
        }
        System.out.println("\nСписок всіх співробітників:");
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }
}
