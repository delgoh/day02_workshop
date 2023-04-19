package sg.edu.nus.iss;

import java.util.Random;

public class App 
{
    public static void main( String[] args )
    {
        BankAccount acct1 = new BankAccount("John Doe", 0);

        System.out.println(acct1.getBalance());

        acct1.deposit(250.65f);
        acct1.deposit(20.65f);

        System.out.println(acct1.getBalance());
        
        acct1.withdraw(30f);

        System.out.println(acct1.getBalance());
        // System.out.println(acct1.getTransactions().toString());
        System.out.println(acct1.getAccountNumber());
        
        for (String transaction: acct1.getTransactions()) {
            System.out.println(transaction);
        }

        int n = 5;
        BankAccount[] accts = new BankAccount[n];
        for (int i = 0; i < accts.length; i++) {
            float min = 1000.00f;
            // float max = 1000000.00f;
            Random randNum = new Random();
            float initialBalance = min + randNum.nextFloat() * 1000;

            accts[i] = new BankAccount("Employee " + String.valueOf(i), initialBalance);
            accts[i].showAccount();
        }

        FixedDepositAccount acct2 = new FixedDepositAccount("Jane Doe", 354.8f, 80);

        acct2.showAccount();
        acct2.deposit(30f);
        acct2.showAccount();
        System.out.println("The current balance is: " + acct2.getBalance());
        acct2.setDuration(20);
        acct2.setDuration(10); // should expect IllegalArgumentException error
    }
}
