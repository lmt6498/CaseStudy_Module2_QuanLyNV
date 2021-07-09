package com.manage;

import java.util.Comparator;

public class SortNV implements Comparator<NhanVien> {

    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        if (Integer.parseInt(o1.getMaNV()) > Integer.parseInt(o2.getMaNV())){
            return 1;
        }else return -1;
    }
}
