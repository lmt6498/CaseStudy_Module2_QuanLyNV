package com.manage;

public class NhanVienParttime extends NhanVien {
    private int soGioLam;

    public NhanVienParttime(String maNV, String tenNV, String tuoiNV, String phone, String email, boolean status, int soGioLam) {
        super(maNV, tenNV, tuoiNV, phone, email, status);
        this.soGioLam = soGioLam;
    }

    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }

    public double tinhLuongParttime() {
        return soGioLam * 100000;
    }

    @Override
    public String toString() {
        return "maNV=" + maNV +
                ", tenNV='" + tenNV +
                ", tuoiNV=" + tuoiNV +
                ", phone=" + phone +
                ", email='" + email +
                ", status='" + status +
                ",soGioLam=" + soGioLam +
                ",Lương=" + tinhLuongParttime() +
                '}';
    }

    public void display() {
        System.out.println("Nhân viên Parttime: " +
                "Mã nhân viên= " + maNV +
                ", Tên= " + tenNV +
                ", Tuổi= " + tuoiNV +
                ", Số điện thoại= " + phone +
                ", Địa chỉ email= " + email +
                ", Trạng thái= " + status +
                ", Số giờ làm= " + soGioLam +
                ", Lương= " + tinhLuongParttime());
    }

    public String writeNVPT() {
        return maNV + "," + tenNV + "," + tuoiNV + "," + phone + "," + email + "," + status + "," + soGioLam + "," + tinhLuongParttime();
    }
}
