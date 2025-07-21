package BankingSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BankAccount acc;

        System.out.println("Choose Account Type:");
        System.out.println("1.  Saving Account");
        System.out.println("2.  Current Account");
        System.out.println("Enter your Choice:");
        int accType = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter account number: ");
        String accNo = sc.nextLine();

        System.out.println("Enter account Holder name: ");
        String name = sc.nextLine();

        System.out.println("Enter initial balance: ");
        double balance = sc.nextDouble();

        if(accType == 1){
            System.out.println("Enter interest rate (%): ");
            double rate = sc.nextDouble();
            acc = new SavingsAccount(accNo, name, balance, rate);
        }else {
            System.out.println("Enter overdraft limit: ");
            double limit = sc.nextDouble();
            acc = new CurrentAccount(accNo,name, balance, limit);
        }

        int choice;
        do{
            System.out.println("\n--- Menu ---");
            System.out.println("1. Display Account Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            if(acc instanceof SavingsAccount){
                System.out.println("4. Add Interest");
            }else {
                System.out.println("4. Show Overdraft limit");
            }
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    acc.displayDetails();
                    break;
                case 2:
                    System.out.println("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;
                case 3:
                    System.out.println("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    acc.withdraw(wd);
                    break;
                case 4:
                    if(acc instanceof SavingsAccount){
                        ((SavingsAccount) acc).addInterest();
                    } else if (acc instanceof CurrentAccount){
                        ((CurrentAccount) acc).displayOverdraftInfo();
                    }
                    break;
                case 5:
                    System.out.println("Exiting. Thank You!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice != 5);

        sc.close();
    }
}
