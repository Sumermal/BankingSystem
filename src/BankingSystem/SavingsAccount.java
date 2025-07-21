package BankingSystem;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate){
        super(accountNumber,accountHolder,balance);
        this.interestRate = interestRate;
    }

    public void addInterest(){
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest added: ₹" +interest);
    }
}
