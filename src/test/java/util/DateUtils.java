package util;

import cn.hutool.core.date.DateUtil;
import com.beust.jcommander.internal.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author yiyao
 * @date 2022/2/15 2:04 下午
 */
public class DateUtils {

    public static void main(String[] args) {
        String[] methodParams = "111,1".split(",");
        System.out.println();
        System.out.println(null != methodParams && methodParams.length>=2&&StringUtils.isNotEmpty(methodParams[1]));

        List<Integer> stringList = new ArrayList<>();
        stringList.add(1);
        stringList.add(3);
        List<Integer> stringList1 =  new ArrayList<Integer>(1);
        stringList1.add(2);
        stringList1.add(3);
        stringList1.retainAll(stringList);
        System.out.println("交集1: " + stringList1);

        List<Integer> list = Lists.newArrayList();
        list.add(-1);
        System.out.println(list.contains(-1));
    }
}
