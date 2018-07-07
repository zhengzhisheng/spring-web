//package com.sheng.commons.utils;
//
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
///**
// * @author luokai
// * @date 2018/3/20
// */
//public class ImageUtils {
//
//
//    public static void download(File file, String imgUrl) {
//        DataOutputStream out = null;
//        DataInputStream in = null;
//        HttpURLConnection connection = null;
//        try {
//            URL url = new URL(imgUrl);/*将网络资源地址传给,即赋值给url*/
//            /*此为联系获得网络资源的固定格式用法，以便后面的in变量获得url截取网络资源的输入流*/
//            connection = (HttpURLConnection) url.openConnection();
//
//            in = new DataInputStream(connection.getInputStream());
//            /*此处也可用BufferedInputStream与BufferedOutputStream*/
//            out = new DataOutputStream(new FileOutputStream(file));
//            /*将参数savePath，即将截取的图片的存储在本地地址赋值给out输出流所指定的地址*/
//            byte[] buffer = new byte[4096];
//            int count = 0;
//            /*将输入流以字节的形式读取并写入buffer中*/
//            while ((count = in.read(buffer)) > 0) {
//                out.write(buffer, 0, count);
//            }
//
//            //返回内容是保存后的完整的URL
//            //return PATH+UPLOAD_PATH+fileName;/*网络资源截取并存储本地成功返回true*/
//        } catch (Exception e) {
//            //System.out.println(e + fileUrl + savePath);
//        } finally {
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            connection.disconnect();
//        }
//    }
//
//    /**
//     * 从阿里云下载图片
//     * 有三种不同类型的图片
//     * <p>
//     * 不同的域名 bucketName不同，souche-devqa.oss-cn-hangzhou.aliyuncs.com为devqa
//     *
//     * @param parentFile 父文件
//     * @param imgUrl     文件地址
//     * @param imgTitle   图片在父文件的名字
//     * @param bucketName 图片在阿里云的bucket
//     */
//    public static void createImg(File parentFile, String imgUrl, String imgTitle, String bucketName) {
//        if (org.apache.commons.lang3.StringUtils.isBlank(imgUrl)) {
//            log.info("图片打包Url: {}为空!", imgUrl);
//            return;
//        }
//        imgUrl = StringUtils.getImgUrl(imgUrl);
//        if (imgUrl == null) {
//            log.info("图片打包Url: {}解析失败!", imgUrl);
//            return;
//        }
//        //给图片加上后缀名
//        if (imgTitle.indexOf(".") == -1) {
//
//            imgTitle += imgUrl.substring(imgUrl.lastIndexOf("."), imgUrl.length());
//        }
//        File file = new File(parentFile, imgTitle);
//        ImageUtils.download(file, imgUrl);
//    }
//
//}
