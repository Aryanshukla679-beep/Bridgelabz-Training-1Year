package com.gla.exceptionhandling;
import java.util.Scanner;
import java.util.InputMismatchException;

public class DivisionHandler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the numerator (number to be divided): ");
            int numerator = scanner.nextInt();

            System.out.print("Enter the denominator (number to divide by): ");
            int denominator = scanner.nextInt();

            // This line might throw ArithmeticException
            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } catch (InputMismatchException e) {
            // Triggered if the user enters text instead of an integer
            System.err.println("Error: Please enter valid numeric values only.");
        } catch (ArithmeticException e) {
            // Triggered specifically for division by zero
            System.err.println("Error: Cannot divide by zero.");
        } finally {
            // Good practice to close the scanner
            scanner.close();
        }
    }
}
