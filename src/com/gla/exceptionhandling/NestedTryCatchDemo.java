package com.gla.exceptionhandling;
import java.util.Scanner;

public class NestedTryCatchDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {100, 200, 300, 400, 500};

        // Outer try block: Handles Array Access
        try {
            System.out.print("Enter an array index (0-4): ");
            int index = scanner.nextInt();

            int value = numbers[index]; // Potential ArrayIndexOutOfBoundsException
            System.out.println("Selected value: " + value);

            // Inner try block: Handles Division Logic
            try {
                System.out.print("Enter a divisor: ");
                int divisor = scanner.nextInt();

                int result = value / divisor; // Potential ArithmeticException
                System.out.println("Result of division: " + result);

            } catch (ArithmeticException e) {
                System.err.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid array index!");
        } catch (Exception e) {
            System.err.println("An unexpected input error occurred.");
        } finally {
            scanner.close();
        }
    }
}
