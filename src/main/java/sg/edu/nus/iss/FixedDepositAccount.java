package sg.edu.nus.iss;

public class FixedDepositAccount extends BankAccount {
    private final float interest;
    private final int duration;

    public FixedDepositAccount(String name, float balance) {
        super(name, balance);
        this.interest = 3f;
        this.duration = 6;
    }
    public FixedDepositAccount(String name, float balance, float interest) {
        super(name, balance);
        this.interest = interest;
        this.duration = 6;
    }
    public FixedDepositAccount(String name, float balance, float interest, int duration) {
        super(name, balance);
        this.interest = interest;
        this.duration = duration;
    }

    @Override
    public void deposit(float amt) {
    }

    @Override
    public void withdraw(float amt) {
    }

    @Override
    public float getBalance() {
        return super.getBalance() + this.interest;
    }

    
}