package com.gla.exceptionhandling;
import java.util.Scanner;

public class FinallyExecutionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int num2 = scanner.nextInt();

            int result = num1 / num2;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // This runs only if the user divides by zero
            System.err.println("Error: Cannot divide by zero.");
        } catch (Exception e) {
            // This runs for any other input errors (like entering text)
            System.err.println("Error: Invalid input provided.");
        } finally {
            // This block ALWAYS runs, no matter what happened above
            System.out.println("Operation completed.");
            scanner.close(); // Resources are safely released here
        }
    }
}