package com.manage;

public class NhanVien {
    protected String maNV;
    protected String tenNV;
    protected String tuoiNV;
    protected String phone;
    protected String email;
    protected boolean status;

    public NhanVien() {

    }

    public NhanVien(String maNV, String tenNV, String tuoiNV, String phone, String email, boolean status) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.tuoiNV = tuoiNV;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setTuoiNV(String tuoiNV) {
        this.tuoiNV = tuoiNV;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV=" + maNV +
                ", tenNV='" + tenNV +
                ", tuoiNV=" + tuoiNV +
                ", phone=" + phone +
                ", email='" + email +
                ", status='" + status +
                '}';
    }

    public void display() {
        System.out.println("NhanVien{" +
                "maNV=" + maNV +
                ", tenNV='" + tenNV +
                ", tuoiNV=" + tuoiNV +
                ", phone=" + phone +
                ", email='" + email +
                ", status='" + status +
                '}');
    }

    public void displayStatus() {
        System.out.println("Tên nhân viên: " + tenNV + ", Trạng thái = " + status);
    }
}
