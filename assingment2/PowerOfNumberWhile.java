import java.util.Scanner;

public class PowerOfNumberWhile {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer for the base number: ");
        int number = sc.nextInt();

        System.out.print("Enter a positive integer for the power: ");
        int power = sc.nextInt();

        
        if (number <= 0 || power < 0) {
            System.out.println("Please enter valid positive integers.");
        } else {

            int result = 1;
            int counter = 0; // temp counter variable

            
            while (counter < power) {
                result = result * number;
                counter++;
            }

            System.out.println(number + " raised to the power " + power + " is: " + result);
        }

        sc.close();
    }
}
