package com.gla.exceptionhandling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AutoCloseHandler {
    public static void main(String[] args) {
        String path = "info.txt";

        // Try-with-resources: resources declared in () are automatically closed
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String firstLine = reader.readLine();

            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("The file is empty.");
            }

        } catch (IOException e) {
            // This handles file not found or read errors
            System.err.println("Error reading file");
        }
        // No 'finally' block needed! The reader is already closed here.
    }
}
