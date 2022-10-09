package com.TCU.Commons;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DistanceTime {

    public static int getDistanceTime(String StartTime, String EndTime) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date one;
        Date two;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {
            one = df.parse(StartTime);
            two = df.parse(EndTime);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Math.toIntExact(min);
    }

    public String Returnacdmy(String Department) {
        if (Department.equals("01")) {
            return "建筑学院";
        }if (Department.equals("02")) {
            return  "土木工程学院";
        }if (Department.equals("03")){
            return  "能源与安全工程学院";
        }if (Department.equals("04")) {
            return  "材料科学与工程学院";
        }if (Department.equals("05")) {
            return  "经济与管理学院";
        }if (Department.equals("06")) {
            return  "环境与市政工程学院";
        }if (Department.equals("07")) {
            return  "计算机与信息工程学院";
        }if (Department.equals("08")) {
            return  "城市艺术学院";
        }if (Department.equals("09")) {
            return "外国语学院";
        }if (Department.equals("10")) {
            return  "理学院";
        }if (Department.equals("21")) {
            return  "地质与测绘学院";
        }if (Department.equals("22")) {
            return "控制与机械工程学院";
        }if (Department.equals("28")) {
            return  "国际工程学院";
        }if (Department.equals("24")) {
            return  "国际教育学院";
        }

        return "预科生";
    }
    public String Returnacdmyy(String Department) {
        if (Department.equals("101")) {
            return "建筑学院";
        }if (Department.equals("102")) {
            return  "土木工程学院";
        }if (Department.equals("103")){
            return  "能源与安全工程学院";
        }if (Department.equals("104")) {
            return  "材料科学与工程学院";
        }if (Department.equals("105")) {
            return  "经济与管理学院";
        }if (Department.equals("106")) {
            return  "环境与市政工程学院";
        }if (Department.equals("107")) {
            return  "计算机与信息工程学院";
        }if (Department.equals("108")) {
            return  "城市艺术学院";
        }if (Department.equals("109")) {
            return "外国语学院";
        }if (Department.equals("110")) {
            return  "理学院";
        }if (Department.equals("121")) {
            return  "地质与测绘学院";
        }if (Department.equals("122")) {
            return "控制与机械工程学院";
        }if (Department.equals("128")) {
            return  "国际工程学院";
        }if (Department.equals("124")) {
            return  "国际教育学院";
        }

        return "";
    }
}
