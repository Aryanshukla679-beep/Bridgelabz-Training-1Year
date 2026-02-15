import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

       
        if (n <= 0) {
            System.out.println("Please enter a valid natural number (greater than 0).");
        } else {

           
            int sumWhile = 0;
            int i = 1;

            while (i <= n) {
                sumWhile = sumWhile + i;
                i++;
            }

            
            int sumFormula = n * (n + 1) / 2;

            
            System.out.println("Sum using while loop   = " + sumWhile);
            System.out.println("Sum using formula      = " + sumFormula);

           
            if (sumWhile == sumFormula) {
                System.out.println("Result is correct ✔ Both computations match.");
            } else {
                System.out.println("Result is incorrect ✘ Computations do not match.");
            }
        }

        sc.close();
    }
}
