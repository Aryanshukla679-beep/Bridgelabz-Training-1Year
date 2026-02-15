import java.util.Scanner;

public class TempConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        double celsius = input.nextDouble();

        // Conversion formula
        double fahrenheit = (celsius * 9 / 5) + 32;

        System.out.println(celsius + "°C is equal to " + fahrenheit + "°F");

        input.close();
    }
}