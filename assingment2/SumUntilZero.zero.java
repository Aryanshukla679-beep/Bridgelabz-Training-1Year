import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {

        
        double total = 0.0;
        double number;

        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter a number (0 to stop): ");
        number = sc.nextDouble();

        
        while (number != 0) {
            total = total + number;

  
            System.out.print("Enter a number (0 to stop): ");
            number = sc.nextDouble();
        }

       
        System.out.println("Total sum = " + total);

        sc.close();
    }
}
