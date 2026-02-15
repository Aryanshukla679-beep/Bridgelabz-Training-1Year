import java.util.Scanner;

public class KmToMilesConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in Kilometers: ");
        double kilometers = input.nextDouble();

        // Conversion factor: 1 km = 0.621371 miles
        double miles = kilometers * 0.621371;

        // Displaying result with formatting
        System.out.printf("%.2f Kilometers is equal to %.4f Miles\n", kilometers, miles);

        input.close();
    }
}