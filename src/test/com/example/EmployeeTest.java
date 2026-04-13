package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    @Test
    void testInvalidSalary() {
        Employee emp = new Employee("Ivan",Position.DEVELOPER, 1000, 5);
        assertThrows(IllegalArgumentException.class, () -> emp.setSalary(-500));
    }

    @Test
    void testEmptyNameConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("", "Dev", 1000, 5));
    }
}