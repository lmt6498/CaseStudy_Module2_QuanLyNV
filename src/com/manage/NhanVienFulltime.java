package com.manage;

public class NhanVienFulltime extends NhanVien {
    private double soTienThuong;
    private double soTienPhat;
    private double luongCung;

    public NhanVienFulltime(String maNV, String tenNV, String tuoiNV, String phone, String email, boolean status, double soTienThuong, double soTienPhat, double luongCung) {
        super(maNV, tenNV, tuoiNV, phone, email, status);
        this.soTienThuong = soTienThuong;
        this.soTienPhat = soTienPhat;
        this.luongCung = luongCung;
    }

    public void setSoTienThuong(double soTienThuong) {
        this.soTienThuong = soTienThuong;
    }

    public void setSoTienPhat(double soTienPhat) {
        this.soTienPhat = soTienPhat;
    }

    public void setLuongCung(double luongCung) {
        this.luongCung = luongCung;
    }

    public double tinhLuongFulltime() {
        return luongCung + (soTienThuong - soTienPhat);
    }

    @Override
    public String toString() {
        return "NhanVienFulltime{" +
                "maNV=" + maNV +
                ", tenNV= " + tenNV +
                ", tuoiNV=" + tuoiNV +
                ", phone=" + phone +
                ", email= " + email +
                ", status= " + status +
                "soTienThuong=" + soTienThuong +
                ", soTienPhat=" + soTienPhat +
                ", luongCung=" + luongCung +
                ", Lương=" + tinhLuongFulltime() +
                '}';
    }

    public void display() {
        System.out.println("Nhân viên Fulltime: " +
                "Mã nhân viên= " + maNV +
                ", Tên= " + tenNV +
                ", Tuổi= " + tuoiNV +
                ", Số điện thoại= " + phone +
                ", Địa chỉ email= " + email +
                ", Trạng thái= " + status +
                ", Số tiền thưởng= " + soTienThuong +
                ", Số tiền phạt= " + soTienPhat +
                ", Lương cứng= " + luongCung +
                ", Tổng lương= " + tinhLuongFulltime());
    }

    public String writeNVFT() {
        return maNV + "," + tenNV + "," + tuoiNV + "," + phone + "," + email + "," + status + "," + soTienThuong + "," + soTienPhat + "," + luongCung + "," + tinhLuongFulltime();
    }
}
