package com.manage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileText {
    public static void writeFile(String path, List<NhanVien> products) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(path);
            bufferedWriter = new BufferedWriter(fileWriter);
            String str = "ID,Name, Age, Phone, Email";
            bufferedWriter.write(str);
            for (NhanVien s : products) {
                bufferedWriter.newLine();
                if (s instanceof NhanVienFulltime) {
                    bufferedWriter.write(((NhanVienFulltime) s).writeNVFT());
                } else if (s instanceof NhanVienParttime) {
                    bufferedWriter.write(((NhanVienParttime) s).writeNVPT());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert bufferedWriter != null;
            bufferedWriter.close();
        }
    }

    public static List<NhanVien> readFile(String path) throws IOException {
        BufferedReader bufferedReader = null;
        List<NhanVien> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(",");
                if (str.length > 8) {
                    list.add(new NhanVienFulltime(str[0], str[1], str[2], str[3], str[4], Boolean.parseBoolean(str[5]), Double.parseDouble(str[6]), Double.parseDouble(str[7]), Double.parseDouble(str[8])));
                } else if (str.length >= 6) {
                    list.add(new NhanVienParttime(str[0], str[1], str[2], str[3], str[4], Boolean.parseBoolean(str[5]), Integer.parseInt(str[6])));
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            assert bufferedReader != null;
            bufferedReader.close();
        }

        return list;
    }
}
