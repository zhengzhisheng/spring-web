//package com.sheng.commons.utils;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.time.DateUtils;
//import org.apache.poi.ss.usermodel.Cell;
//
//import java.math.BigDecimal;
//import java.text.ParseException;
//import java.util.Date;
//
//import static org.apache.commons.lang3.StringUtils.isNotBlank;
//
///**
// * Created by ningbing on 2018/4/17.
// */
//public class ExcelUtil {
//
//    /**
//     * 获取表格中的数据, 根据指定的数据类型处理处理数据
//     * 当指定为Long.class且 money=true 时, 获取到的值默认乘100, 转为分.
//     */
//    @SuppressWarnings("unchecked")
//    //TODO 获取数据异常时抛异常
//    public static <T> T checkCell(Cell cell, Class<T> tClass, boolean... moneyFlags) throws ParseException {
//        boolean money = false;
//        if (cell == null) {
//            return null;
//        }
//        if (moneyFlags != null && moneyFlags.length > 0) {
//            money = moneyFlags[0];
//        }
//        if (String.class == tClass) {
//            String value = cell.getStringCellValue().trim();
//            if (isNotBlank(value))
//                return (T) value;
//        } else if (Integer.class == tClass) {
//            String value = cell.getStringCellValue().trim();
//            if (StringUtils.isNumeric(value)) {
//                return (T) Integer.valueOf(value);
//            }
//        } else if (Long.class == tClass) {
//            String value = cell.getStringCellValue().trim();
//            if (isNotBlank(value)) {
//                value = value.replace(",", "")
//                        .replaceAll("[^\\d.]", "");
//                BigDecimal bigDecimal = new BigDecimal(value);
//                if (money) {
//                    return (T) Long.valueOf(bigDecimal.multiply(new BigDecimal("100")).longValue());
//                } else {
//                    return (T) Long.valueOf(bigDecimal.longValue());
//                }
//            }
//        } else if (Double.class == tClass) {
//            return (T) Double.valueOf(cell.getNumericCellValue() * 100);
//        } else if (Date.class == tClass) {
//            String value = cell.getStringCellValue().trim();
//            if (isNotBlank(value)) {
//                return (T) DateUtils.parseDate(value, "yyyyMMdd");
//            }
//        }
//        return null;
//    }
//
//}
