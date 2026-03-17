import java.util.ArrayList;
import java.util.List;

// 1. Interface for accounts that allow loan applications
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// 2. Abstract Base Class for all Bank Accounts
abstract class BankAccount {
    // Encapsulation: Private fields to secure account data
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters and Setters (Encapsulation)
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    // Protected setter to allow subclasses to update balance during interest calculation
    protected void setBalance(double balance) { this.balance = balance; }

    // Concrete method: Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + " to " + accountNumber);
        }
    }

    // Concrete method: Withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount + " from " + accountNumber);
        } else {
            System.out.println("Insufficient funds or invalid amount for " + accountNumber);
        }
    }

    // Abstract method for account-specific interest logic
    public abstract void calculateInterest();

    public void displayAccountSummary() {
        System.out.printf("Acc: %s | Holder: %-12s | Balance: $%.2f%n",
                accountNumber, holderName, balance);
    }
}

// 3. Subclass: SavingsAccount (Earns monthly interest)
class SavingsAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.04; // 4% Annual interest

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * (INTEREST_RATE / 12);
        setBalance(getBalance() + interest);
        System.out.printf("   > Monthly Interest Applied: $%.2f%n", interest);
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("   > Loan of $" + amount + " approved for " + getHolderName());
        } else {
            System.out.println("   > Loan denied. Minimum balance of $5000 required.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000; // Eligibility based on savings
    }
}

// 4. Subclass: CurrentAccount (Used for business, lower/no interest)
class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void calculateInterest() {
        // Current accounts typically don't earn interest or have minimal rates
        System.out.println("   > Current Account: No monthly interest applied.");
    }
}

// 5. Main Class to demonstrate Polymorphism
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        // Creating different account types
        accounts.add(new SavingsAccount("SAV-9001", "Alice Smith", 6500.0));
        accounts.add(new CurrentAccount("CUR-1002", "Tech Corp", 12000.0));
        accounts.add(new SavingsAccount("SAV-9005", "Bob Jones", 1200.0));

        System.out.println("=== Monthly Banking Process ===");
        for (BankAccount acc : accounts) {
            acc.displayAccountSummary();

            // Dynamic interest calculation (Polymorphism)
            acc.calculateInterest();

            // Checking for Loan eligibility (Interface via Polymorphism)
            if (acc instanceof Loanable) {
                Loanable loanableAcc = (Loanable) acc;
                loanableAcc.applyForLoan(10000.0);
            }

            System.out.println("-------------------------------------------");
        }
    }
}