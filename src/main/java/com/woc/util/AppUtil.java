package com.woc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class AppUtil {

    public static int getRandomNumber(){
        int i = new Random().nextInt(1000000);
        return Math.abs(i);
    }

    public static Date convertDate(String dateStr){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
