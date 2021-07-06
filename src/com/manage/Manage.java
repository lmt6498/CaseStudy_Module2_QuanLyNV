package com.manage;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Manage {
    List<NhanVien> nhanViens = ReadWriteFileText.readFile("src/QLNV.txt");
    static Scanner sc = new Scanner(System.in);
//    static SortNV sortNV = new SortNV();
    public Manage() throws IOException {
    }

    public void showStatus(Boolean status) {
        for (NhanVien s : nhanViens) {
            if (s.isStatus() == status) {
                s.display();
            }
        }
    }

    public void findByName(String name) {
        for (NhanVien s : nhanViens) {
            if (s.getTenNV().equals(name)) {
                s.display();
            }
        }
    }

    public void findStatus(String name) {
        for (NhanVien s : nhanViens) {
            if (s.getTenNV().equals(name)) {
                s.displayStatus();
            }
        }
    }

    public void showAll() {
        for (NhanVien s : nhanViens) {
            s.display();
        }
    }


    public void addNVFulltime(String maNV, String tenNV, String tuoiNV, String phone, String email, boolean status, double soTienThuong, double soTienPhat, double luongCung) throws IOException {
        nhanViens.add(new NhanVienFulltime(maNV, tenNV, tuoiNV, phone, email, status, soTienThuong, soTienPhat, luongCung));
        ReadWriteFileText.writeFile("src/QLNV.txt", nhanViens);
    }

    public void addNVParttime(String maNV, String tenNV, String tuoiNV, String phone, String email, boolean status, int soGioLam) throws IOException {
        nhanViens.add(new NhanVienParttime(maNV, tenNV, tuoiNV, phone, email, status, soGioLam));
        ReadWriteFileText.writeFile("src/QLNV.txt", nhanViens);
    }

    public void read() throws IOException {
        nhanViens = ReadWriteFileText.readFile("src/QLNV.txt");
        showAll();
    }

    public void updateNV(String name) throws IOException {
        for (NhanVien s : nhanViens) {
            if (s.getMaNV().equals(name)) {
                String maNV = getMaNV();
                String tenNV = getTenNV();
                String tuoiNV = getTuoiNV();
                String sdtNV = getSdtNV();
                String emailNV = getEmailNV();
                boolean statusNV = isStatusNV();
                s.setMaNV(maNV);
                s.setTenNV(tenNV);
                s.setTuoiNV(tuoiNV);
                s.setPhone(sdtNV);
                s.setEmail(emailNV);
                s.setStatus(statusNV);
                if (s instanceof NhanVienFulltime) {
                    System.out.println("Nhập số tiền thưởng:");
                    double tienThuong = Double.parseDouble(sc.nextLine());
                    System.out.println("Nhập số tiền phạt:");
                    double tienPhat = Double.parseDouble(sc.nextLine());
                    System.out.println("Nhập lương cứng:");
                    double luongCung = Double.parseDouble(sc.nextLine());
                    ((NhanVienFulltime) s).setSoTienThuong(tienThuong);
                    ((NhanVienFulltime) s).setSoTienPhat(tienPhat);
                    ((NhanVienFulltime) s).setLuongCung(luongCung);
                    ReadWriteFileText.writeFile("src/QLNV.txt", nhanViens);
                } else if (s instanceof NhanVienParttime) {
                    System.out.println("Nhập số giờ làm: ");
                    int soGio = Integer.parseInt(sc.nextLine());
                    ((NhanVienParttime) s).setSoGioLam(soGio);
                    ReadWriteFileText.writeFile("src/QLNV.txt", nhanViens);
                }
            }
        }
    }

    public void deleteNV() throws IOException {
        System.out.println("Nhập ID nhân viên cần xóa: ");
        String idNV = sc.nextLine();
        nhanViens.removeIf(x -> x.getMaNV().equals(idNV));
        ReadWriteFileText.writeFile("src/QLNV.txt", nhanViens);
    }

    public void updateStatusNV(String name) throws IOException {
        for (NhanVien s : nhanViens) {
            if (s.getMaNV().equals(name)) {
                if (s instanceof NhanVienFulltime) {
                    boolean statusNV = isStatusNV();
                    s.setStatus(statusNV);
                    ReadWriteFileText.writeFile("src/QLNV.txt", nhanViens);
                } else if (s instanceof NhanVienParttime) {
                    boolean statusNV = isStatusNV();
                    s.setStatus(statusNV);
                    ReadWriteFileText.writeFile("src/QLNV.txt", nhanViens);
                }
            }
        }
    }

    private boolean isStatusNV() {
        System.out.println("Nhập trạng thái:");
        return Boolean.parseBoolean(sc.nextLine());
    }

    private String getEmailNV() {
        System.out.println("Nhập địa chỉ:");
        return sc.nextLine();
    }

    private String getSdtNV() {
        System.out.println("Nhập giới tính:");
        return sc.nextLine();
    }

    private String getTuoiNV() {
        System.out.println("Nhập tuổi:");
        return sc.nextLine();
    }

    private String getTenNV() {
        System.out.println("Nhập tên nhân viên");
        return sc.nextLine();
    }

    private String getMaNV() {
        System.out.println("Nhập mã nhân viên: ");
        return sc.nextLine();
    }
}