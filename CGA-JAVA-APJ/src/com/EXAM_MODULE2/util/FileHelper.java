package com.EXAM_MODULE2.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper <T>{
    public List<String> read(String path){
        List<String> result = new ArrayList<>();

//        createFileIfNotExists(path);
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;

            while ((line = reader.readLine()) != null) {
                if(!line.isEmpty()){
                    result.add(line);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void write(String path, List<T> products, boolean isAppend){
//        createFileIfNotExists(path);
        try(BufferedWriter write = new BufferedWriter(new FileWriter(path, isAppend))) {
            for (T p : products){
                write.write(p.toString());
                write.newLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
