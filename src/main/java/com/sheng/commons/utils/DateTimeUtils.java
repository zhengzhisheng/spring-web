//package com.sheng.commons.utils;
//
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
///**
// * @author zzs .
// * @since 2017/11/9
// */
//public class DateTimeUtils {
//
//    public static final String PATTERN_DEFAULT = "yyyy-MM-dd HH:mm:ss";
//    public static final String PATTERN_DAY = "yyyy-MM-dd";
//    public static final String PATTERN_COMPACT = "yyyyMMdd";
//
//    public static SimpleDateFormat formatDisplayDate = new SimpleDateFormat("M月d号");
//    public static SimpleDateFormat formatDisplayTimeA = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//
//    public static Date today() {
//        return new Date();
//    }
//
//    public static String now() {
//        return formatDate(today());
//    }
//
//    public static String formatDate(Date date) {
//        return formatDate(date, PATTERN_DEFAULT);
//    }
//
//    public static String formatDate(Date date, String pattern) {
//        if (date == null) {
//            throw new IllegalArgumentException("date is null");
//        }
//        if (pattern == null) {
//            throw new IllegalArgumentException("pattern is null");
//        }
//        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
//        return formatter.format(date);
//    }
//
//    //计算两个时间相差的天数，按天计算，同一天则天数为0
//    public static int getDateDiff(Date date1, Date date2) {
//        if (ObjectUtils.isEmpty(date1) || ObjectUtils.isEmpty(date2)) {
//            return 0;
//        }
//        Calendar cal1 = Calendar.getInstance();
//        cal1.setTime(date1);
//
//        Calendar cal2 = Calendar.getInstance();
//        cal2.setTime(date2);
//        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
//        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
//
//        int year1 = cal1.get(Calendar.YEAR);
//        int year2 = cal2.get(Calendar.YEAR);
//        if (year1 != year2)   //不同一年
//        {
//            int timeDistance = 0;
//            for (int i = year1; i < year2; i++) {
//                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //闰年
//                {
//                    timeDistance += 366;
//                } else    //不是闰年
//                {
//                    timeDistance += 365;
//                }
//            }
//
//            return timeDistance + (day2 - day1);
//        } else    //同年
//        {
//            return day2 - day1;
//        }
//    }
//
//    /**
//     * date2比date1多的天数，同一天也算一天
//     *
//     * @param date1
//     * @param date2
//     * @return
//     */
////    public static int differentDays(Date date1, Date date2) {
////        if (ObjectUtils.isEmpty(date1) || ObjectUtils.isEmpty(date2)) {
////            return 0;
////        }
////        Calendar cal1 = Calendar.getInstance();
////        cal1.setTime(date1);
////
////        Calendar cal2 = Calendar.getInstance();
////        cal2.setTime(date2);
////        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
////        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
////
////        int year1 = cal1.get(Calendar.YEAR);
////        int year2 = cal2.get(Calendar.YEAR);
////        if (year1 != year2)   //不同一年
////        {
////            int timeDistance = 0;
////            for (int i = year1; i < year2; i++) {
////                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //闰年
////                {
////                    timeDistance += 366;
////                } else    //不是闰年
////                {
////                    timeDistance += 365;
////                }
////            }
////
////            return timeDistance + (day2 - day1);
////        } else    //同年
////        {
////            if ((day2 - day1) == 0) {
////                return 1;
////            } else {
////                return day2 - day1;
////            }
////        }
////    }
//
//    /**
//     * date1大于date2返回true，否则返回false
//     * @param date1
//     * @param date2
//     * @return
//     */
//    public static boolean compareDate(Date date1,Date date2){
//        if (date1.getTime() > date2.getTime()) {
//            return true;
//        } else if (date1.getTime() < date2.getTime()) {
//            System.out.println("dt1在dt2后");
//            return false;
//        }
//        return false;
//    }
//}
