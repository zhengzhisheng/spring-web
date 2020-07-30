package test;

import com.xkzhangsan.time.calculator.DateTimeCalculatorUtil;
import com.xkzhangsan.time.converter.DateTimeConverterUtil;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


/**
 * @author zs
 * @date 2020/7/8 10:20 上午
 */
public class AgeByBirthday {
    public static int getAgeByBirth(Date birthday) {
        //Calendar：日历
        /*从Calendar对象中或得一个Date对象*/
        Calendar cal = Calendar.getInstance();
        /*把出生日期放入Calendar类型的bir对象中，进行Calendar和Date类型进行转换*/
        Calendar bir = Calendar.getInstance();
        bir.setTime(birthday);
        /*如果生日大于当前日期，则抛出异常：出生日期不能大于当前日期*/
        if (cal.before(bir)) {
            throw new IllegalArgumentException("The birthday is before Now,It's unbelievable");
        }
        /*取出当前年月日*/
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayNow = cal.get(Calendar.DAY_OF_MONTH);
        /*取出出生年月日*/
        int yearBirth = bir.get(Calendar.YEAR);
        int monthBirth = bir.get(Calendar.MONTH);
        int dayBirth = bir.get(Calendar.DAY_OF_MONTH);
        /*大概年龄是当前年减去出生年*/
        int age = yearNow - yearBirth;
        int month = monthNow - monthBirth;
        int day = dayNow - dayBirth;
        /*如果出当前月小与出生月，或者当前月等于出生月但是当前日小于出生日，那么年龄age就减一岁*/
        if (monthNow < monthBirth || (monthNow == monthBirth && dayNow < dayBirth)) {
            age--;
        }
        return age;
    }

    public static void main(String[] args) {
//        SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd");
//        String sftBirth = "1980-4-25";
//        Date date = null;
//        try{
//            date = sft.parse(sftBirth);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        int age = AgeByBirthday.getAgeByBirth(date);
//        System.out.print("年龄：" + age + "岁");
//        Date date = DateTimeCalculatorUtil.getDate(2012, 6, 7);
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(AgeByBirthday.getAge(localDateTime));
        System.out.println(Math.abs(11));
    }

    /**
     * 计算年龄
     *
     * @param birthDay
     * @return int 年龄
     */
    public static int getAge(LocalDate birthDay) {
        Objects.requireNonNull(birthDay, "birthDay");
        Period period = Period.between(birthDay, LocalDate.now());
        int age = 0;
        if (period.getYears() < 0) {
            throw new DateTimeException("birthDay is before now!");
        } else if (period.getYears() == 0) {
            if (period.getMonths()==0) {
                if (period.getDays()<30) {
                    System.out.println(period.getDays()+"天");
                    age =  period.getDays();
                }
            } else {
                System.out.println(period.getMonths()+"个月");
                age =  period.getMonths();
            }
        } else if (period.getYears() < 6){
            System.out.println(period.getYears() + "岁" + period.getMonths()+"个月");
            age = period.getYears();
        } else {
            System.out.println(period.getYears() + "岁");
            age = period.getYears();
        }
        return age;
    }


    /**
     * 计算年龄
     *
     * @param birthDay
     * @return int 年龄
     */
    public static int getAge(Date birthDay) {
        return getAge(DateTimeConverterUtil.toLocalDate(birthDay));
    }

    /**
     * 计算年龄
     *
     * @param birthDay
     * @return int 年龄
     */
    public static int getAge(LocalDateTime birthDay) {
        return getAge(DateTimeConverterUtil.toLocalDate(birthDay));
    }

}
