public abstract class BankAccount {
    private String accountHolder;
    private double balance;


    public BankAccount(String accountHolder, double initialDeposit) {
        // TODO: Initialize the instance variables
    
    this.accountHolder = accountHolder;
    this.balance = initialDeposit;
    
    }

    
    public String deposit(double amount) {
        // TODO: Implement deposit logic and error handling for incorrect input

        balance += amount;
        return "Your deposit was successful! Here's your new balance: $" + String.format("%.2f", balance);

    }

    /**
     * Abstract method: Child classes must implement this.
     * @return 
     */
    public abstract String withdraw(double amount);

   
    // --- GETTERS AND SETTERS ---
    
    public String getAccountHolder() {
        // TODO: Return the account holder name
        return accountHolder; 
    }

    public double getBalance() {
        // TODO: Return the current balance
        return  balance; 
    }

    protected void setBalance(double balance) {
        // TODO: Set the balance

        this.balance = balance;

    }
}

//Regular getter setter stuff for the variables. 