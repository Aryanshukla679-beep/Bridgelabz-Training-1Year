import java.util.Scanner;

public class SmallestNumberCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        int number1 = scanner.nextInt();

        System.out.println("Enter the second number:");
        int number2 = scanner.nextInt();
        
        System.out.println("Enter the third number:");
        int number3 = scanner.nextInt();

        scanner.close();

        boolean isSmallest = (number1 < number2 && number1 < number3);

        System.out.printf("Is the first number the smallest? %b%n", isSmallest);
    }
}
