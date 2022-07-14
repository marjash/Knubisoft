package com.knubisoft.base.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateTasksImpl implements DateTasks {

    @Override
    public String add1Day(String date) {
        LocalDate localDate = LocalDate.parse(date);
        localDate = localDate.plusDays(1);
        return localDate.toString();
    }

    @Override
    public int getMonthFromDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy", Locale.ENGLISH);
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate.getMonth().getValue();
    }

    @Override
    public String findBiggestDate(String date1, String date2, String date3) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(date1, formatter);
        LocalDateTime localDateTime2 = LocalDateTime.parse(date2, formatter);
        LocalDateTime localDateTime3 = LocalDateTime.parse(date3, formatter);
        if ((localDateTime.isAfter(localDateTime2) && (localDateTime.isAfter(localDateTime3))))
            return localDateTime.format(formatter);
        if ((localDateTime2.isAfter(localDateTime) && (localDateTime2.isAfter(localDateTime3))))
            return localDateTime2.format(formatter);
        return localDateTime3.format(formatter);
    }

    @Override
    public String getLastDayOfTheMonth(String date) {
        LocalDate localDate = LocalDate.parse(date);
        YearMonth month = YearMonth.from(localDate);
        LocalDate localDate1 = month.atEndOfMonth();
        return localDate1.toString();
    }

    @Override
    public String sumTimes(String time1, String time2) {
        LocalTime localTime = LocalTime.parse(time1);
        LocalTime localTime2 = LocalTime.parse(time2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime3 = localTime.plusHours(localTime2.getHour()).plusMinutes(localTime2.getMinute()).plusSeconds(localTime2.getSecond());
        return localTime3.format(formatter);
    }

    @Override
    public String getDateAfter2Weeks(String date) {
        LocalDate localDate = LocalDate.parse(date);
        localDate = localDate.plusWeeks(2);
        return localDate.toString();
    }

    @Override
    public long getNumberOfDaysBetweenTwoDates(String date1, String date2) {
        LocalDate localDate = LocalDate.parse(date1);
        LocalDate localDate2 = LocalDate.parse(date2);
        return ChronoUnit.DAYS.between(localDate, localDate2);
    }

    @Override
    public String[] getTheNextAndPreviousFriday(String date) {
        LocalDate localDate = LocalDate.parse(date);
        LocalDate nextFriday;
        LocalDate prevFriday;
        String[] dayOfWeek = new String[2];
        int friday = 5;
        int today = localDate.getDayOfWeek().getValue();
        int days = friday - today;
        if (days > 0 && days < 5){
            nextFriday = localDate.plusDays(days);
            prevFriday = localDate.minusDays(7 - days);
        }
        else if (days == 0){
            nextFriday = localDate.plusDays(7);
            prevFriday = localDate.minusDays(7);
        }
        else {
            prevFriday = localDate.plusDays(days);
            nextFriday = localDate.minusDays(7 + days);
        }
        dayOfWeek[0] = prevFriday.toString();
        dayOfWeek[1] = nextFriday.toString();
        return dayOfWeek;
    }

    @Override
    public int getNumberOfMonthsRemainingInTheYear(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return 12 - localDate.getMonth().getValue();
    }
}
