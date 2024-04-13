// CheckingAccount.java
package lab6;

public class CheckingAccount extends BankAccount {
    private static final double FEE = 0.15; // Cost of clearing one check

    public CheckingAccount(String name, double initialAmount) {
        super(name, initialAmount);
        setAccountNumber(getAccountNumber() + "-10");
    }

    @Override
    public boolean withdraw(double amount) {
        boolean completed = super.withdraw(amount + FEE);
        return completed;
    }
}
