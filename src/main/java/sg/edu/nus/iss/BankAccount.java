package sg.edu.nus.iss;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BankAccount {
    private final String fullName;
    private final String accountNumber;
    private float balance;
    private boolean isClosed;
    private Date createDate;
    private Date closeDate;
    private List<String> transactions;

    public BankAccount(String fullName) {
        this.fullName = fullName;
        this.accountNumber = generateAccountNumber();
        this.balance = 0.0f;
        this.createDate = new Date();
        this.transactions = new ArrayList<>();
    }

    public BankAccount(String fullName, float balance) {
        this.fullName = fullName;
        this.accountNumber = generateAccountNumber();
        this.balance = balance;
        this.createDate = new Date();
        this.transactions = new ArrayList<>();
    }


    public void deposit(float amt) {
        if (isClosed) {
            throw new IllegalArgumentException("Account closed/inactive.");
        } else if (amt < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        } else {
            balance += amt;
            Date currentDate = new Date();
            transactions.add("deposit $" + String.format("%.2f", amt) + " at " + currentDate.toString());
        }
    }

    public void withdraw(float amt) {
        if (isClosed) {
            throw new IllegalArgumentException("Account closed/inactive.");
        } else if (amt < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        } else if (amt > balance) {
            throw new IllegalArgumentException("Not enough cash in account.");
        } else {
            balance -= amt;
            Date currentDate = new Date();
            transactions.add("withdraw $" + String.format("%.2f", amt) + " at " + currentDate.toString());
        }
    }

    public String generateAccountNumber() {
        Random rand = new Random();
        int num1 = rand.nextInt(0, 1000);
        int num2 = rand.nextInt(0, 1000);
        int num3 = rand.nextInt(0, 10000);
        return "" + String.format("%03d", num1) + "-" + String.format("%03d", num2) + "-" + String.format("%04d", num3);
    }

    public String getFullName() {
        return fullName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public boolean isClosed() {
        return isClosed;
    }
    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
        this.closeDate = new Date();
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getCloseDate() {
        return closeDate;
    }
    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }
    public List<String> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        // return "BankAccount [fullName=" + fullName + ", accountNumber=" + accountNumber + ", balance=" + balance
        //         + ", isClosed=" + isClosed + ", createDate=" + createDate + ", closeDate=" + closeDate
        //         + ", transactions=" + transactions + "]";

        return "BankAccount [fullName=" + fullName + ", accountNumber=" + accountNumber + ", balance=" + balance
                + ", isClosed=" + isClosed + ", createDate=" + createDate + ", closeDate=" + closeDate
                + "]";
    }

    public void showAccount() {
        System.out.println("Account name: " + this.fullName);
        System.out.println("Account no.: " + this.accountNumber);
        System.out.println("Balance: " + String.format("%.2f", this.balance));
    }
}
