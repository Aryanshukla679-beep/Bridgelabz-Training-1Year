package com.gla.exceptionhandling;

public class MultiCatchHandler {
    public static void main(String[] args) {
        // Test case: Change this to null or change the index to test different catches
        int[] numbers = {10, 20, 30, 40, 50};
        int indexToAccess = 10;

        try {
            // This line could throw NullPointerException if 'numbers' was null
            // Or ArrayIndexOutOfBoundsException if 'indexToAccess' is too large
            displayElement(numbers, indexToAccess);

        } catch (NullPointerException e) {
            System.err.println("Array is not initialized!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid index!");
        } catch (Exception e) {
            // General fallback for any other unexpected errors
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void displayElement(int[] arr, int index) {
        // Accessing the length of a null array triggers NullPointerException
        int value = arr[index];
        System.out.println("Value at index " + index + ": " + value);
    }
}