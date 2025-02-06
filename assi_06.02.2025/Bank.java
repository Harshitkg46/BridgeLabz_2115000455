import java.util.ArrayList;
import java.util.List;

class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer, double initialDeposit) {
        Account account = new Account(this, initialDeposit);
        customer.addAccount(account);
        customers.add(customer);
    }
}

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        for (Account account : accounts) {
            System.out.println("Bank: " + account.getBank().getName() + ", Balance: " + account.getBalance());
        }
    }
}

class Account {
    private Bank bank;
    private double balance;

    public Account(Bank bank, double balance) {
        this.bank = bank;
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }
}

class BankandAccount {
    public static void main(String[] args) {
        Bank bank1 = new Bank("National Bank");
        Customer customer1 = new Customer("Alice");

        bank1.openAccount(customer1, 1000.0);
        customer1.viewBalance();
    }
}
