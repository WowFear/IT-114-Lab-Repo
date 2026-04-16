import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    private static BankAccount myAccount;
    private static JLabel balanceLabel;
    public static void main(String[] args) {
        // TODO: Create a GUI using javax.Swing and JFrames, Panels, etc

        //1. We want to start off with the user's inpuits, so just initlizing the account so we can get into the GUI
    try {
        String name = JOptionPane.showInputDialog("Please enter your name!: ");
        if (name == null){
            System.exit(0);
        }

        String depoStr = JOptionPane.showInputDialog("How much will you initally deposit?:");
        double iniDeposit = Double.parseDouble(depoStr);

        String type = JOptionPane.showInputDialog("Which account are you going to use? Please type 1 for Checking or 2 for Savings:");
        int choice = Integer.parseInt(type.trim());

    if (choice == 1) {
       
        myAccount = new CheckingAccount(name, iniDeposit);
    
    } else if (choice == 2) {
        
        myAccount = new SavingsAccount(name, iniDeposit);
    
    } else {
        
        JOptionPane.showMessageDialog(null, "Hmm, that wasn't a valid choice. Can you please try writting 1 or 2");
        main(null);
        return;
}
    
        //2. Here we load in the Main Dashboard
        buildAndDisplayGUI();
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: Please enter a valid number.");
            main(null);
        }
    }
    
    private static void buildAndDisplayGUI() {
    JFrame appFrame = new JFrame("Simple Bank App");
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.setSize(350, 250);
    appFrame.setLayout(new GridLayout(5, 1, 10, 10));

    JLabel welcomeMsg = new JLabel("Welcome, " + myAccount.getAccountHolder() + "!", SwingConstants.CENTER);
    balanceLabel = new JLabel("Current Balance: $" + String.format("%.2f", myAccount.getBalance()), SwingConstants.CENTER);

    JTextField amountInput = new JTextField();
    JPanel actionPanel = new JPanel();

    JButton depositBtn = new JButton("Deposit");
    JButton withdrawBtn = new JButton("Withdraw");
    JButton exitBtn = new JButton("Exit");

    actionPanel.add(depositBtn);
    actionPanel.add(withdrawBtn);

    appFrame.add(welcomeMsg);
    appFrame.add(balanceLabel);
    appFrame.add(new JLabel("Enter Amount:", SwingConstants.CENTER));
    appFrame.add(amountInput);
    appFrame.add(actionPanel);
    appFrame.add(exitBtn);

    depositBtn.addActionListener(e -> {
        try {
            double depositAmt = Double.parseDouble(amountInput.getText());
            String depositResult = myAccount.deposit(depositAmt);
            balanceLabel.setText("Current Balance: $" + String.format("%.2f", myAccount.getBalance()));
            JOptionPane.showMessageDialog(appFrame, depositResult);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(appFrame, "Please enter a valid number.");
        }
    });

    withdrawBtn.addActionListener(e -> {
        try {
            double withdrawAmt = Double.parseDouble(amountInput.getText());
            String withdrawResult = myAccount.withdraw(withdrawAmt);
            balanceLabel.setText("Current Balance: $" + String.format("%.2f", myAccount.getBalance()));
            JOptionPane.showMessageDialog(appFrame, withdrawResult);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(appFrame, "Please enter a valid number.");
        }
    });

    exitBtn.addActionListener(e -> System.exit(0));

    appFrame.setVisible(true);
}

}







