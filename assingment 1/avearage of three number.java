import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter three numbers to calculate their average:");
        
        System.out.print("Number 1: ");
        double num1 = input.nextDouble();

        System.out.print("Number 2: ");
        double num2 = input.nextDouble();

        System.out.print("Number 3: ");
        double num3 = input.nextDouble();

        // Calculate average: (sum) / count
        // Parentheses are necessary to ensure addition happens before division
        double average = (num1 + num2 + num3) / 3;

        System.out.println("The average of the three numbers is: " + average);

        input.close();
    }
}