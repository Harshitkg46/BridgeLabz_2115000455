
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BankAccount {
    private double balance = 0;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountTest {
    BankAccount account = new BankAccount();

    @Test
    public void testDeposit() {
        account.deposit(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.deposit(500);
        account.withdraw(200);
        assertEquals(300, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        account.deposit(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200));
    }
}
