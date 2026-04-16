public class CheckingAccount extends BankAccount {
    // DO NOT CHANGE ANY VARIABLE, METHOD, OR CLASS NAMES. THE AUTOGRADER DEPENDS ON THEM.
    private final double OVERDRAFT_FEE = 35.00;

    public CheckingAccount(String accountHolder, double initialDeposit) {
        // TODO: Call the parent constructor using 'super'

        super(accountHolder, initialDeposit); //We want to do this since these are private vairablew within the Bank account, we use super to directly use them 

    }

    @Override
    public void withdraw(double amount) {
        // TODO: Implement Checking withdrawal logic

        if (amount > getBalance()) { //In this case, if the amount the user puts in to withdraw is more than what they have in their account, they fit the requirement for the fee. 'duh lol'
            setBalance(getBalance() - amount - OVERDRAFT_FEE); // we set the balance now from the account, subtracted by the amount they put in and the fee.
            System.out.println("Overdraft! $35.00 fee"); //Let them know they overdrafted from their account 
        
        } else {

            setBalance(getBalance() - amount); //obviously if they didnt do this, leave the fee out of it. 

        }

        System.out.println("Your New Balance is: $" + getBalance()); //Final amount in account


    }
}