package com.account;

public class Account {
    protected String userName;
    protected String password;

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void displayAccount() {
        System.out.println("Account{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}');
    }

    public String write() {
        return userName + "," + password;
    }
}
