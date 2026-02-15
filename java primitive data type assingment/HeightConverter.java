import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        // Create Scanner Object to take user input
        Scanner input = new Scanner(System.in);
        
        // I/P: Ask user for height in cm
        System.out.print("Enter your height in cm: ");
        double heightCm = input.nextDouble();
        
        // Step 1: Convert total cm to total inches (1 inch = 2.54 cm)
        double totalInches = heightCm / 2.54;
        
        // Step 2: Calculate feet (1 foot = 12 inches)
        // We cast to (int) to get the whole number of feet
        int feet = (int) (totalInches / 12);
        
        // Step 3: Calculate remaining inches using Modulus (%)
        double inches = totalInches % 12;
        
        // O/P: Display the result in the specified format
        System.out.println("Your Height in cm is " + heightCm + 
                           " while in feet is " + feet + 
                           " and inches is " + String.format("%.2f", inches));
        
        input.close();
    }
}