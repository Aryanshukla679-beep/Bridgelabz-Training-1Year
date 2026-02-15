import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your weight in kg: ");
        double weight = sc.nextDouble();
        System.out.print("Enter your height in cm: ");
        double heightCm = sc.nextDouble();

        
        double heightM = heightCm / 100;

        
        double bmi = weight / (heightM * heightM);

        
        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            status = "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            status = "Overweight";
        } else { 
            status = "Obese";
        }

        
        System.out.println("Your BMI is: " + String.format("%.2f", bmi));
        System.out.println("Your weight status is: " + status);

        sc.close();
    }
}