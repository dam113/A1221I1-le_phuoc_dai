package com.ss16_IO_Text_File.bai_tap;

import java.io.*;
import java.util.ArrayList;

public class ReaderFile {
    private static final String path = "src/com/ss16_IO_Text_File/data/";
    private static ArrayList<String> arrayLists = new ArrayList<>();
    public static void main(String[] args) {
        readerFile(path,"file");
    }
    public static void readerFile(String path, String source){
        try {
            FileReader fileReader = new FileReader(path + source);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                arrayLists.add(line);
            }
            for (String arraylist : arrayLists) {
                String[] arr = arraylist.split(",");
                System.out.println("ID:" +  arr[0]);
                System.out.println("Code:" +  arr[1]);
                System.out.println("name:" +  arr[2]);
                System.out.println();
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
