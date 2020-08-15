package com.extra.joda;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 日期常用处理
 * </p>
 *
 * @author mengjian.ke@hand-china.com
 * 2019/7/30 14:36
 */
public class JodaTimeUtil {

    private static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String STANDARD_FORMAT_S = "yyyy-MM-dd HH:mm:ss.s";
    private static final String OMIT_STANDARD_FORMAT = "yyyyMMddHHmmss";
    private static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";
    private static final String SIMPLE_OMIT_DATE_FORMAT = "yyyyMMdd";
    private static final String YEAR_MONTH = "yyyy-MM";

    public static String dateToStr(Date date) {
        return dateToStrFormat(date, STANDARD_FORMAT);
    }

    public static String dateToStr() {
        return dateToStrFormat(STANDARD_FORMAT);
    }

    public static String dateToStrForSimpleDate(Date date) {
        return dateToStrFormat(date, SIMPLE_DATE_FORMAT);
    }

    public static String dateToStrForSimpleDate() {
        return dateToStrFormat(SIMPLE_DATE_FORMAT);
    }

    public static String dateToStrOmit(Date date) {
        return dateToStrFormat(date, OMIT_STANDARD_FORMAT);
    }

    public static String dateToStrOmit() {
        return dateToStrFormat(OMIT_STANDARD_FORMAT);
    }

    public static String dateToStrSimpleOmit() {
        return dateToStrFormat(SIMPLE_OMIT_DATE_FORMAT);
    }

    public static String dateToSimple(Date date) {
        return dateToStrFormat(date, YEAR_MONTH);
    }

    public static Date strToDateForSimpleDate(String date) {
        return strToDate(date, SIMPLE_DATE_FORMAT);
    }

    public static Date strToDateForSimple(String date) {
        return strToDate(date, YEAR_MONTH);
    }

    public static Date strToDate(String date) {
        return strToDate(date, STANDARD_FORMAT);
    }

    public static Date strsToDate(String date) {
        return strToDate(date, STANDARD_FORMAT_S);
    }

    public static String datesToStr(Date date) {
        return dateToStrFormat(date,STANDARD_FORMAT_S);
    }

    public static Date strToDateForOmit(String date) {
        return strToDate(date, OMIT_STANDARD_FORMAT);
    }

