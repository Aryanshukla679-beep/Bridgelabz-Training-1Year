import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the radius of the circle: ");
        double radius = input.nextDouble();

        // Calculate area using Math.PI for π and Math.pow for the square
        double area = Math.PI * Math.pow(radius, 2);

        // Print result formatted to 2 decimal places
        System.out.printf("The area of the circle with radius %.2f is: %.2f\n", radius, area);

        input.close();
    }
}