package com.gla.exceptionhandling;

import java.io.*;

public class PerfectFileHandler {
    public static void main(String[] args) {
        File file = new File("data.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: Please ensure 'data.txt' exists.");
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file.");
        }
    }
}
