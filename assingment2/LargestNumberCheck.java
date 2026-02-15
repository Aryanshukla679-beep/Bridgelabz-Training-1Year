import java.util.Scanner;

public class LargestNumberCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        int number1 = scanner.nextInt();

        System.out.println("Enter the second number:");
        int number2 = scanner.nextInt();
        
        System.out.println("Enter the third number:");
        int number3 = scanner.nextInt();

        scanner.close();

        boolean isFirstLargest = (number1 >= number2 && number1 >= number3);
        boolean isSecondLargest = (number2 >= number1 && number2 >= number3);
        boolean isThirdLargest = (number3 >= number1 && number3 >= number2);

        System.out.printf("Is the first number the largest? %b%n", isFirstLargest);
        System.out.printf("Is the second number the largest? %b%n", isSecondLargest);
        System.out.printf("Is the third number the largest? %b%n", isThirdLargest);
    }
}
