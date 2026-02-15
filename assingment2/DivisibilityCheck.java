import java.util.Scanner;

public class DivisibilityCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number:");
        int number = scanner.nextInt();
        
        scanner.close();

        boolean isDivisible = (number % 5 == 0);

        System.out.printf("Is the number %d divisible by 5? %b%n", number, isDivisible);
    }
}
