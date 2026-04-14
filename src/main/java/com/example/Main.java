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
            System.out.println("1. Додати звичайного співробітника");
            System.out.println("2. Додати контрактного співробітника");
            System.out.println("3. Додати повного співробітника");
            System.out.println("4. Вивести всіх");
            System.out.println("5. Вихід");
            System.out.print("Вибір: ");
            String choice = sc.nextLine();
            if (choice.equals("5")) break;

            try {
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
                if (choice.equals("1")) {
                    list.add(new Employee(n, p, s, e));
                    System.out.println("Звичайного співробітника додано!");

                } else if (choice.equals("2")) {
                    System.out.print("Тривалість контракту (місяців): ");
                    int duration = Integer.parseInt(sc.nextLine());

                    list.add(new ContractEmployee(n, p, s, e, duration));
                    System.out.println("Контрактного співробітника додано!");

                } else if (choice.equals("3")) {
                    System.out.print("Бонус: ");
                    double bonus = Double.parseDouble(sc.nextLine());

                    list.add(new FullTimeEmployee(n, p, s, e, bonus));
                    System.out.println("Штатного співробітника додано!");
                }

                else if (choice.equals("4")) {
                    System.out.println("\nСписок співробітників:");
                    for (Employee emp : list) {
                        System.out.println(emp);
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
        System.out.println("  Тема: Класи, статичні члени, агрегація, перерахування (enum)");
        System.out.println("  Виконав: Давиденко Федір");
        System.out.println("=========================================");
    }
}