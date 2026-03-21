package com.gla.exceptionhandling;
import java.util.Scanner;

// 1. Define the Custom Exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {

    // 2. Create the validation method
    // 'throws' in the signature warns the caller this method is "dangerous"
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        } else {
            System.out.println("Access granted!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your age: ");
        try {
            int userAge = scanner.nextInt();

            // 3. Call the method and handle the custom exception
            validateAge(userAge);

        } catch (InvalidAgeException e) {
            // Catches our specific custom error
            System.err.println(e.getMessage());
        } catch (Exception e) {
            // Catches other issues like non-numeric input
            System.err.println("Invalid input. Please enter a number.");
        } finally {
            scanner.close();
        }
    }
}
