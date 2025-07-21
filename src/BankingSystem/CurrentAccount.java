package BankingSystem;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit){
        super(accountNumber,accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public void withdraw(double amount){
        if(amount <= getBalance() + overdraftLimit){
            double newBalance = getBalance() - amount;
            System.out.println("Withdrawn: ₹" +amount);
            deposit(-amount);
            System.out.println("Withdrawn: ₹" + amount);
        }else{
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }

    public void displayOverdraftInfo(){
        System.out.println("Overdraft Limit: ₹" +overdraftLimit);
    }
}
