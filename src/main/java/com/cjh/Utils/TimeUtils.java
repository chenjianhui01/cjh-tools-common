package com.cjh.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @author: chenJianHui
 * @date: 2021/11/15 16:07
 */
public class TimeUtils {



    /**
     * 按照指定小时分割时间段，
     * flag true 区间为 [ dBegin，dEnd ]
     * flag false 区间为 ( dBegin，dEnd ]
     * @param dateType 类型 M/D/H/N -->每月/每天/每小时/每分钟
     * @param dBegin   开始时间
     * @param dEnd     结束时间
     * @param time     指定小时(如：1、2、3、4)
     * @return
     */
    public static List<Date> getTimePeriods(String dateType, Date dBegin, Date dEnd, int time, boolean flag) throws Exception {
        List<String> listDate = new ArrayList<>();
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        if (flag) {
            listDate.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dBegin));
        }
        if ("H".equals(dateType)) {
            calEnd.add(Calendar.HOUR_OF_DAY, time);
        }
        if ("D".equals(dateType)) {
            calEnd.add(Calendar.DATE, time);
        }

        while (calEnd.after(calBegin)) {
            if ("H".equals(dateType)) {
                calBegin.add(Calendar.HOUR_OF_DAY, time);
            }
            if ("M".equals(dateType)) {
                calBegin.add(Calendar.MONTH, time);
            }
            if ("D".equals(dateType)) {
                calBegin.add(Calendar.DATE, time);
            }
            if ("N".equals(dateType)) {
                calBegin.add(Calendar.MINUTE, time);
            }
            if (calEnd.after(calBegin)) {
                listDate.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calBegin.getTime()));
            }
        }
        ArrayList<Date> dates = new ArrayList<>();
        for (String s : listDate) {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:00:00").parse(s);
            dates.add(parse);
        }
        return dates;
    }



    /**
     * 对传入的时间字符串格式化，如：2021-11-18 10:23:45 ――> 2021-11-18 10:00:00
     * @param timeStr
     * @return
     */
    public static Date stringTimeFormat(String timeStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse(timeStr);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
        String format = sdf2.format(parse);
        Date time = sdf.parse(format);
        return time;

    }
}
