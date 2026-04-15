package com.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    private static ArrayList<Employee> list = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static final String FILE_NAME = "input.txt";

    public static void main(String[] args) {
        loadFromFile();
        printHeader();

        while (true) {
            System.out.println("\n===== ГОЛОВНЕ МЕНЮ (Лаб №9) =====");
            System.out.println("1. Добавити співробітника");
            System.out.println("2. Вивести інформацію про всіх співробітників");
            System.out.println("3. Завершити роботу");
            System.out.print("Вибір: ");
            String choice = sc.nextLine();
            if (choice.equals("3")) {
                saveToFile();
                break;
            }
            try {
                if (choice.equals("1")) {
                    addNewEmployee();
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

    private static void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Employee e : list) {
                String type = e.getClass().getSimpleName();
                StringBuilder sb = new StringBuilder();
                sb.append(type).append(";")
                        .append(e.getName()).append(";")
                        .append(e.getPosition()).append(";")
                        .append(e.getSalary()).append(";")
                        .append(e.getExperience());


                if (e instanceof ContractEmployee) {
                    sb.append(";").append(((ContractEmployee) e).getContractDuration());
                } else if (e instanceof FullTimeEmployee) {
                    sb.append(";").append(((FullTimeEmployee) e).getBonus());
                } else if (e instanceof InternEmployee) {
                    sb.append(";").append(((InternEmployee) e).getMentorName());
                } else if (e instanceof FreelanceEmployee) {
                    sb.append(";").append(((FreelanceEmployee) e).getHourlyRate());
                }
                writer.println(sb.toString());
            }
            System.out.println("Дані успішно збережено у " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Помилка при збереженні: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(";");
                String type = parts[0];
                String name = parts[1];
                Position pos = Position.valueOf(parts[2]);
                double sal = Double.parseDouble(parts[3]);
                int exp = Integer.parseInt(parts[4]);

                switch (type) {
                    case "Employee":
                        list.add(new Employee(name, pos, sal, exp));
                        break;
                    case "ContractEmployee":
                        int dur = Integer.parseInt(parts[5]);
                        list.add(new ContractEmployee(name, pos, sal, exp, dur));
                        break;
                    case "FullTimeEmployee":
                        double bonus = Double.parseDouble(parts[5]);
                        list.add(new FullTimeEmployee(name, pos, sal, exp, bonus));
                        break;
                    case "InternEmployee":
                        String mentor = parts[5];
                        list.add(new InternEmployee(name, pos, sal, exp, mentor));
                        break;
                    case "FreelanceEmployee":
                        double rate = Double.parseDouble(parts[5]);
                        list.add(new FreelanceEmployee(name, pos, sal, exp, rate));
                        break;
                }
            }
            System.out.println("Дані завантажено з файлу. Кількість: " + list.size());
        } catch (Exception e) {
            System.out.println("Помилка при зчитуванні файлу (можливо, файл пошкоджений).");
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
                System.out.println("Невірний тип.");
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
        System.out.println("  Лабораторна робота №9");
        System.out.println("  Тема: Ієрархія успадкування, робота з файлами для зберігання інформації");
        System.out.println("  Виконав: Давиденко Федір");
        System.out.println("=========================================");
    }
}