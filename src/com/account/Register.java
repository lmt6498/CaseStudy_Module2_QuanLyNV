package com.account;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Register {
    List<Account> accounts = SaveAccount.readFile("src/account.csv");
    static Scanner sc = new Scanner(System.in);

    public Register() throws IOException {
    }

    public boolean register(String userName, String password) throws IOException {
        for (Account s : accounts) {
            if (s.getUserName().equals(userName)) {
                System.out.println("Tài khoản đã tồn tại! Vui lòng nhập 1 tài khoản khác!");
                return false;
            }
        }
        accounts.add(new Account(userName, password));
        System.out.println("Đăng ký thành công!");
        SaveAccount.writeFile("src/account.csv", accounts);
        return true;
    }

    public boolean login(String userName, String password) {
        for (Account s : accounts) {
            if (s.getUserName().equals(userName) && s.getPassword().equals(password)) {
                System.out.println("Đăng nhập thành công");
                return true;
            }
        }
        System.out.println("Sai tài khoản hoặc mật khẩu. vui lòng nhập lại");
        return false;
    }

    public void deleteAccount() throws IOException {
        System.out.println("Nhập username cần xóa: ");
        String username = sc.nextLine();
        accounts.removeIf(x -> x.getUserName().equals(username));
        SaveAccount.writeFile("src/account.csv", accounts);
    }

    public void AccountInfor(String name) {
        int check = -1;
        for (Account s : accounts) {
            if (s.getUserName().equals(name)) {
                s.displayAccount();
                check = 1;
            }
        }
        if (check < 1) {
            System.out.println("Tài khoản không tồn tại!");
        }
    }
}
