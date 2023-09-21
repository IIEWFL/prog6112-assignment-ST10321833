
package bankaccountmanagementapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Java arrays (no date) Programiz. Available at: https://www.programiz.com/java-programming/arrays (Accessed: 21 September 2023). 
//Olumide, S. (2023) How to create an array in Java – Array Declaration example, freeCodeCamp.org. Available at: https://www.freecodecamp.org/news/how-to-create-an-array-in-java/ (Accessed: 21 September 2023). 
//Vora, B. (2022) Array in Java (with examples), Scaler Topics. Available at: https://www.scaler.com/topics/java/array-in-java/ (Accessed: 21 September 2023). 
//Java inheritance (no date) Java Inheritance (Subclass and Superclass). Available at: https://www.w3schools.com/java/java_inheritance.asp (Accessed: 21 September 2023). 
//Simplilearn (2023) Inheritance in Java, Simplilearn.com. Available at: https://www.simplilearn.com/tutorials/java-tutorial/inheritence-in-java (Accessed: 21 September 2023). 

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public String toString() {
        return "Account Number: " + accountNumber + "\nAccount Holder: " + accountHolder + "\nBalance: $" + balance;
    }
}

class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account created successfully!");
    }

    public void displayAccounts() {
        System.out.println("Bank Accounts:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("Account " + (i + 1) + ":\n" + accounts.get(i) + "\n");
        }
    }

    Iterable<BankAccount> getAccounts() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

public class BankAccountManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bank Account Management System!");
        Bank bank = new Bank();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create a new bank account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Display all bank accounts");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); 
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accountHolder = scanner.nextLine();
                    System.out.print("Enter initial balance: $");
                    double initialBalance = scanner.nextDouble();
                    BankAccount newAccount = new BankAccount(accountNumber, accountHolder, initialBalance);
                    bank.addAccount(newAccount);
                    break;
                case 2:
                    scanner.nextLine(); 
                    System.out.print("Enter account number: ");
                    String depositAccountNumber = scanner.nextLine();
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    for (BankAccount account : bank.getAccounts()) {
                        if (account.getAccountNumber().equals(depositAccountNumber)) {
                            account.deposit(depositAmount);
                            break;
                        }
                    }
                    break;
                case 3:
                    scanner.nextLine(); 
                    System.out.print("Enter account number: ");
                    String withdrawAccountNumber = scanner.nextLine();
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    for (BankAccount account : bank.getAccounts()) {
                        if (account.getAccountNumber().equals(withdrawAccountNumber)) {
                            account.withdraw(withdrawAmount);
                            break;
                        }
                    }
                    break;
                case 4:
                    bank.displayAccounts();
                    break;
                case 5:
                    System.out.println("Exiting Bank Account Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
