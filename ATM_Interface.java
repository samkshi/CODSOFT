 import java.util.Scanner;


public class ATM_Interface {
    public static void main(String[] args){
        BankAccount bankAccount = new BankAccount(2000);

   
        ATM atm = new ATM(bankAccount);
        atm.userInput();
    }
}
class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nWelcome to the ATM!");
        System.out.println("1. Check your Balance");
        System.out.println("2. Deposit Money?");
        System.out.println("3. Withdraw?");
        System.out.println("4. Exit?");
        System.out.print("Enter your choice:(choose 1, 2, 3 or 4) ");
    }

    public void userInput() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("Current Balance: " + bankAccount.getBalance());
    }

    private void deposit() {
        System.out.print("Enter the deposit amount: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            bankAccount.deposit(amount);
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    private void withdraw() {
        System.out.print("Enter the withdrawal amount: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            if (bankAccount.withdraw(amount)) {
                System.out.println("Please take your money.");
            }
        } else {
            System.out.println("Invalid amount. Withdrawal failed.");
        }
    }
}
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited successfully. New balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn successfully. New balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
            return false;
        }
    }
}








