import java.util.Scanner;

public class SumUntilZeroOrNegative {
    public static void main(String[] args) {

        double total = 0.0;
        double number;

        Scanner sc = new Scanner(System.in);

   
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            number = sc.nextDouble();

           

            if (number <= 0) {
                break;
            }

          
            total = total + number;
        }

       
        System.out.println("Total sum = " + total);

        sc.close();
    }
}