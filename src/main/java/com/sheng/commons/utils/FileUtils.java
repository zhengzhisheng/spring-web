//package com.sheng.commons.utils;
//
//
//import lombok.extern.slf4j.Slf4j;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipOutputStream;
//
//@Slf4j
//public class FileUtils {
//
//    /**
//     * 删除文件夹下面的所有文件
//     *
//     * @param filePath
//     */
//    public static void deleteDirectory(String filePath) {
//        File file = new File(filePath);
//        if (!file.exists()) {
//            return;
//        }
//
//        if (file.isFile()) {
//            file.delete();
//        } else if (file.isDirectory()) {
//            File[] files = file.listFiles();
//            for (File myFile : files) {
//                deleteDirectory(filePath + "/" + myFile.getName());
//            }
//
//            file.delete();
//        }
//    }
//
//
//    //—------------——————-ZIP包操作--------------------------—
//    /**
//     * @param srcFiles 根目录，会遍历file文件下所有的文件
//     * @param fileName 下载后的文件名字
//     * @param response HttpServletResponse
//     */
//    public static void downloadZipFile(File[] srcFiles, String fileName, HttpServletResponse response) {
//        ZipOutputStream zipOutputStream = null;
//        OutputStream outputStream = null;
//        try {
//            outputStream = new BufferedOutputStream(response.getOutputStream());
//            response.setContentType("application/octet-stream");
//            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
//            zipOutputStream = new ZipOutputStream(outputStream);
//            toZipFiles(zipOutputStream, fileName, srcFiles);
//            zipOutputStream.close();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            if (zipOutputStream != null) {
//                try {
//                    zipOutputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            try {
//                outputStream.flush();
//                outputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
//    /**
//     * 递归调用，压缩文件夹下的问价
//     *
//     * @param out
//     * @param path
//     * @param srcFiles
//     */
//    public static void toZipFiles(ZipOutputStream out, String path, File[] srcFiles) {
//        path = path.replaceAll("\\*", "/");
//        if (!path.endsWith("/")) {
//            path += "/";
//        }
//        byte[] buf = new byte[1024];
//        try {
//            for (int i = 0; i < srcFiles.length; i++) {
//                if (srcFiles[i].isDirectory()) {
//                    File[] files = srcFiles[i].listFiles();
//                    String srcPath = srcFiles[i].getName();
//                    srcPath = srcPath.replaceAll("\\*", "/");
//                    if (!srcPath.endsWith("/")) {
//                        srcPath += "/";
//                    }
//                    out.putNextEntry(new ZipEntry(path + srcPath));
//                    toZipFiles(out, path + srcPath, files);
//                } else {
//                    FileInputStream in = new FileInputStream(srcFiles[i]);
//                    out.putNextEntry(new ZipEntry(path + srcFiles[i].getName()));
//                    int len;
//                    while ((len = in.read(buf)) > 0) {
//                        out.write(buf, 0, len);
//                    }
//                    out.closeEntry();
//                    in.close();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}