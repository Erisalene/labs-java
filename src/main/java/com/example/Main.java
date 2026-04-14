package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Employee> list = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        printHeader();

        while (true) {
            System.out.println("\n===== ГОЛОВНЕ МЕНЮ (Лаб №8) =====");
            System.out.println("1. Добавити співробітника");
            System.out.println("2. Вивести інформацію про всі об’єкти");
            System.out.println("3. Завершити роботу");
            System.out.print("Вибір: ");
            String choice = sc.nextLine();
            if (choice.equals("5")) break;

            try {
                if (choice.equals("4")) {
                    System.out.println("\nСписок співробітників:");
                    for (Employee emp : list) {
                        System.out.println(emp);
                    }
                }
                else {

                    System.out.print("Ім'я: ");
                    String n = sc.nextLine();

                    System.out.print("Посада (DEVELOPER, MANAGER, HR, QA): ");
                    Position p = Position.valueOf(sc.nextLine().toUpperCase());

                    System.out.print("Зарплата: ");
                    double s = Double.parseDouble(sc.nextLine());

                    System.out.print("Стаж: ");
                    int e = Integer.parseInt(sc.nextLine());

                    if (choice.equals("1")) {
                        list.add(new Employee(n, p, s, e));
                        System.out.println("Звичайного співробітника додано!");
                    }
                    else if (choice.equals("2")) {
                        System.out.print("Тривалість контракту: ");
                        int d = Integer.parseInt(sc.nextLine());
                        list.add(new ContractEmployee(n, p, s, e, d));
                        System.out.println("Контрактного співробітника додано!");
                    }
                    else if (choice.equals("3")) {
                        System.out.print("Бонус: ");
                        double b = Double.parseDouble(sc.nextLine());
                        list.add(new FullTimeEmployee(n, p, s, e, b));
                        System.out.println("Штатного співробітника додано!");
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
        System.out.println("  Лабораторна робота №7");
        System.out.println("  Тема: Наслідування, поліморфізм, колекції (ArrayList) + продовження роботи з GitHub (нова гілка)");
        System.out.println("  Виконав: Давиденко Федір");
        System.out.println("=========================================");
    }
}