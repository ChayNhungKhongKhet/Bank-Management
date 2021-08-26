package com.javacoban.bankmanagement;


// Những hành động phía user:
//+ inputInfo : scan
//        + display: sout (toString)
//        + Menu : show menu

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AccountManagement accountManagement = new AccountManagement();
        ArrayList<Account> accountList = accountManagement.getList();
        showMenu();
        while (true) {
            System.out.println("Enter order number action: ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    Account account = inputInfor();
                    accountManagement.addAccount(account);
                    break;
                case 2:
                    System.out.print("Enter id of account want delete: ");
                    long idRemove= scanner.nextLong();
                    Account accountRemove= accountManagement.searchByID(idRemove);
                    accountManagement.removeAccount(accountRemove);
                    System.out.println("Remove successfully");
                    break;
                case 3:
                    System.out.println("Enter Id of account want watch");
                    long Id= scanner.nextLong();
                    Account searchAccount = accountManagement.searchByID(Id);
                    display(searchAccount);
                    break;
                case 4:
                    for (Account acc: accountList) {
                        display(acc);
                    }
                    break;
                case 5:
                    System.out.print("Enter id of account want add money: ");
                    long idAddMoney= scanner.nextLong();
                    System.out.print("Enter number money want add: ");
                    double addMoney= scanner.nextDouble();
                    Account accountAddMoney= accountManagement.searchByID(idAddMoney);
                    if (accountAddMoney==null){
                        break;
                    }
                    accountAddMoney.addMoney(addMoney);
                    System.out.println("Add money successfully");
                    break;
                case 6:
                    System.out.print("Enter id of account want withdraw money: ");
                    long idWithdraw = scanner.nextLong();
                    System.out.print("Enter number money want withdraw: ");
                    double withdrawMoney= scanner.nextDouble();
                    Account accountWithdraw= accountManagement.searchByID(idWithdraw);
                    if (accountWithdraw==null){
                        break;
                    }
                    accountWithdraw.withdraw(withdrawMoney);
                    System.out.println("Withdraw money successfully");
                    break;
                case 7:
                    System.out.println("please ,enter infos below: ");
                    System.out.print("Enter id sender:");
                    long idSender= scanner.nextLong();
                    System.out.print("Enter id receiver:");
                    long idReceiver= scanner.nextLong();
                    System.out.print("Enter number money: ");
                    double transferMoney=scanner.nextDouble();
                    Account accountReceiver= accountManagement.searchByID(idReceiver);
                    if (accountReceiver==null){
                        break;
                    }
                    Account accountSender= accountManagement.searchByID(idSender);
                    if (accountSender==null){
                        break;
                    }
                    accountSender.transfer(transferMoney,accountReceiver);
                    break;
                case 8:
                    showMenu();
                    break;
                default:
                    System.out.println("Enter 1 to 9");
                    break;
                case 9:
                    return;

            }

        }
            }

    public static void showMenu() {
        System.out.println("Welcome to the Agribank");
        System.out.println("Please choose an action: ");
        System.out.println("1. Add Account");
        System.out.println("2. Delete Account");
        System.out.println("3. Search Account");
        System.out.println("4. Display all");
        System.out.println("5. Add money for an account");
        System.out.println("6. Withdraw money from an account");
        System.out.println("7. Transfer money");
        System.out.println("8. Show menu");
        System.out.println("9. Exist");
    }

    public static Account inputInfor() {
        System.out.println("Please input info of an account: ");
        System.out.print(" ID: ");
        long ID = scanner.nextLong();
        scanner.nextLine();
        System.out.print(" AccountName: ");
        String accountName = scanner.nextLine();
        double initialMoney = 50000;
        return new Account(ID, accountName, initialMoney);
    }

    public static void display(Account account) {
//        if ()
        System.out.println(account.toString());
    }

}
