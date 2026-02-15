import java.util.Scanner;

public class ArmstrongCheck {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter a number to check if it's an Armstrong number: ");
        int number = sc.nextInt();

        
        int sum = 0;
        int originalNumber = number;

        
        while (originalNumber != 0) {
            // d. Find the last digit
            int digit = originalNumber % 10;

            sum += digit * digit * digit;

            
            originalNumber = originalNumber / 10;
        }

        // f. Check if sum equals the original number
        if (sum == number) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is NOT an Armstrong number.");
        }

        sc.close(); // Close the scanner
    }
}
