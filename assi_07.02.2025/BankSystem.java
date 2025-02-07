
class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
    public void displayAccountType() {
        System.out.println("General Bank Account");
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }

    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }

    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}
class FixedDepositAccount extends BankAccount {
    private int depositTerm; 

    public FixedDepositAccount(String accountNumber, double balance, int depositTerm) {
        super(accountNumber, balance);
        this.depositTerm = depositTerm;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }

    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Deposit Term: " + depositTerm + " months");
    }
}
class BankSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA12345", 5000.00, 3.5);
        savings.displayAccountType();
        savings.displayAccountDetails();
        System.out.println("-------------------");
        CheckingAccount checking = new CheckingAccount("CA67890", 3000.00, 1000.00);
        checking.displayAccountType();
        checking.displayAccountDetails();
        System.out.println("-------------------");
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD54321", 10000.00, 12);
        fixedDeposit.displayAccountType();
        fixedDeposit.displayAccountDetails();
    }
}

