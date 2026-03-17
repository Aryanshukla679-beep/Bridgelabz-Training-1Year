import java.util.ArrayList;
import java.util.List;

// 1. Interface for products that incur government tax
interface Taxable {
    double calculateTax(double price);
    void getTaxDetails();
}

// 2. Abstract Base Class for all Products
abstract class Product {
    // Encapsulation: private fields
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters (Encapsulation)
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Abstract method for category-specific discounts
    public abstract double calculateDiscount();

    public void displayProductInfo() {
        double discount = calculateDiscount();
        double finalPrice = price - discount;
        System.out.printf("ID: %d | Item: %-15s | Base: $%.2f | Discount: -$%.2f | Final: $%.2f%n",
                productId, name, price, discount, finalPrice);
    }
}

// 3. Concrete Class: Electronics (High Tax, Moderate Discount)
class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% off Electronics
    }

    @Override
    public double calculateTax(double price) {
        return price * 0.15; // 15% Sales Tax
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Tax Category: Electronics Standard (15%)");
    }
}

// 4. Concrete Class: Clothing (Seasonal Discount, Lower Tax)
class Clothing extends Product implements Taxable {
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% off Clothing
    }

    @Override
    public double calculateTax(double price) {
        return price * 0.05; // 5% Luxury/Apparel Tax
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Tax Category: Apparel (5%)");
    }
}

// 5. Concrete Class: Groceries (Low Discount, Tax Exempt)
class Groceries extends Product {
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% off Groceries
    }
    // Groceries does not implement Taxable (Tax Exempt)
}

// 6. Main Execution Class
public class EcommercePlatform {
    public static void main(String[] args) {
        List<Product> catalog = new ArrayList<>();

        // Adding various products
        catalog.add(new Electronics(501, "Laptop", 1200.00));
        catalog.add(new Clothing(702, "Winter Jacket", 150.00));
        catalog.add(new Groceries(303, "Organic Almonds", 25.00));

        System.out.println("=== Product Catalog & Pricing ===");
        for (Product p : catalog) {
            p.displayProductInfo();

            // Checking for Interface implementation at runtime
            if (p instanceof Taxable) {
                Taxable taxableItem = (Taxable) p;
                double tax = taxableItem.calculateTax(p.getPrice());
                System.out.printf("   [Tax Info] Added Tax: $%.2f%n", tax);
            } else {
                System.out.println("   [Tax Info] This item is Tax Exempt.");
            }
            System.out.println("--------------------------------------------------");
        }
    }
}