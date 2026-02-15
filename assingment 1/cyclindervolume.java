import java.util.Scanner;

public class CylinderVolume {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking radius input
        System.out.print("Enter the radius of the cylinder: ");
        double radius = input.nextDouble();

        // Taking height input
        System.out.print("Enter the height of the cylinder: ");
        double height = input.nextDouble();

        // Formula: Volume = PI * r^2 * h
        double volume = Math.PI * Math.pow(radius, 2) * height;

        System.out.printf("The volume of the cylinder is: %.2f\n", volume);

        input.close();
    }
}