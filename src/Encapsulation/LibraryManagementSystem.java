import java.util.ArrayList;
import java.util.List;

// 1. Interface for items that can be reserved in advance
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// 2. Abstract Base Class for all Library Items
abstract class LibraryItem {
    // Encapsulation: private fields
    private String itemId;
    private String title;
    private String author;
    private boolean isCheckedOut;
    private String currentBorrower; // Sensitive data protected by encapsulation

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }

    // Getters and Setters (Encapsulation)
    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public boolean isCheckedOut() { return isCheckedOut; }
    public void setCheckedOut(boolean checkedOut) { isCheckedOut = checkedOut; }

    // Protected setter to restrict who can modify borrower info
    protected void setCurrentBorrower(String borrowerName) {
        this.currentBorrower = borrowerName;
    }

    // Abstract method to be implemented by subclasses
    public abstract int getLoanDuration();

    // Concrete method to show common details
    public void getItemDetails() {
        System.out.printf("[%s] ID: %s | Title: %-18s | Author: %-12s | Loan: %d days%n",
                this.getClass().getSimpleName(), itemId, title, author, getLoanDuration());
    }
}

// 3. Subclass: Book (Standard loan period)
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // Books can be kept for 3 weeks
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setCurrentBorrower(borrowerName);
            System.out.println("   > Success: Book '" + getTitle() + "' reserved for " + borrowerName);
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isCheckedOut();
    }
}

// 4. Subclass: Magazine (Short loan period, usually not reservable)
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // Magazines are 1 week only
    }
}

// 5. Subclass: DVD (High turnover, short loan)
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String director) {
        super(itemId, title, director);
    }

    @Override
    public int getLoanDuration() {
        return 3; // DVDs must be returned in 3 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        System.out.println("   > Success: DVD '" + getTitle() + "' reserved for " + borrowerName);
    }

    @Override
    public boolean checkAvailability() {
        return !isCheckedOut();
    }
}

// 6. Main Execution Class
public class LibrarySystem {
    public static void main(String[] args) {
        List<LibraryItem> inventory = new ArrayList<>();

        // Populate Library
        inventory.add(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        inventory.add(new Magazine("M042", "National Geographic", "Various"));
        inventory.add(new DVD("D990", "Inception", "Christopher Nolan"));

        System.out.println("=== Library Inventory & Loan Policies ===");

        // Polymorphism: Treating all objects as LibraryItems
        for (LibraryItem item : inventory) {
            item.getItemDetails();

            // Checking for Reservable capability at runtime
            if (item instanceof Reservable) {
                Reservable res = (Reservable) item;
                if (res.checkAvailability()) {
                    res.reserveItem("John Doe");
                }
            } else {
                System.out.println("   > Note: This item type cannot be reserved.");
            }
            System.out.println("---------------------------------------------------------");
        }
    }
}