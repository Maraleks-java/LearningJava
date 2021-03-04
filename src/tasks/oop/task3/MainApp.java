package tasks.oop.task3;

import tasks.oop.task3.calculator.Calculator;

import java.io.IOException;

/**
 * @author Alexandr Markov
 * @version 1.1
 * TASK 3. Take your Task 2 and rewrite it using classes.
 * Don't use inheritance and polimorphism, just classes and incapsulation.
 * Where two approach are similiar and where they aren't? Why?
 */

public final class MainApp {
    private MainApp() {
    }
    /**
     * @param args
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {
        Calculator calculator = new Calculator();
        calculator.start();
    }
}
