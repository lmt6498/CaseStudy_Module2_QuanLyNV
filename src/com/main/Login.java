package com.main;

import com.account.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Login {
    static Scanner sc = new Scanner(System.in);
    static List<Account> accounts;
    static {
        try {
            accounts = SaveAccount.readFile("src/account.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void log() throws IOException {
        Register reslog = new Register();
        while (true) {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ NHÂN VIÊN-----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("3. Thoát khỏi chương trình!");
            int choiceLog = Integer.parseInt(sc.nextLine());
            if (choiceLog == 1) {
                while (true) {
                    System.out.println("Đăng nhập: ");
                    System.out.println("Nhập username");
                    String user = sc.nextLine();
                    System.out.println("Nhập password");
                    String pass = sc.nextLine();
                    if (reslog.login(user, pass)) {
                        break;
                    }
                }
                break;
            } else if (choiceLog == 2) {
                while (true) {
                    System.out.println("Đăng ký tài khoản!");
                    System.out.println("Nhập username");
                    String user = sc.nextLine();
                    System.out.println("Nhập password");
                    String pass = sc.nextLine();
                    if (reslog.register(user, pass)) {
                        break;
                    }
                }
            } else if (choiceLog == 3) {
                System.out.println("Đang thoát khỏi chương trình....");
                System.exit(0);
            }
        }
    }
}
