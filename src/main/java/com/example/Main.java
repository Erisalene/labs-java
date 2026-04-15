package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static ArrayList<Employee> list = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static final String FILE_NAME = "input.json";

    public static void main(String[] args) {
        loadFromJson();
        printHeader();

        while (true) {
            System.out.println("\n===== ГОЛОВНЕ МЕНЮ (Лаб №9) =====");
            System.out.println("1. Добавити співробітника");
            System.out.println("2. Вивести інформацію про всіх співробітників");
            System.out.println("3. Завершити роботу");
            System.out.print("Вибір: ");
            String choice = sc.nextLine();
            if (choice.equals("3")) {
                saveToJson();
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

    private static void saveToJson() {
        // Создаем Gson с "красивым" выводом
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(list, writer);
            System.out.println("Дані збережено в JSON!");
        } catch (IOException e) {
            System.out.println("Помилка запису: " + e.getMessage());
        }
    }

    private static void loadFromJson() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        Gson gson = new Gson();
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<ArrayList<Employee>>(){}.getType();
            ArrayList<Employee> loadedList = gson.fromJson(reader, listType);

            if (loadedList != null) {
                list = loadedList;
                System.out.println("Завантажено об'єктів: " + list.size());
            }
        } catch (Exception e) {
            System.out.println("Помилка читання JSON: " + e.getMessage());
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