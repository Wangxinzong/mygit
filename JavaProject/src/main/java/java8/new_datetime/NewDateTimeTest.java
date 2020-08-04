package main.java.java8.new_datetime;

import java.time.*;

public class NewDateTimeTest {

    public static void main(String[] aggs) {
        NewDateTimeTest t = new NewDateTimeTest();
        //t.localDateTime();
        //t.instant();
        t.duration();
    }

    public void localDateTime() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        LocalDateTime ldt2 = LocalDateTime.of(2018, 10, 1, 23, 12, 3);
        System.out.println(ldt2);
    }

    /**
     * instant:时间戳
     * (以Unix元年：1970年1月1日00:00:00到某个时间之间的毫秒值)
     */
    public void instant() {
        //UTC时间
        Instant instant = Instant.now();
        System.out.println(instant);
        //中国时区的时间
        OffsetDateTime odt = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);
        //毫秒
        long milli = instant.toEpochMilli();
        System.out.println(milli);
    }

    public void duration() {
        LocalDateTime ldt = LocalDateTime.of(2018, 10, 1, 23, 10, 3);
        LocalDateTime ldt2 = LocalDateTime.of(2018, 10, 1, 23, 12, 3);
        //计算两个时间差值
        Duration duration = Duration.between(ldt, ldt2);
        System.out.println(duration.toMinutes());

        LocalDate ld = LocalDate.of(2018, 1, 1);
        LocalDate ld2 = LocalDate.of(2016, 12, 1);
        //计算两个日期差值
        Period period = Period.between(ld2, ld);
        System.out.println(period.getYears());
    }

}
