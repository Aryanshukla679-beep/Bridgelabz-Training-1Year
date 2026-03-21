package com.gla.exceptionhandling;
public class InterestCalculator {

    // 'throws' is the declaration: It warns the caller about potential exceptions
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {

        // 'throw' is the action: It manually triggers the exception
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }

        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        double myAmount = -500.0;
        double myRate = 5.5;
        int myYears = 3;

        try {
            // Attempting to call the method
            double interest = calculateInterest(myAmount, myRate, myYears);
            System.out.println("Calculated Interest: " + interest);

        } catch (IllegalArgumentException e) {
            // Handling the propagated exception here
            System.err.println("Invalid input: Amount and rate must be positive");
        }
    }
}
