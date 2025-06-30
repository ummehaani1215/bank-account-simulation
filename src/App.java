package src;
import java.util.Scanner;
import models.BankAccount;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount account = null;

        System.out.println("Welcome to Bank Account Simulator");

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Open New Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    input.nextLine(); // Consume newline
                    System.out.print("Enter your name: ");
                    String name = input.nextLine();
                    System.out.print("Enter account number: ");
                    String number = input.nextLine();
                    account = new BankAccount(name, number);
                    break;

                case 2:
                    if (account == null) {
                        System.out.println("No account found. Please create one first");
                        break;
                    }
                    System.out.print("Enter amount to deposit");
                    double deposit = input.nextDouble();
                    account.deposit(deposit);
                    break;

                case 3:
                    if (account == null) {
                        System.out.println("No account found. Please create one first.");
                        break;
                    }
                    System.out.print("Enter amount to withdraw");
                    double withdraw = input.nextDouble();
                    account.withdraw(withdraw);
                    break;

                case 4:
                    if (account == null) {
                        System.out.println("No account found");
                    } else {
                        System.out.println("Current Balance" + account.getBalance());
                    }
                    break;

                case 5:
                    if (account == null) {
                        System.out.println("No account found");
                    } else {
                        account.printHistory();
                    }
                    break;

                case 6:
                    System.out.println("Goodbye,Visit us again.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
