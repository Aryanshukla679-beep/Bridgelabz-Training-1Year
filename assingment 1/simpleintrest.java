import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the Principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter the Rate of interest (%): ");
        double rate = input.nextDouble();

        System.out.print("Enter the Time (in years): ");
        double time = input.nextDouble();

        // Simple Interest calculation
        double interest = (principal * rate * time) / 100;

        System.out.println("The Simple Interest is: " + interest);
        System.out.println("Total Amount (Principal + Interest): " + (principal + interest));

        input.close();
    }
}