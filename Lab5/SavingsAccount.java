// SavingsAccount.java
package lab6;

public class SavingsAccount extends BankAccount {
    private double rate = 0.025; // Annual interest rate
    private static int savingsNumber = 0;

    public SavingsAccount(String name, double initialBalance) {
        super(name, initialBalance);
       
        setAccountNumber(getAccountNumber() + "-" + savingsNumber);
    }

    public void postInterest() {
        double interest = getBalance() * rate / 12;
        deposit(interest);
    }

    @Override
    public String getAccountNumber() {
        return super.getAccountNumber();
    }

    public SavingsAccount(SavingsAccount oldAccount, double initialBalance) {
        super(oldAccount, initialBalance);
        savingsNumber++;
        setAccountNumber(oldAccount.getAccountNumber().substring(0, 6) + "-" + savingsNumber);
    }
}
