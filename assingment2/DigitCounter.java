import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to count its digits: ");
        int number = sc.nextInt();

       
        int count = 0;

        
        int temp = number; 
        while (temp != 0) {
            
            temp = temp / 10;

            
            count++;
        }

       
        if (number == 0) {
            count = 1;
        }

       
        System.out.println("The number of digits in " + number + " is: " + count);

        sc.close();
    }
}
