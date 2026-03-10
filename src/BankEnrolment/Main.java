package BankEnrolment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String accountName;
        int userChoice;
        boolean endLoop = true;

        System.out.println("Enter the name of the account holder: ");
        accountName = scanner.nextLine();

        BankAccount acc1 = new BankAccount(accountName);

        while (endLoop){
            System.out.println("Hello "+acc1.getAccountHolder()+", What would you like to do?");
            System.out.println("1) Change account name.");
            System.out.println("2) Display account number.");
            System.out.println("3) Display current balance.");
            System.out.println("4) Deposit money.");
            System.out.println("5) Withdraw money.");
            System.out.println("6) Exit.");

            userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice){
                case 1:
                    System.out.println("Enter the new name: ");
                    accountName = scanner.nextLine();
                    acc1.setAccountHolder(accountName);
                    break;
                case 2:
                    System.out.println(acc1.getAccountNumber());
                    break;
                case 3:
                    System.out.println(acc1.getBalance());
                    break;
                case 4:
                    double depositAmount;
                    System.out.println("Enter an amount to deposit: ");
                    depositAmount = scanner.nextInt();
                    acc1.deposit(depositAmount);
                    System.out.println("Balance is now "+acc1.getBalance());
                    break;
                case 5:
                    double withdrawAmount;
                    System.out.println("Enter an amount to withdraw: ");
                    withdrawAmount = scanner.nextInt();
                    acc1.withdraw(withdrawAmount);
                    System.out.println("Balance is now "+acc1.getBalance());
                    break;
                case 6:
                    endLoop = false;
                    break;
                default:  // Handles invalid inputs
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }


    }
}
