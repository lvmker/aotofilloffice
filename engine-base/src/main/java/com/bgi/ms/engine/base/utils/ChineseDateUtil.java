package com.bgi.ms.engine.base.utils;

import java.time.LocalDate;

/**
 * @program: code
 * @description: 当前日期转换成中文汉字表示
 * @author: luojiwen
 * @create: 2020-02-28 16:41
 **/
public class ChineseDateUtil {
    /**
     * 中文数字
     */
    private static final String[] CN_NUMBER_NAME = {"〇", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    /**
     * 获取当前时间的中文时间
     * params date ：必须是这种格式的yyyy-MM-dd
     * @return 中文时间
     */
    public static String getCurrentCNDate(String date) {

        String year = DateUtil.getYear(date,"yyyy-MM-dd")+""; // 得到年
        String month = DateUtil.getMonth(date,"yyyy-MM-dd")+""; // 得到月，因为从0开始的，所以要加1
        String day = DateUtil.getDay(date,"yyyy-MM-dd")+""; // 得到天
        StringBuilder cnDate = new StringBuilder();
        for (int i = 0; i < year.length(); i++) {
            cnDate.append(CN_NUMBER_NAME[Integer.valueOf(String.valueOf(year.charAt(i)))]);
        }

        cnDate.append("年");

        if (month.length() == 2) {
            Integer value = Integer.valueOf(String.valueOf(month.charAt(0)));
            if (!value.equals(1)) {
                cnDate.append(CN_NUMBER_NAME[value]);
            }
            cnDate.append("十");
            if (!String.valueOf(month.charAt(1)).equals("0")) {
                cnDate.append(CN_NUMBER_NAME[Integer.valueOf(String.valueOf(month.charAt(1)))]);
            }
        } else {
            cnDate.append(CN_NUMBER_NAME[Integer.valueOf(String.valueOf(month.charAt(0)))]);
        }

        cnDate.append("月");

        if (day.length() == 2) {
            Integer value = Integer.valueOf(String.valueOf(day.charAt(0)));
            if (!value.equals(1)) {
                cnDate.append(CN_NUMBER_NAME[value]);
            }
            cnDate.append("十");
            if (!String.valueOf(day.charAt(1)).equals("0")) {
                cnDate.append(CN_NUMBER_NAME[Integer.valueOf(String.valueOf(day.charAt(1)))]);
            }
        } else {
            cnDate.append(CN_NUMBER_NAME[Integer.valueOf(String.valueOf(day.charAt(0)))]);
        }

        cnDate.append("日");
        return cnDate.toString();
    }

    public static void main(String[] args) {
        System.out.println(getCurrentCNDate("2019-10-12"));

//        System.out.println(DateUtil.("2019/12/10 00:00:00","yyyy-MM-dd"));
    }
}
