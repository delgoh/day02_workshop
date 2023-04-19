package sg.edu.nus.iss;

public class FixedDepositAccount extends BankAccount {
    private float interest;
    private int duration;
    private boolean isInterestChanged;
    private boolean isDurationChanged;

    public FixedDepositAccount(String name, float balance) {
        super(name, balance);
        this.interest = 3f;
        this.duration = 6;
        this.isInterestChanged = false;
        this.isDurationChanged = false;
    }
    public FixedDepositAccount(String name, float balance, float interest) {
        super(name, balance);
        this.interest = interest;
        this.duration = 6;
        this.isInterestChanged = false;
        this.isDurationChanged = false;
    }
    public FixedDepositAccount(String name, float balance, float interest, int duration) {
        super(name, balance);
        this.interest = interest;
        this.duration = duration;
        this.isInterestChanged = false;
        this.isDurationChanged = false;
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
    public float getInterest() {
        return interest;
    }
    public void setInterest(float interest) {
        if (!this.isInterestChanged) {
            this.interest = interest;
            this.isInterestChanged = true;
        } else {
            throw new IllegalArgumentException("Interest has been changed once before!");
        }
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        if (!this.isDurationChanged) {
            this.duration = duration;
            this.isDurationChanged = true;
        } else {
            throw new IllegalArgumentException("Duration has been changed once before!");
        }
    }
    
}