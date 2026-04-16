import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO: Create a Scanner to read input

        Scanner input = new Scanner(System.in);
        //Naming our scanner 'input'
        
        
        // TODO: Ask for User Name and Initial Deposit
        
        
        
        System.out.println("Enter your name:");
        String name = input.nextLine();

        System.out.println("Enter your initial deposit: ");
        Double deposit = input.nextDouble();

        //We would use a double since $ values can be in cents

        
        
        // TODO: Ask user to select Checking or Savings


        System.out.println("Which Account will you use for today? : " );
        System.out.println("1 - Checking");
        System.out.println("2 - Savings");

        int choice = input.nextInt();


        
        // TODO: Instantiate the correct account type based on input


        BankAccount account; //We use this variable account with the veriable type BankAccount so we can fufill both the savings and checkings account in our 4 loop. 

        if(choice == 1){
            account = new CheckingAccount(name, deposit);  //We have to contain the data from before (i.e name and the deposit #)
        } else {
            account = new SavingsAccount(name, deposit);
        }

        
        // TODO: Create a loop (while) that displays a menu:
        // 1. Deposit
        // 2. Withdraw
        // 3. Check Balance
        // 4. Exit


        int menuSelection = 0;  //Since this value is zero, when we input a value, say 3, it will only takr the input for the 'view balance' for our while loop. 

        while (menuSelection != 4){
            System.out.println("\n --- MENU ---");
            System.out.println("1 - Deposit");
            System.out.println("2 - Withdraw");
            System.out.println("3 - View Balance");
            System.out.println("4 - Exit");
            System.out.println("Please select a choice: ");

            menuSelection = input.nextInt(); //Dependent on the choice, our 'if' and 'if else' statements will go to the appropriate selection


            if(menuSelection == 1) {
                System.out.print("How much will you deposit?: ");
                double dep = input.nextDouble();
                account.deposit(dep);
            } 
            
            else if (menuSelection == 2){

                System.out.print("How much will you withdraw?: ");
                double with = input.nextDouble();
                account.withdraw(with);
            }

            else if (menuSelection == 3){
                System.out.println("Your current balance is: $" + account.getBalance());

            }

            else if (menuSelection == 4) {
                System.out.println("Goodby!");
            }
        }

        input.close(); //Close the scanner 
            

        }


}