import org.apache.commons.lang3.StringUtils;

/**
 * q
 *
 * @author zhengzhisheng .
 * @since 2017/10/16
 */
public class aa {

    public static void main(String[] args) {
        if (StringUtils.isEmpty("1")) {
            System.out.println("aa");
        }
        System.out.println("bb");
    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr){

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

}
