package tasks.oop.task3;

import java.io.IOException;

import tasks.oop.task3.calculator.Calculator;

/**
 * @author Alexandr Markov
 * @version 1.1
 * TASK 3. Take your Task 2 and rewrite it using classes.
 * Don't use inheritance and polimorphism, just classes and incapsulation.
 * Where two approach are similiar and where they aren't? Why?
 */

public final class MainApp {

    /**
     * Default constructor.
     */
    private MainApp() {

    }

    /**
     * @param args args
     * @throws IOException If passed an empty object
     */
    public static void main(final String[] args) throws IOException {
        Calculator calculator = new Calculator();
        calculator.process();
    }
}
