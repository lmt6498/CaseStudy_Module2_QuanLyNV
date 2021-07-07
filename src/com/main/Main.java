package com.main;

import com.account.*;
import com.manage.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Account> accounts;

    static {
        try {
            accounts = SaveAccount.readFile("src/account.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        log();
        menu();
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
            }else if (choiceLog == 3) {
                System.out.println("Đang thoát khỏi chương trình....");
                System.exit(0);
            }
        }
    }
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
                    manageNV.read();
                }
                case 3 -> {
                    System.out.println("1. NV Fulltime!");
                    System.out.println("2. NV Parttime!");
                    int choiceNV = Integer.parseInt(sc.nextLine());
                    switch (choiceNV) {
                        case 1 -> {
                            String maNV = getMaNV(sc);
                            String tenNV = getTenNV(sc);
                            String tuoiNV = getTuoiNV(sc);
                            String phoneNV = getPhoneNV(sc);
                            String emailNV = getEmailNV(sc);
                            Boolean status = getStatus();
                            System.out.println("Nhập số tiền thưởng:");
                            double tienThuong = Double.parseDouble(sc.nextLine());
                            System.out.println("Nhập số tiền phạt:");
                            double tienPhat = Double.parseDouble(sc.nextLine());
                            System.out.println("Nhập lương cứng:");
                            double luongCung = Double.parseDouble(sc.nextLine());
                            manageNV.addNVFulltime(maNV, tenNV, tuoiNV, phoneNV, emailNV, status, tienThuong, tienPhat, luongCung);
                        }
                        case 2 -> {
                            String maNV = getMaNV(sc);
                            String tenNV = getTenNV(sc);
                            String tuoiNV = getTuoiNV(sc);
                            String phoneNV = getPhoneNV(sc);
                            String emailNV = getEmailNV(sc);
                            Boolean status = getStatus();
                            System.out.println("Nhập số giờ làm: ");
                            int soGio = Integer.parseInt(sc.nextLine());
                            manageNV.addNVParttime(maNV, tenNV, tuoiNV, phoneNV, emailNV, status, soGio);
                        }
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
                case 11 ->{
                    System.out.println("Đăng xuất.....");
                    log();
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

    private static String getEmailNV(Scanner sc) {
        System.out.println("Nhập email NV: ");
        return sc.nextLine();
    }

    private static String getPhoneNV(Scanner sc) {
        System.out.println("Nhập sđt NV: ");
        return sc.nextLine();
    }

    private static String getTuoiNV(Scanner sc) {
        System.out.println("Nhập tuổi NV: ");
        return sc.nextLine();
    }

    private static String getTenNV(Scanner sc) {
        System.out.println("Nhập tên NV: ");
        return sc.nextLine();
    }

    private static String getMaNV(Scanner sc) {
        System.out.println("Nhập mã NV: ");
        return sc.nextLine();
    }
}
