package com.company;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format =new SimpleDateFormat();
        format.applyPattern("KK:mm");
        Date date=format.parse("23:12");
        System.out.println(date.getHours()+":"+date.getMinutes());
    }
}
