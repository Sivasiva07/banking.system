import java.util.ArrayList;
import java.util.Scanner;

class Account {
    int accountNumber;
    String holderName;
    double balance;

    Account(int accNo, String name, double bal) {
        accountNumber = accNo;
        holderName = name;
        balance = bal;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        }
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

public class BankingSystem {
    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Banking Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Thank you for using Banking System.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void createAccount() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double bal = sc.nextDouble();

        accounts.add(new Account(accNo, name, bal));
        System.out.println("Account created successfully.");
    }

    static Account findAccount(int accNo) {
        for (Account acc : accounts) {
            if (acc.accountNumber == accNo) {
                return acc;
            }
        }
        return null;
    }

    static void depositMoney() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();

        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    static void withdrawMoney() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();

        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    static void checkBalance() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();

        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.displayDetails();
        } else {
            System.out.println("Account not found.");
        }
    }
}
