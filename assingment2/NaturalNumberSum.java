import java.util.Scanner;

public class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number (n) to find the sum up to n:");
        int number = scanner.nextInt();
        
        scanner.close();

        if (number >= 0) {
            // Use long to avoid integer overflow for larger sums
            long sum = (long) number * (number + 1) / 2;
            System.out.printf("The sum of %d natural numbers is %d%n", number, sum);
        } else {
            System.out.printf("The number %d is not a natural number%n", number);
        }
    }
}