    private static String dateToStrFormat(Date date, String format) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(format);
    }

    private static String dateToStrFormat(String format) {
        return dateToStrFormat(new Date(), format);
    }

    /**
     * date类型 -> string类型
     *
     * @param date
     * @param formatPattern
     * @return
     */
    public static String dateToStr(Date date, String formatPattern) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatPattern);
    }

    /**
     * string类型 -> date类型
     *
     * @param timeStr
     * @return
     */
    public static Date strToDate(String timeStr, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(pattern);
        DateTime dateTime = dateTimeFormatter.parseDateTime(timeStr);
        return dateTime.toDate();
    }

    /**
     * 判断date日期是否过期(与当前时刻比较)
     *
     * @param date
     * @return
     */
    public static boolean isTimeExpired(Date date) {
        if (null == date) {
            return true;
        }
        String timeStr = dateToStr(date);
        return isBeforeNow(timeStr);
    }

    /**
     * 判断date日期是否过期(与当前时刻比较)
     *
     * @param timeStr
     * @return
     */
    public static boolean isTimeExpired(String timeStr) {
        if (StringUtils.isBlank(timeStr)) {
            return true;
        }
        return isBeforeNow(timeStr);
    }

    /**
     * 判断timeStr是否在当前时刻之前
     *
     * @param timeStr
     * @return
     */
    private static boolean isBeforeNow(String timeStr) {
        DateTimeFormatter format = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = DateTime.parse(timeStr, format);
        return dateTime.isBeforeNow();
    }

    /**
     * 日期加天数
     *
     * @param date
     * @param days
     * @return
     */
    public static Date plusDays(Date date, Integer days) {
        return plusOrMinusDays(date, days, 0);
    }

    /**
     * 日期减天数
     *
     * @param date
     * @param days
     * @return
     */
    public static Date minusDays(Date date, Integer days) {
        return plusOrMinusDays(date, days, 1);
    }

    /**
     * 加减天数
     *
     * @param date
     * @param days
     * @param type 0:加天数 1:减天数
     * @return
     */
    private static Date plusOrMinusDays(Date date, Integer days, Integer type) {
        if (null == date) {
            return null;
        }
        days = null == days ? 0 : days;

        DateTime dateTime = new DateTime(date);
        if (type == 0) {
            dateTime = dateTime.plusDays(days);
        } else {
            dateTime = dateTime.minusDays(days);
        }

        return dateTime.toDate();
    }

    /**
     * 日期加分钟
     *
     * @param date
     * @param minutes
     * @return
     */
    public static Date plusMinutes(Date date, Integer minutes) {
        return plusOrMinusMinutes(date, minutes, 0);
    }

    /**
     * 日期减分钟
     *
     * @param date
     * @param minutes
     * @return
     */
    public static Date minusMinutes(Date date, Integer minutes) {
        return plusOrMinusMinutes(date, minutes, 1);
    }

    /**
     * 加减分钟
     *
     * @param date
     * @param minutes
     * @param type    0:加分钟 1:减分钟
     * @return
     */
    private static Date plusOrMinusMinutes(Date date, Integer minutes, Integer type) {
        if (null == date) {
            return null;
        }
        minutes = null == minutes ? 0 : minutes;

        DateTime dateTime = new DateTime(date);
        if (type == 0) {
            dateTime = dateTime.plusMinutes(minutes);
        } else {
            dateTime = dateTime.minusMinutes(minutes);
        }

        return dateTime.toDate();
    }

    /**
     * 日期加月份
     *
     * @param date
     * @param months
     * @return
     */
    public static Date plusMonths(Date date, Integer months) {
        return plusOrMinusMonths(date, months, 0);
    }

    /**
     * 日期减月份
     *
     * @param date
     * @param months
     * @return
     */
    public static Date minusMonths(Date date, Integer months) {
        return plusOrMinusMonths(date, months, 1);
    }

    /**
     * 加减月份
     *
     * @param date
     * @param months
     * @param type   0:加月份 1:减月份
     * @return
     */
    private static Date plusOrMinusMonths(Date date, Integer months, Integer type) {
        if (null == date) {
            return null;
        }
        months = null == months ? 0 : months;

        DateTime dateTime = new DateTime(date);
        if (type == 0) {
            dateTime = dateTime.plusMonths(months);
        } else {
            dateTime = dateTime.minusMonths(months);
        }

        return dateTime.toDate();
    }

    /**
     * 判断target是否在开始和结束时间之间
     *
     * @param target
     * @param startTime
     * @param endTime
     * @return
     */
    public static boolean isBetweenStartAndEndTime(Date target, Date startTime, Date endTime) {
        if (null == target || null == startTime || null == endTime) {
            return false;
        }

        DateTime dateTime = new DateTime(target);
        return dateTime.isAfter(startTime.getTime()) && dateTime.isBefore(endTime.getTime());
    }

    /**
     * 获取月份的第一天
     *
     * @param months 月份数
     * @return 20190601, 20190701, 20190722
     */
    public static List<String> getAllMonthsDelay(int months) {
        List<String> dates = new ArrayList<>();
        DateTime dateTime = new DateTime(new Date());
        for (int i = -1; i < months; i++) {
            dates.add(dateTime.minusMonths(i).dayOfMonth().withMinimumValue().toString(SIMPLE_DATE_FORMAT));
        }
        return dates;
    }

    /**
     * 天数间隔
     *
     * @param startDatestr 开始日期
     * @param endDatestr   结束日期
     */
    public static Integer dateIntervalDefault(String startDatestr, String endDatestr) {
        return dateInterval(startDatestr, endDatestr, DateIntervalMode.DAY, SIMPLE_DATE_FORMAT);
    }

    /**
     * 天数间隔
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     */
    public static Integer dateIntervalDefault(Date startDate, Date endDate) {
        return dateInterval(startDate, endDate, DateIntervalMode.DAY);
    }

    /**
     * 日期间隔
     *
     * @param startDatestr 开始日期
     * @param endDatestr   结束日期
     * @param pattern      字符串格式
     */
    public static Integer dateIntervalByDay(String startDatestr, String endDatestr, String pattern) {
        return dateInterval(startDatestr, endDatestr, DateIntervalMode.DAY, pattern);
    }

    /**
     * 日期间隔(year,month,day)
     * 字符串的日期格式默认为 2019-01-01
     *
     * @param startDatestr 开始日期
     * @param endDatestr   结束日期
     * @param mode         计算年份,月份,天数
     */
    public static Integer dateIntervalSimpleDate(String startDatestr, String endDatestr, DateIntervalMode mode) {
        return dateInterval(startDatestr, endDatestr, mode, SIMPLE_DATE_FORMAT);
    }

    /**
     * 日期间隔
     *
     * @param startDatestr 开始日期
     * @param endDatestr   结束日期
     * @param mode         年月日
     * @param pattern      字符串日期格式
     */
    public static Integer dateInterval(String startDatestr, String endDatestr, DateIntervalMode mode, String pattern) {
        Date startDate = strToDate(startDatestr, pattern);
        Date endDate = strToDate(endDatestr, pattern);
        return dateInterval(startDate, endDate, mode);
    }

    /**
     * 日期间隔
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param mode      年月日
     */
    public static Integer dateInterval(Date startDate, Date endDate, DateIntervalMode mode) {
        Integer interval = null;
        DateTime startDateTime = new DateTime(startDate);
        DateTime endDateTime = new DateTime(endDate);

        switch (mode) {
            case DAY:
                interval = Days.daysBetween(startDateTime, endDateTime).getDays();
                break;
            case MONTH:
                interval = Months.monthsBetween(startDateTime, endDateTime).getMonths();
                break;
            case YEAR:
                interval = Years.yearsBetween(startDateTime, endDateTime).getYears();
                break;
        }
        return interval;
    }

    public static int getMonth(Date date){
        return new DateTime(date).getMonthOfYear();
    }

    public static int getYear(Date date){
        return new DateTime(date).getYear();
    }

    public enum DateIntervalMode {

        DAY(1), MONTH(2), YEAR(3);

        DateIntervalMode(Integer key) {
        }
    }

}
