package tasks.oop.task3;

import tasks.oop.task3.calculator.Calculator;

import java.io.IOException;

/**
 * TASK 3. Take your Task 2 and rewrite it using classes.
 * Don't use inheritance and polimorphism, just classes and incapsulation.
 * Where two approach are similiar and where they aren't? Why?
 */

public class MainApp {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        calculator.start();
    }
}
