package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printHeader();
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();

        while (true) {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Додати співробітника");
            System.out.println("2. Вивести всіх та статистику");
            System.out.println("3. Тест конструктора копіювання");
            System.out.println("4. Вихід");
            System.out.print("Вибір: ");
            String choice = sc.nextLine();
            if (choice.equals("4")) break;

            try {
                if (choice.equals("1")) {
                    System.out.print("Ім'я: ");
                    String n = sc.nextLine();
                    System.out.print("Посада (DEVELOPER, MANAGER, HR, QA): ");
                    Position p = Position.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Зарплата: ");
                    double s = Double.parseDouble(sc.nextLine());
                    System.out.print("Стаж: ");
                    int e = Integer.parseInt(sc.nextLine());
                    list.add(new Employee(n, p, s, e));
                    System.out.println("Співробітника додано успішно!");
                } else if (choice.equals("2")) {
                    System.out.println("\nСписок співробітників:");
                    for (Employee emp : list) {
                        System.out.println(emp);
                    }

                    System.out.println("\nВсього створено об'єктів у системі: " + Employee.getTotalCount());

                } else if (choice.equals("3")) {

                    if (list.isEmpty()) {
                        System.out.println("Спочатку додайте хоча б одного співробітника!");
                    } else {
                        Employee original = list.get(0);
                        Employee copy = new Employee(original);
                        System.out.println("Оригінал: " + original);
                        System.out.println("Копія створена: " + copy);
                        System.out.println("Кількість об'єктів зросла до: " + Employee.getTotalCount());
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("Помилка: введіть коректне числове значення!");
            } catch (IllegalArgumentException ex) {
                System.out.println("Помилка: " + ex.getMessage() + ". Перевірте назву посади або значення.");
            }
        }
        sc.close();
    }


    private static void printHeader() {
        System.out.println("=========================================");
        System.out.println("  Лабораторна робота №6");
        System.out.println("  Тема: Класи, статичні члени, агрегація, перерахування (enum)");
        System.out.println("  Виконав: Давиденко Федір");
        System.out.println("=========================================");
    }
}