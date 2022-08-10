package com.knubisoft.base.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
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
        try{
            calendar.setTime(simpleDateFormat.parse(date));
        }catch(ParseException e){
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
        return null;
    }

    @Override
    public String getLastDayOfTheMonth(String date) {
        return null;
    }

    @Override
    public String sumTimes(String time1, String time2) {
        return null;
    }

    @Override
    public String getDateAfter2Weeks(String date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        try{
            calendar.setTime(simpleDateFormat.parse(date));
        }catch(ParseException e){
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

        return new String[] {previousFriday, nextFriday};
    }

    @Override
    public int getNumberOfMonthsRemainingInTheYear(String date) {

        LocalDate today = LocalDate.parse(date);

        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        Period period = today.until(lastDayOfYear);

        return period.getMonths();
    }
}
