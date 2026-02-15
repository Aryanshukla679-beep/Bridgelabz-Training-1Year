import java.util.Scanner;

public class FactorialProgram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        
        if (number < 0) {
            System.out.println("Please enter a positive integer.");
        } else {

            int factorial = 1;
            int i = 1;

            
            while (i <= number) {
                factorial = factorial * i;
                i++;
            }

            
            System.out.println("Factorial of " + number + " is " + factorial);
        }

        sc.close();
    }
}