import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    static double balance = 0.0;
    static ArrayList<String> transactions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("===== Welcome to Expense Tracker =====");

        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addIncome(sc);
                case 2 -> addExpense(sc);
                case 3 -> viewBalance();
                case 4 -> viewTransactions();
                case 5 -> System.out.println("Thank you for using Expense Tracker. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    static void addIncome(Scanner sc) {
        System.out.print("Enter income amount: ₹");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance += amount;
            transactions.add("Income: ₹" + amount);
            System.out.println("Income added successfully.");
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    static void addExpense(Scanner sc) {
        System.out.print("Enter expense amount: ₹");
        double amount = sc.nextDouble();
        sc.nextLine(); // consume newline
        if (amount > 0 && amount <= balance) {
            System.out.print("Enter description: ");
            String desc = sc.nextLine();
            balance -= amount;
            transactions.add("Expense: ₹" + amount + " for " + desc);
            System.out.println("Expense recorded successfully.");
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    static void viewBalance() {
        System.out.printf("Your current balance is: ₹%.2f\n", balance);
    }

    static void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions recorded.");
        } else {
            System.out.println("===== Transaction History =====");
            for (String t : transactions) {
                System.out.println("- " + t);
            }
        }
    }
}
