import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the person's age:");
        int age = scanner.nextInt();
        
        scanner.close();

        if (age >= 18) {
            System.out.printf("The person's age is %d and can vote.%n", age);
        } else {
            System.out.printf("The person's age is %d and cannot vote.%n", age);
        }
    }
}
