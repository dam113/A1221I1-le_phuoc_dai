package com.EXAM_MODULE2.util;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CommonUtil {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
    public static DateTimeFormatter getDateFormat() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
}
