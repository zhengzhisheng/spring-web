package fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author zzs .
 * @since 2018/5/17
 */
public class JsonArray {

    public static void main(String[] args) {
        String aa = "[{\"uid\":\"rc-upload-1526360153544-8\",\"name\":\"图片\",\"url\":\"http://souche-devqa.oss-cn-hangzhou.aliyuncs.com/20180515/png/02f21d3b5e7b956ba65a7bdaa29b72c0.png\",\"status\":\"done\"}]";
        JSONArray jsonArray = JSON.parseArray(aa);
        for (Object o : jsonArray) {
            JSONObject jsonObject = (JSONObject) o;
            System.out.println(jsonObject.get("uid"));
        }
    }
}
