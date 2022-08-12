package com.knubisoft.base.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class DateTasksImpl implements DateTasks {

    @Override
    public String add1Day(String date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        calendar.add(Calendar.DAY_OF_MONTH, 1);

        return simpleDateFormat.format(calendar.getTime());
    }

    @Override
    public int getMonthFromDate(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy", Locale.ENGLISH);

        LocalDate dateTime = LocalDate.parse(date, formatter);

        return dateTime.getMonthValue();
    }

    @Override
    public String findBiggestDate(String date1, String date2, String date3) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate date11 = LocalDate.parse(date1, formatter);
        LocalDate date22 = LocalDate.parse(date2, formatter);
        LocalDate date33 = LocalDate.parse(date3, formatter);

        if (date11.compareTo(date22) > 0) {
            if (date11.compareTo(date33) > 0) {
                return date1;
            } else {
                return date3;
            }
        } else if (date22.compareTo(date33) > 0) {
            return date2;
        } else {
            return date3;
        }
    }

    @Override
    public String getLastDayOfTheMonth(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate newDate = LocalDate.parse(date, formatter);

        return newDate.plusDays(newDate.lengthOfMonth() - newDate.getDayOfMonth()).toString();
    }

    @Override
    public String sumTimes(String time1, String time2) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        return LocalTime.parse(time1).plusSeconds(LocalTime.parse(time2)
                .toSecondOfDay()).format(formatter);
    }

    @Override
    public String getDateAfter2Weeks(String date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        calendar.add(Calendar.DAY_OF_MONTH, 14);

        return simpleDateFormat.format(calendar.getTime());
    }

    @Override
    public long getNumberOfDaysBetweenTwoDates(String date1, String date2) {

        LocalDate dateBefore = LocalDate.parse(date1);
        LocalDate dateAfter = LocalDate.parse(date2);

        return ChronoUnit.DAYS.between(dateBefore, dateAfter);
    }

    @Override
    public String[] getTheNextAndPreviousFriday(String date) {

        LocalDate today = LocalDate.parse(date);

        String previousFriday = String.valueOf(today.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)));
        String nextFriday = String.valueOf(today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));

        return new String[]{previousFriday, nextFriday};
    }

    @Override
    public int getNumberOfMonthsRemainingInTheYear(String date) {

        LocalDate today = LocalDate.parse(date);

        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        Period period = today.until(lastDayOfYear);

        return period.getMonths();
    }
}
