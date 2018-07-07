//package com.sheng.commons.utils;
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * @author luokai
// * @date 2018/3/15
// */
//@Slf4j
//public class StringUtils {
//
//    /**
//     * 照片的url 会截取除去域名的照片地址，方便在阿里云oos中获取图片key
//     * ["http://img.souche.com/files/default/24dc4f57e24bda4c6ed771fcde7b1e5b.jpg"]
//     * http://img.souche.com/6f172c98c8f87e063373d820937dd789.jpg
//     * ["http://souche-devqa.oss-cn-hangzhou.aliyuncs.com/20180105/png/a29b3b9924784aaf6a783ea8559f3a81.png"]
//     * 都需要把前面域名去掉。files/default/24dc4f57e24bda4c6ed771fcde7b1e5b.jpg
//     * 1.取出两边的方括号
//     * 2.正则匹配
//     * 3.取出第二部分
//     *
//     * @param imgUrl
//     * @return
//     */
//    public static String getImgUrlForAliyun(String imgUrl) {
//        Pattern p_image;
//        Matcher m_image;
//        String tempUrl = imgUrl.replaceAll("\\[\"", "").replaceAll("\"]", "");
//        String regEx_img = "(https?://)?(.+\\.(jpg|gif|png))";
//        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
//        m_image = p_image.matcher(tempUrl);
//        String resultUrl = null;
//        if (m_image.find()) {
//            resultUrl = m_image.group(2);
//            resultUrl = resultUrl.substring(resultUrl.indexOf("/") + 1, resultUrl.length());
//        }
//        log.info("截取imgUrl :{},结果为 :{}", imgUrl, resultUrl);
//        return resultUrl;
//    }
//
//    /**
//     * 获取字符串中的url
//     *
//     * @param imgUrl
//     * @return
//     */
//    public static String getImgUrl(String imgUrl) {
//        Pattern p_image;
//        Matcher m_image;
//        String regEx_img = "(https?://.+\\.(jpg|gif|png))";
//        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
//        m_image = p_image.matcher(imgUrl);
//        String resultUrl = null;
//        if (m_image.find()) {
//            resultUrl = m_image.group();
//        }
//        log.info("截取imgUrl :{},结果为 :{}", imgUrl, resultUrl);
//        return resultUrl;
//    }
//}
