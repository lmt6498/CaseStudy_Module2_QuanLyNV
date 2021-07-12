package com.manage;

import com.main.Validate;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Manage {
    List<NhanVien> nhanViens = ReadWriteFileText.readFile("src/QLNV.txt");
    static Scanner sc = new Scanner(System.in);
    static SortNV sortNV = new SortNV();
    static Validate validate = new Validate();


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
            if (s.getTenNV().contains(name)) {
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

    public void addNVFulltime() throws IOException {
        String maNV = getMaNV();
        String tenNV = getTenNV();
        String tuoiNV = getTuoiNV();
        String phoneNV = getSdtNV();
        String emailNV = getEmailNV();
        boolean status = isStatusNV();
        System.out.println("Nhập số tiền thưởng:");
        double tienThuong = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập số tiền phạt:");
        double tienPhat = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập lương cứng:");
        double luongCung = Double.parseDouble(sc.nextLine());
        nhanViens.add(new NhanVienFulltime(maNV, tenNV, tuoiNV, phoneNV, emailNV, status, tienThuong, tienPhat, luongCung));
        ReadWriteFileText.writeFile("src/QLNV.txt", nhanViens);
        System.out.println("Thêm nhân viên thành công!!");
    }

    public void addNVParttime() throws IOException {
        String maNV = getMaNV();
        String tenNV = getTenNV();
        String tuoiNV = getTuoiNV();
        String phoneNV = getSdtNV();
        String emailNV = getEmailNV();
        boolean status = isStatusNV();
        System.out.println("Nhập số giờ làm: ");
        int soGio = Integer.parseInt(sc.nextLine());
        nhanViens.add(new NhanVienParttime(maNV, tenNV, tuoiNV, phoneNV, emailNV, status, soGio));
        ReadWriteFileText.writeFile("src/QLNV.txt", nhanViens);
        System.out.println("Thêm nhân viên thành công!!");
    }

    public void writeFile() throws IOException {
        ReadWriteFileText.writeFile("src/QLNV.txt", nhanViens);
    }

    public void sortNV() {
        nhanViens.sort(sortNV);
    }

    public void updateNV(String ID) throws IOException {
        for (NhanVien s : nhanViens) {
            if (s.getMaNV().equals(ID)) {
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

        while (true) {
            System.out.println("Nhập địa chỉ email:");
            String emailNV = sc.nextLine();
            boolean exist = false;
            boolean isValid = validate.validateEmail(emailNV);
            if (!isValid) {
                System.out.println("Định dạng email không hợp lệ. Vui lòng nhập lại!");
                exist = true;
            }
            if (!exist) {
                return emailNV;
            }
        }
    }

    private String getSdtNV() {
        while (true) {
            System.out.println("Nhập số điện thoại (9 số hoặc 10 số): ");
            String sdtNV = sc.nextLine();
            boolean exist = false;
            boolean isValid = validate.validatePhoneNV(sdtNV);
            if (!isValid) {
                System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại!\n" +
                        "Số điện thoại phải là số và bắt đầu bằng 0!!");
                exist = true;
            }
            if (!exist) {
                return sdtNV;
            }
        }
    }

    private String getTuoiNV() {
        while (true) {
            System.out.println("Nhập tuổi nhân viên: ");
            String tuoiNV = sc.nextLine();
            boolean exist = false;
            boolean isValid = validate.validateTuoiNV(tuoiNV);
            if (!isValid) {
                System.out.println("Tuổi nhân viên không hợp lệ. Vui lòng nhập lại!\n" +
                        "Tuổi nhân viên phải là số!!");
                exist = true;
            }
            if (!exist) {
                return tuoiNV;
            }
        }
    }

    private String getTenNV() {
        while (true) {
            System.out.println("Nhập tên nhân viên: ");
            String tenNV = sc.nextLine();
            boolean exist = false;
            boolean isValid = validate.validateNameNV(tenNV);
            if (!isValid) {
                System.out.println("Tên nhân viên không hợp lệ. Vui lòng nhập lại!\n" +
                        "Tên nhân viên chỉ có các ký tự A-Z,a-z!!!");
                exist = true;
            }
            if (!exist) {
                return tenNV;
            }
        }
    }

    private String getMaNV() {
        while (true) {
            System.out.println("Nhập mã nhân viên:(chỉ nhập số) ");
            String maNV = sc.nextLine();
            boolean exist = false;
            boolean isValid = validate.validateMaNV(maNV);
            for (NhanVien s : nhanViens) {
                if (s.getMaNV().equals(maNV)) {
                    System.out.println("Mã nhân viên đã tồn tại! Vui lòng nhập 1 ID khác!");
                    exist = true;
                }
            }
            if (!isValid) {
                System.out.println("Mã nhân viên không hợp lệ. Vui lòng nhập lại!\n" +
                        "Mã nhân viên phải là số!!");
                exist = true;
            }
            if (!exist) {
                return maNV;
            }
        }
    }
}