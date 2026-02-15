import java.util.Scanner;

public class RectanglePerimeter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input length
        System.out.print("Enter the length of the rectangle: ");
        double length = input.nextDouble();

        // Input width
        System.out.print("Enter the width of the rectangle: ");
        double width = input.nextDouble();

        // Calculate perimeter
        double perimeter = 2 * (length + width);

        System.out.println("The perimeter of the rectangle is: " + perimeter);

        input.close();
    }
}