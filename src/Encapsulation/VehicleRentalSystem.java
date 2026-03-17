import java.util.ArrayList;
import java.util.List;

// 1. Interface for insurance-related behaviors
interface Insurable {
    double calculateInsurance(double baseRate);
    String getInsuranceDetails();
}

// 2. Abstract Base Class for all Vehicles
abstract class Vehicle {
    // Encapsulation: private fields to protect data
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Getters and Setters (Encapsulation)
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

    // Abstract method to be implemented by specific vehicles
    public abstract double calculateRentalCost(int days);

    public void displayBasicInfo() {
        System.out.println("[" + type + "] Plate: " + vehicleNumber + " | Daily Rate: $" + rentalRate);
    }
}

// 3. Concrete Class: Car
class Car extends Vehicle implements Insurable {
    private String policyNumber; // Sensitive detail

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance(double baseRate) {
        return baseRate * 0.05; // 5% of base rate for cars
    }

    @Override
    public String getInsuranceDetails() {
        // Encapsulation: We hide the full policy number for security
        return "Car Policy: " + policyNumber.substring(0, 3) + "****";
    }
}

// 4. Concrete Class: Bike
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        // Bikes might have a discount for long-term rentals
        double total = getRentalRate() * days;
        return (days > 7) ? total * 0.90 : total;
    }
    // Bikes in this system are not Insurable
}

// 5. Concrete Class: Truck
class Truck extends Vehicle implements Insurable {
    private String policyNumber;

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 50.0; // Flat $50 heavy-vehicle fee
    }

    @Override
    public double calculateInsurance(double baseRate) {
        return baseRate * 0.12; // 12% higher risk for trucks
    }

    @Override
    public String getInsuranceDetails() {
        return "Commercial Truck Policy: " + policyNumber;
    }
}

// 6. Main execution class demonstrating Polymorphism
public class RentalSystem {
    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();

        fleet.add(new Car("ABC-1234", 50.0, "POL889922"));
        fleet.add(new Bike("BIKE-99", 15.0));
        fleet.add(new Truck("TRK-7700", 120.0, "COM-554411"));

        int rentalDays = 5;
        System.out.println("--- Rental Fleet Report (Duration: " + rentalDays + " days) ---");

        for (Vehicle v : fleet) {
            v.displayBasicInfo();
            double rentalCost = v.calculateRentalCost(rentalDays);
            System.out.printf("   > Rental Cost: $%.2f%n", rentalCost);

            // Demonstrating Polymorphism with Interface
            if (v instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) v;
                double insuranceCost = insurableVehicle.calculateInsurance(rentalCost);
                System.out.println("   > " + insurableVehicle.getInsuranceDetails());
                System.out.printf("   > Insurance Premium: $%.2f%n", insuranceCost);
            } else {
                System.out.println("   > No insurance required for this vehicle type.");
            }
            System.out.println("--------------------------------------------------");
        }
    }
}