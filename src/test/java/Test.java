import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.gson.*;
import sun.jvm.hotspot.utilities.Interval;

import java.lang.reflect.Type;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

/**
 * 测试
 * <p>
 * Created by zhengzs on 2017/10/9.
 */
public class Test {

    public int[][] merge(int[][] intervals) {
        // if smaller just return
        if(intervals.length <= 1){
            return intervals;
        }
        // sort each arr base on the left element
        Arrays.sort(intervals, (arr1, arr2)->Integer.compare(arr1[0], arr2[0]));
        // create a temp arry
        int[] curr_interval = intervals[0];
        // create the output array with unknow size
        List<int[]> res_arr = new ArrayList();
        // add the first interval
        res_arr.add(curr_interval);

        // loop through each interval
        for(int[] interval: intervals){
            // create curr interval begin, end
            int curr_begin = curr_interval[0];
            int curr_end = curr_interval[1];
            // create next interval begin, end
            int next_begin = interval[0];
            int next_end = interval[1];
            // check overlap
            if(curr_end >= next_begin){
                // set the bigger end
                curr_interval[1] = Math.max(curr_end, next_end);
            }
            else{
                // iterate curr_interval
                curr_interval = interval;
                // add the valid interval to res
                res_arr.add(curr_interval);
            }
        }

        return res_arr.toArray(new int[res_arr.size()][]);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(4%3);
    }

    public static class ClassTypeAdapter implements JsonSerializer<Class<?>>, JsonDeserializer<Class<?>> {

        @Override
        public JsonElement serialize(Class<?> src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.getName());
        }

        @Override
        public Class<?> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            try {
                return Class.forName(json.getAsString());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
