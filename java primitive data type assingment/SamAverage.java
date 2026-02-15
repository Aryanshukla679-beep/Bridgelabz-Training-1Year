public class SamAverage {
    public static void main(String[] args) {
        // Variable declaration based on the marks provided
        int maths = 94;
        int physics = 95;
        int chemistry = 96;
        
        // Logic: Average = (Sum of marks) / (Number of subjects)
        // We use double to ensure precision during division
        double average = (maths + physics + chemistry) / 3.0;
        
        // Output the result in the specified format
        System.out.println("Sam's average mark in PCM is " + average);
    }
}