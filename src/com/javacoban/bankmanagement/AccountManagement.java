package com.javacoban.bankmanagement;


// Lưu trữ account, thêm, xóa, tìm kiếm....
//AccountManagement
//        ArrayList<Account> accountList …..
//        + addAccount
//        + deleteAccount
//        + searchAccount

import java.util.ArrayList;

public class AccountManagement extends Account{
    private ArrayList<Account> accountList = new ArrayList<>();

    public ArrayList<Account> getList() {
        return accountList;
    }
    public void addAccount(Account account) {
        for (Account acc : accountList) {
            if (acc.getID() == account.getID()) {
                System.out.println("ID was existed , enter ID other");
                return;
            }
        }
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.remove(account);
    }

    public Account searchByID(long ID) {
        for (Account account: accountList) {
           if( account.getID() == ID) {
               return account;
           }
        }
        System.out.println("Id is not exist,enter again,please!");
        return null;
    }
}
