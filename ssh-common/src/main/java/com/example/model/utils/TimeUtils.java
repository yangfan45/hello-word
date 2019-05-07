package com.example.model.utils;

import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author yangfan
 * @date 2019/4/30
 * @describe 时间工具类
 */
public class TimeUtils {
    /**
     * @describe DEFAULT_DATE_FORMAT = yyyy-MM-dd
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    /**
     * @describe DEFAULT_DATETIME_FORMAT = yyyy-MM-dd HH:mm:ss
     */
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * @describe LocalDateTime 转换为 LocalDateTimeString  默认格式为 DEFAULT_DATETIME_FORMAT
     *
     * @param dateTime 时间
     */
    public static String toDateTimeString (LocalDateTime dateTime) {

        return toDateTimeString(dateTime,DEFAULT_DATETIME_FORMAT);
    }

    /**
     * @describe LocalDateTime 转换为 LocalDateTimeString
     *
     * @param dateTime 时间
     * @param pattern 格式化字符串
     */
    public static String toDateTimeString (LocalDateTime dateTime, String pattern) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                StringUtils.isEmpty(pattern) ? DEFAULT_DATETIME_FORMAT : pattern);

        return dateTime == null ? null : dateTime.format(formatter);
    }

    /**
     * @describe LocalDateTime 转换为 LocalDateTimeString
     *
     * @param dateTimeStr 时间字符串
     */
    public static LocalDateTime toLocalDateTime (String dateTimeStr) {

        /**
         *  ISO_LOCAL_DATE_TIME	ISO本地日期和时间	'2011-12-03T10：15：30'
         */
        return LocalDateTime.parse(dateTimeStr);
    }

    /**
     * @describe LocalDateTime 转换为 LocalDateTimeString
     *
     * @param dateTimeStr 时间字符串
     * @param pattern 格式化字符串
     */
    public static LocalDateTime toLocalDateTime (String dateTimeStr, String pattern) {

        if(StringUtils.isEmpty(dateTimeStr)){
            return null;
        }

        return StringUtils.isEmpty(pattern) ? LocalDateTime.parse(dateTimeStr) :
                LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static void main (String[] args) {

        /*LocalDateTime localDateTimeNow = LocalDateTime.now();
        LocalDateTime localDateTimeNowNull = null;

        System.out.println(toDateTimeString(localDateTimeNow));
        System.out.println(toDateTimeString(localDateTimeNowNull));
        System.out.println(toDateTimeString(localDateTimeNow,"yyyy/MM/dd"));
        System.out.println(toDateTimeString(localDateTimeNowNull,"yyyy/MM/dd"));*/
    }
}
