public class CheckingAccount extends BankAccount {
    private final double OVERDRAFT_FEE = 35.00;

    public CheckingAccount(String accountHolder, double initialDeposit) {
        // TODO: Call the parent constructor using 'super'

        super(accountHolder, initialDeposit);
    }

    @Override
    public String withdraw(double amount) {
        // TODO: Implement Checking withdrawal logic and error handling for incorrect input

       if (amount <= 0) {
        return "Sorry, could you please put in a valid number other than 0?";
       }

        double newBalance = getBalance() - amount;
        setBalance(newBalance);

        if (newBalance < 0) {
            setBalance(newBalance - OVERDRAFT_FEE);
            return "Overdraft! $35.00 fee applied. New Balance: $" + String.format("%.2f", getBalance());
        }
 
     return "Your withdrawl was successful! Here is your new Balance: $ " + String.format("%.2f", getBalance());
    }

    }

 
