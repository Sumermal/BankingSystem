package BankingSystem;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder,double balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println("Deposited: ₹" +amount);
    }

    public void withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println("Withdraw: ₹" +amount);
        }else{
            System.out.println("Insufficient Balance!!");
        }
    }

    public  void displayDetails(){
        System.out.println("\n  Account Details:");
        System.out.println("Account No: "+accountNumber);
        System.out.println("Holder Name: "+accountHolder);
        System.out.println("Balance: ₹"+balance);
    }

    public double getBalance(){
        return  balance;
    }
}
