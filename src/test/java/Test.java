import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 * <p>
 * Created by zhengzs on 2017/10/9.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        try{
            List aa = new ArrayList();
            aa.subList(1,3);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        System.out.println("b");
    }
}
