package models;

import java.util.*;

public class BankAccount {
    private String holderName;
    private String accountNumber;
    private double balance;
    private List<String> transactionLog;

    public BankAccount(String name, String accNum) {
        this.holderName = name;
        this.accountNumber = accNum;
        this.balance = 0.0;
        this.transactionLog = new ArrayList<>();
        record("Account opened for " + holderName + " [#" + accountNumber + "]");
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            record("Deposited" + amount);
        } else {
            record("Invalid deposit attempt");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            record("Withdrew" + amount);
        } else {
            record("Failed withdrawal of" + amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void printHistory() {
        System.out.println("Transaction History:");
        for (String line : transactionLog) {
            System.out.println("- " + line);
        }
    }

    private void record(String action) {
        transactionLog.add(action);
    }
}
