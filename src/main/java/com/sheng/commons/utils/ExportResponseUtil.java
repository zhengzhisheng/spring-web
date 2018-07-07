//package com.sheng.commons.utils;
//
//import com.google.common.io.Files;
//import org.apache.poi.ss.usermodel.Workbook;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.UnsupportedEncodingException;
//
///**
// * Create by huangbingshen on 2017/11/14
// */
//public final class ExportResponseUtil {
//    private ExportResponseUtil() {
//    }
//
//    public static void doExportResponse(HttpServletResponse response, File file) {
//        response.setContentType("application/octet-stream;charset=utf-8");
//        try {
//            response.setHeader("Content-disposition", "attachment;filename=" + new String(file.getName().getBytes(),"iso-8859-1"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        OutputStream outputStream;
//        try {
//            outputStream = response.getOutputStream();
//            outputStream.write(Files.toByteArray(file));
//            outputStream.flush();
//            outputStream.close();
//            return;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void doExportNothing(HttpServletResponse response, String content) {
//        try {
//            response.setContentType("text/plain; charset=UTF-8");
//            response.getWriter().write(content);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void doExportResponse(HttpServletResponse response, File file,String fileName) {
//        response.setContentType("application/octet-stream;charset=utf-8");
//        try {
//            response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(),"iso-8859-1"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        OutputStream outputStream;
//        try {
//            outputStream = response.getOutputStream();
//            outputStream.write(Files.toByteArray(file));
//            outputStream.flush();
//            outputStream.close();
//            return;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static File createFile(Workbook workbook, String fileName) {
//        FileOutputStream fileOS = null;
//        File file = null;
//        try {
//            file = new File(fileName);
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            fileOS = new FileOutputStream(file);
//            workbook.write(fileOS);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                workbook.close();
//                fileOS.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return file;
//    }
//}
