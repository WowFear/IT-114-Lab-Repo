public class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountHolder, double initialDeposit) {
        // TODO: Call the parent constructor using 'super'
    
    super(accountHolder, initialDeposit);
    
    }

    @Override
    public String withdraw(double amount) {
        // TODO: Implement Savings withdrawal logic and error handling for incorrect input
    
    if (amount <= 0) {
        return "Sorry, could you please put in a valid number other than 0?";
    }

    if (amount > getBalance()) {
        return "Transaction Denied: Insufficient funds. Balance remains: $" + String.format("%.2f", getBalance());
    }

    setBalance(getBalance() - amount);
    return "Your withdrawl was successful! Here is your new Balance: $ " + String.format("%.2f", getBalance());
    }


}

//Pretty much followed the same process I did for the lab from the past for the banking application but just using return instead of like a system.out.println since that would only work for the terminal