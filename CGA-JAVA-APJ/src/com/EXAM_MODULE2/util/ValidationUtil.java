package com.EXAM_MODULE2.util;

import com.EXAM_MODULE2.model.Account;
import com.EXAM_MODULE2.service.BankingService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    private static final String NUMBER_REG = "^\\d+$";
    private static final String DOUBLE_REG = "^\\d+(\\.\\d+)?$";
    private static final String DATE_REG="^\\d{1,2}\\/\\d{1,2}\\/\\d{1,4}$";
    private static BankingService bankingService=new BankingService();
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isNumber(String val){
        pattern = Pattern.compile(NUMBER_REG);
        matcher = pattern.matcher(val);
        return matcher.matches();
    }
    public static boolean isDouble(String val){
        pattern = Pattern.compile(DOUBLE_REG);
        matcher = pattern.matcher(val);
        return matcher.matches();
    }
    public static boolean isDate(String val){
        pattern = Pattern.compile(DATE_REG);
        matcher = pattern.matcher(val);
        return matcher.matches();
    }
    public static boolean isExistsId(int id,List<Account> list){
        return list.stream().anyMatch(e->e.getId() == id);
    }
    public static boolean checkValidDate(String dateString){
        if(!isDate(dateString)){
            return false;
        }
        else {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....
            try {
                df.parse(dateString); // parse dateString thành kiểu Date
                return true;
            }
            catch (ParseException e) { // quăng lỗi nếu dateString ko hợp lệ
                return false;
            }
        }
    }
}
