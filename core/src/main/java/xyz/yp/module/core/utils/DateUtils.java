package xyz.yp.module.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
    public final static DateFormat YYYY_MM_DD_MM_HH_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final static DateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");
    public final static DateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
    public final static DateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
    public final static DateFormat YYYY_MM_DD_CHINESE = new SimpleDateFormat("yyyy年MM月dd日");

    public static String getNow() {
        return getNow(YYYY_MM_DD_MM_HH_SS);
    }

    public static String getNow(DateFormat format) {
        return date2string(new Date(), format);
    }

    public static Date string2date(String source) {
        return string2date(source, YYYY_MM_DD_MM_HH_SS);
    }

    public static Date string2date(String source, DateFormat format) {
        try {
            return format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String date2string(Date date, DateFormat format) {
        return format.format(date);
    }

    /**
     * 将时间戳转换为日期
     * @param timestamp
     * @return
     */
    public static Date timestamp2date(long timestamp){
        Date date = new Date(timestamp);
        return date;
    }

    public static long date2timestamp(Date date){
        if (date == null) {
            return 0L;
        }
        if (String.valueOf(date.getTime()).length() > 10) {
            return date.getTime() / 1000;
        }
        return date.getTime();
    }

    /**
     * 当前日期增加或减少天数
     * @param days
     * @return
     */
    public static Date addDays(int days) {
        return addDays(new Date(), days);
    }

    /**
     * 指定日期增加或减少天数
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, days);// 把日期往后增加一天.整数往后推,负数往前移动
        return calendar.getTime();
    }

}
