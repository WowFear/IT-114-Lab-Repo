public class SavingsAccount extends BankAccount {
    // DO NOT CHANGE ANY VARIABLE, METHOD, OR CLASS NAMES. THE AUTOGRADER DEPENDS ON THEM.
    public SavingsAccount(String accountHolder, double initialDeposit) {
        // TODO: Call the parent constructor using 'super'

        super(accountHolder, initialDeposit); //We can do a similar thing we did for the checking account for the savings

    }

    @Override
    public void withdraw(double amount) {
        // TODO: Implement Savings withdrawal logic

        if(amount > getBalance()){
            
            System.out.println("Transaction Denied: Insufficent funds"); //So since this is a savings accoount do not allow for an overdraft fee, we dont have to immplment it.
        
        } else {

            setBalance(getBalance() - amount); //Its either they have the money or not. 
 
        }

        System.out.println("Your New Balance is: $" + getBalance());

    }
}