import java.util.ArrayList;
import java.util.List;

// 1. Interface for items eligible for promotional discounts
interface Discountable {
    double applyDiscount(double price);
    void getDiscountDetails();
}

// 2. Abstract Base Class for all Food Items
abstract class FoodItem {
    // Encapsulation: private fields
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters (Encapsulation)
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Abstract method to calculate total price including specific charges
    public abstract double calculateTotalPrice();

    // Concrete method for common details
    public void getItemDetails() {
        System.out.printf("Item: %-15s | Qty: %d | Base Price: $%.2f",
                itemName, quantity, price);
    }
}

// 3. Subclass: VegItem (Standard pricing)
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        // Simple calculation for vegetarian items
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount(double price) {
        return price * 0.10; // 10% discount on Veg items
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("   [Promo] Veggie-Delight: 10% off applied.");
    }
}

// 4. Subclass: NonVegItem (Includes additional preparation/safety charges)
class NonVegItem extends FoodItem {
    private static final double SURCHARGE_PER_ITEM = 2.50;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        // Non-veg items include a surcharge for preparation
        return (getPrice() + SURCHARGE_PER_ITEM) * getQuantity();
    }
}

// 5. Main Class to process orders
public class FoodDeliverySystem {

    // Polymorphic method to process any list of FoodItems
    public static void processOrder(List<FoodItem> order) {
        double grandTotal = 0;
        System.out.println("--- Your Order Receipt ---");

        for (FoodItem item : order) {
            item.getItemDetails();
            double itemTotal = item.calculateTotalPrice();

            // Check for discount eligibility via Interface
            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                double discount = d.applyDiscount(itemTotal);
                itemTotal -= discount;
                d.getDiscountDetails();
            }

            System.out.printf("   > Item Total: $%.2f%n", itemTotal);
            grandTotal += itemTotal;
            System.out.println("-----------------------------------");
        }

        System.out.printf("GRAND TOTAL TO PAY: $%.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        List<FoodItem> myOrder = new ArrayList<>();

        // Adding different types of food to the same list
        myOrder.add(new VegItem("Paneer Tikka", 12.00, 2));
        myOrder.add(new NonVegItem("Chicken Grill", 15.00, 1));
        myOrder.add(new VegItem("Greek Salad", 8.50, 1));

        // Processing the order using polymorphism
        processOrder(myOrder);
    }
}