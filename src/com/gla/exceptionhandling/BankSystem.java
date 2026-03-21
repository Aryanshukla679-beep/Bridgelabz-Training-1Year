package com.gla.exceptionhandling;
import java.util.Scanner;

// 1. Define the Custom Checked Exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // 2. The Withdrawal Method
    // Note: We must declare the checked exception using 'throws'
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            // Unchecked: Usually a programmer or input error
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            // Checked: A business rule violation
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Starting with 1000
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();

            // 3. Attempt the transaction
            account.withdraw(amount);

        } catch (InsufficientBalanceException e) {
            // Catches the custom business rule exception
            System.err.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            // Catches the negative amount exception
            System.err.println(e.getMessage());
        } catch (Exception e) {
            // Catches unexpected input (like typing "abc")
            System.err.println("Transaction failed: Invalid input.");
        } finally {
            scanner.close();
        }
    }
}
