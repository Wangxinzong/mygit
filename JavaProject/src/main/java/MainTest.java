package main.java;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;

public class MainTest {

    public static void main(String[] args) {
       MainTest mt = new MainTest();
      String s = mt.getSql("r.rebate_create_time");
      System.out.println(s);
    }

    public ClassTest a(List<ClassTest> list) {
        for (ClassTest classTest : list) {
            if (classTest.getName().equals("b")) {
                return classTest;
            }
        }
        return null;
    }

    public String getSql(String fileName) {
        long startTime = 0L;
        long endTime = 0L;

        //前一天
//            startTime = startOfTodDay(Calendar.DAY_OF_MONTH, -1);
//            endTime = endOfTodDay(Calendar.DAY_OF_MONTH, -1);

        //前一周
        startTime = startOfTodDay(Calendar.DAY_OF_WEEK, -7);
        endTime = endOfTodDay(Calendar.DAY_OF_WEEK, -1);

        //上个月
//            startTime = timeOfToMonth(0, -1);
//            endTime = timeOfToMonth(1, -1);

        return getWhere(fileName, startTime, endTime);
    }

    private long startOfTodDay(int indicating, int interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(indicating, interval);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        return date.getTime() / 1000;
    }

    private long endOfTodDay(int indicating, int interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(indicating, interval);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date date = calendar.getTime();
        return date.getTime() / 1000;
    }

    private String getWhere(String fileName, long startTime, long endTime) {
        StringBuilder sb = new StringBuilder();
        sb.append(" AND ")
                .append(fileName)
                .append(" >= ")
                .append(startTime)
                .append(" AND ")
                .append(fileName)
                .append(" <= ")
                .append(endTime);
        return sb.toString();
    }

    public String getprevious() {
        HashMap<String, Integer> ymwdMap = getYmwdMap();
        StringBuilder dayOfYear = new StringBuilder();
        Integer year = ymwdMap.get("year");
        Integer month = ymwdMap.get("month");
        ;
        Integer day = ymwdMap.get("day");
        Integer week = ymwdMap.get("week");
        //当前日期上一天
//        day = day - 1;
//        dayOfYear.append(year).append("-").append(month).append("-").append(day).toString();

        //当前日期上一周是今年第几周
        week = week - 1;
        dayOfYear.append(year).append("-").append(month).append("-").append(week).toString();

        //上个月
//        month = month - 1;
//        dayOfYear.append(year).append("-").append(month).toString();
        return dayOfYear.toString();
    }

    private HashMap<String, Integer> getYmwdMap() {
        HashMap<String, Integer> map = new HashMap<String, Integer>(4);
        LocalDate date = LocalDate.now();

        WeekFields weekFields = WeekFields.ISO;
        int week = date.get(weekFields.weekOfWeekBasedYear());
        int year = date.getYear();
        int month = date.getMonth().getValue();
        int day = date.getDayOfMonth();
        System.out.println("年:"+year+",月:"+month+",日:"+day+",周:"+week);
        map.put("year", year);
        map.put("month", month);
        map.put("week", week);
        map.put("day", day);
        return map;
    }


}
