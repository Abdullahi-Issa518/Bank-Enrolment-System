package BankEnrolment;

import java.util.Random;

public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    private static int totalAccounts;

    public BankAccount(String accountHolder){
        this.accountHolder = accountHolder;
        this.accountNumber = generateAccountNumber();
        this.balance = 0.0;
        totalAccounts++;
    }

    private String generateAccountNumber(){
        Random random = new Random();
        int num;

        num = random.nextInt(1000000);
        return String.format("%06d", num);
    }

    public void setAccountHolder(String name){
        accountHolder = name;
    }

    public String getAccountHolder(){
        return accountHolder;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public static int getTotalAccount(){
        return totalAccounts;
    }

    public void deposit(double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }
        balance += amount;
    }

    public void withdraw(double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0.");
        } else if (balance < amount) {
            throw new IllegalStateException("Insufficient funds.");
        }
        else {
            balance -= amount;
        }
    }

    public void transfer(BankAccount other, double amount){
        if (other == null) {
            throw new IllegalArgumentException("Other account cannot be null.");
        }
        withdraw(amount);
        other.deposit(amount);
    }
}
