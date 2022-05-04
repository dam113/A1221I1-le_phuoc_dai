package com.ss16_IO_Text_File.bai_tap;

import java.io.*;

public class CopyFile {
    private static final String path = "src/com/ss16_IO_Text_File/data/";
    public static void main(String[] args) {
        copyFile(path, "source", path, "target");
        System.out.println("Nội dung đã được copy");
    }

    public static void copyFile(String path1, String source1, String path2, String source2){
        try {
            File file1 = new File(path1 + source1);
            File file2 = new File(path2 + source2);
            if (!file1.exists()){
                throw new FileNotFoundException("File copy không tồn tại!");
            }
            if (!file2.exists()){
                throw new FileNotFoundException("File paste không tồn tại!");
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
            String line = "";
            while (((line = bufferedReader.readLine()) != null)){
                bufferedWriter.write(line + "\n");
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
