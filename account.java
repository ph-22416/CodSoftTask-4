public class account {
    private double balance;

    public account(double initialBalance) {
        if (initialBalance > 0) {
            balance = initialBalance;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;  // Successful withdrawal
        }
        return false;  // Insufficient funds or invalid amount
    }
}
