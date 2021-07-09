package com.main;

import com.account.*;
import com.manage.*;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public static void menu() throws IOException {
        while (true) {
            Manage manageNV = new Manage();
            Register manageRes = new Register();
            System.out.println("--------------------------*****CHƯƠNG TRÌNH QUẢN LÝ NHÂN VIÊN*****-----------------------------");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách nhân viên theo trạng thái        |          2. Xem danh sách toàn bộ nhân viên");
            System.out.println("3. Thêm mới                                       |          4. Cập nhật");
            System.out.println("5. Xóa!                                           |          6. Tìm kiếm nhân viên: ");
            System.out.println("7. Kiểm tra trạng thái nhân viên                  |          8. Cập nhật trạng thái nhân viên: ");
            System.out.println("9. Hiển thị thông tin tài khoản!                  |          10. Xóa tài khoản!");
            System.out.println("11. Đăng xuất!                                    |          12. Đóng chương trình");
            System.out.print("Enter choise: ");
            int choice = Integer.parseInt(sc.nextLine());
            System.out.println("------------------------------------------------------------------------------------------------");
            switch (choice) {
                case 1 -> {
                    System.out.println("Danh sách nhân viên theo trạng thái!");
                    boolean status = getStatus();
                    manageNV.showStatus(status);
                }
                case 2 -> {
                    System.out.println("Danh sách toàn bộ nhân viên!");
                    manageNV.sortNV();
                    manageNV.showAll();
                    manageNV.writeFile();
                }
                case 3 -> {
                    System.out.println("1. NV Fulltime!");
                    System.out.println("2. NV Parttime!");
                    int choiceNV = Integer.parseInt(sc.nextLine());
                    switch (choiceNV) {
                        case 1 -> manageNV.addNVFulltime();
                        case 2 -> manageNV.addNVParttime();
                    }
                }
                case 4 -> {
                    System.out.println("Nhập mã NV: ");
                    String maNV = sc.nextLine();
                    manageNV.updateNV(maNV);
                }
                case 5 -> {
                    System.out.println("Xóa nhân viên");
                    manageNV.deleteNV();
                }
                case 6 -> {
                    System.out.println("Danh sách nhân viên theo tên!");
                    String tenNV = getTenNV(sc);
                    manageNV.findByName(tenNV);
                }
                case 7 -> {
                    System.out.println("Trạng thái nhân viên theo tên!");
                    String tenNV = getTenNV(sc);
                    manageNV.findStatus(tenNV);
                }
                case 8 -> {
                    System.out.println("Nhập mã nhân viên: ");
                    String maNV = sc.nextLine();
                    manageNV.updateStatusNV(maNV);
                }
                case 9 -> {
                    System.out.println("Hiển thị thông tin tài khoản!");
                    System.out.println("Nhập tên tài khoản cần hiển thị");
                    String userName = sc.nextLine();
                    manageRes.AccountInfor(userName);
                }
                case 10 -> {
                    System.out.println("Xóa tài khoản");
                    manageRes.deleteAccount();
                }
                case 11 -> {
                    System.out.println("Đăng xuất.....");
                    Login.log();
                }
                case 12 -> {
                    System.out.println("Đang đóng chương trình......");
                    System.exit(0);
                }
            }
        }
    }

    private static Boolean getStatus() {
        System.out.println("Nhập trạng thái:");
        return Boolean.parseBoolean(sc.nextLine());
    }
    private static String getTenNV(Scanner sc) {
        System.out.println("Nhập tên NV: ");
        return sc.nextLine();
    }
}
