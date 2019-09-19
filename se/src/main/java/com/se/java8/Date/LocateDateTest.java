package com.se.java8.Date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LocateDateTest {

    /**
     * 当前日期格式化
     */
    @Test
    public void LocateDateDemo1(){
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy")));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("MM")));
        String mm = LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
        System.out.println(mm.compareTo("12"));
        String[] test = {"04","03","09","07","12"};
        Arrays.sort(test, String::compareTo);
        System.out.println(Arrays.toString(test));
        String halfYear = "";
        if("07".compareTo(mm) > 0){
            halfYear = "FIRST_HALF";
        }else{
            halfYear = "SECOND_HALF";
        }
        System.out.println(halfYear);
    }

}
