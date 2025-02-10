// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber != null && !accountNumber.trim().isEmpty()) {
            this.accountNumber = accountNumber;
        } else {
            throw new IllegalArgumentException("Account number cannot be null or empty.");
        }
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        if (holderName != null && !holderName.trim().isEmpty()) {
            this.holderName = holderName;
        } else {
            throw new IllegalArgumentException("Holder name cannot be null or empty.");
        }
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Invalid withdraw amount.");
        }
    }

    // Abstract method
    public abstract double calculateInterest();
}

// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);

    double calculateLoanEligibility();
}

// SavingsAccount class
class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04; // 4% annual interest

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest for current accounts
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan application submitted for amount: " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() + overdraftLimit;
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {
        // Array to store bank accounts
        BankAccount[] accounts = new BankAccount[3];

        // Creating account instances
        accounts[0] = new SavingsAccount("SA123", "Alice", 5000);
        accounts[1] = new CurrentAccount("CA456", "Bob", 10000, 5000);
        accounts[2] = new SavingsAccount("SA789", "Charlie", 8000);

        // Processing accounts
        for (BankAccount account : accounts) {
            System.out.println("Account Holder: " + account.getHolderName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Interest: " + account.calculateInterest());

            if (account instanceof Loanable) {
                Loanable loanable = (Loanable) account;
                System.out.println("Loan Eligibility: " + loanable.calculateLoanEligibility());
                loanable.applyForLoan(10000);
            }

            System.out.println("---------------------------");
        }
    }
}
