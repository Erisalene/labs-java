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
            System.out.println("2. Вивести інформацію про всіх співробітників");
            System.out.println("3. Завершити роботу");
            System.out.print("Вибір: ");
            String choice = sc.nextLine();
            if (choice.equals("3")) break;

            try {
                if (choice.equals("1")) {
                    addNewEmployee(); // Вызываем подменю выбора типа
                } else if (choice.equals("2")) {
                    printAll();
                } else {
                    System.out.println("Невірний вибір!");
                }
            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }

    private static void addNewEmployee() {
        System.out.println("\n--- Оберіть тип співробітника ---");
        System.out.println("1. Звичайний");
        System.out.println("2. Контрактний");
        System.out.println("3. Штатний (з бонусом)");
        System.out.println("4. Стажер");
        System.out.println("5. Фрілансер");
        System.out.println("0. Повернутися назад");
        System.out.print("Ваш вибір: ");

        String type = sc.nextLine();
        if (type.equals("0")) return;

        System.out.print("Ім'я: ");
        String name = sc.nextLine();
        System.out.print("Посада (DEVELOPER, MANAGER, HR, QA, DESIGNER): ");
        Position pos = Position.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Зарплата/Ставка: ");
        double sal = Double.parseDouble(sc.nextLine());
        System.out.print("Стаж: ");
        int exp = Integer.parseInt(sc.nextLine());

        switch (type) {
            case "1":
                list.add(new Employee(name, pos, sal, exp));
                break;
            case "2":
                System.out.print("Тривалість контракту (міс): ");
                int dur = Integer.parseInt(sc.nextLine());
                list.add(new ContractEmployee(name, pos, sal, exp, dur));
                break;
            case "3":
                System.out.print("Бонус: ");
                double bonus = Double.parseDouble(sc.nextLine());
                list.add(new FullTimeEmployee(name, pos, sal, exp, bonus));
                break;
            case "4":
                System.out.print("Прізвище ментора: ");
                String mentor = sc.nextLine();
                list.add(new InternEmployee(name, pos, sal, exp, mentor));
                break;
            case "5":
                System.out.print("Погодинна ставка: ");
                double rate = Double.parseDouble(sc.nextLine());
                list.add(new FreelanceEmployee(name, pos, sal, exp, rate));
                break;
            default:
                System.out.println("Тип не обрано, повернення в меню.");
        }
    }

    private static void printAll() {
        if (list.isEmpty()) {
            System.out.println("Штат порожній.");
        } else {
            for (Employee e : list) {
                System.out.println(e);
            }
        }
    }


    private static void printHeader() {
        System.out.println("=========================================");
        System.out.println("  Лабораторна робота №8");
        System.out.println("  Тема: Розширення ієрархії класів, поліморфізм, меню створення об’єктів + робота з Git (merge в main)");
        System.out.println("  Виконав: Давиденко Федір");
        System.out.println("=========================================");
    }
}