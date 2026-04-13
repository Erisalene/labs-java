package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Додати співробітника\n2. Вивести всіх\n3. Вихід");
            String choice = sc.nextLine();
            if (choice.equals("3")) break;

            try {
                if (choice.equals("1")) {
                    System.out.print("Ім'я: "); String n = sc.nextLine();
                    System.out.print("Посада: "); String p = sc.nextLine();
                    System.out.print("Зарплата: "); double s = Double.parseDouble(sc.nextLine());
                    System.out.print("Стаж: "); int e = Integer.parseInt(sc.nextLine());
                    list.add(new Employee(n, p, s, e));
                } else if (choice.equals("2")) {
                    list.forEach(System.out::println);
                }
            } catch (NumberFormatException ex) {
                System.out.println("Помилка: введіть числове значення!");
            } catch (IllegalArgumentException ex) {
                System.out.println("Помилка даних: " + ex.getMessage());
            }
        }
    }
}