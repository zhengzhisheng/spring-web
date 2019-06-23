import com.alibaba.fastjson.JSON;

/**
 * 测试
 * <p>
 * Created by zhengzs on 2017/10/9.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ResponseResult responseResult = new ResponseResult();
        responseResult = JSON.parseObject("\"isPushMsg\": 1",ResponseResult.class);

        System.out.println(responseResult);
    }
}
