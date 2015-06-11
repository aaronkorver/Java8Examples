package com.example.dateTime;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.stream.Stream;

/**
 * Created by aaron.korver.
 */
public class TestDateTimeAPI {

    @Test
    public void testOldDateAPI()
    {
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());

        Date currentTime = localCalendar.getTime();
        int currentDay = localCalendar.get(Calendar.DATE);
        int currentMonth = localCalendar.get(Calendar.MONTH) + 1;
        int currentYear = localCalendar.get(Calendar.YEAR);
        int currentDayOfWeek = localCalendar.get(Calendar.DAY_OF_WEEK);
        int currentDayOfMonth = localCalendar.get(Calendar.DAY_OF_MONTH);
        int CurrentDayOfYear = localCalendar.get(Calendar.DAY_OF_YEAR);

        System.out.println("Current Date and time details in local timezone");
        System.out.println("Current Date: " + currentTime);
        System.out.println("Current Day: " + currentDay);
        System.out.println("Current Month: " + currentMonth);
        System.out.println("Current Year: " + currentYear);
        System.out.println("Current Day of Week: " + currentDayOfWeek);
        System.out.println("Current Day of Month: " + currentDayOfMonth);
        System.out.println("Current Day of Year: " + CurrentDayOfYear);

    }

    @Test
    public void testNewDateAPI()
    {
        LocalDateTime now = LocalDateTime.now();
        LocalDate currentDate = now.toLocalDate();
        int currentMonth = now.getMonthValue();
        int currentYear = now.getYear();
        int currentDayOfWeek = now.getDayOfWeek().getValue();
        int currentDayOfMonth = now.getDayOfMonth();
        int CurrentDayOfYear = now.getDayOfYear();
        System.out.println("Current Date and time details in local timezone");
        System.out.println("Current Date: " + now);
        System.out.println("Current Day: " + currentDate);
        System.out.println("Current Month: " + currentMonth);
        System.out.println("Current Year: " + currentYear);
        System.out.println("Current Day of Week: " + currentDayOfWeek);
        System.out.println("Current Day of Month: " + currentDayOfMonth);
        System.out.println("Current Day of Year: " + CurrentDayOfYear);
    }

    @Test
    public void funWithDateEnums()
    {
        Stream.of(DayOfWeek.values()).forEach(System.out::println);
        Stream.of(Month.values()).forEach(month -> System.out.printf("%s has %d days%n",month.name(),month.maxLength()));
    }

    @Test
    public void localDateTimeExamples()
    {
        System.out.printf("now: %s%n", LocalDateTime.now());

        System.out.printf("Apr 15, 1994 @ 11:30am: %s%n",
                LocalDateTime.of(1994, Month.APRIL, 15, 11, 30));

        System.out.printf("now (from Instant): %s%n",
                LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));

        System.out.printf("6 months from now: %s%n",
                LocalDateTime.now().plusMonths(6));

        System.out.printf("6 months ago: %s%n",
                LocalDateTime.now().minusMonths(6));
    }

    @Test
    public void howOldAmI()
    {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1980, Month.FEBRUARY, 23);

        Period p = Period.between(birthday, today);
        long p2 = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
                " months, and " + p.getDays() +
                " days old. (" + p2 + " days total)");
    }

    @Test
    public void whenIsMyNextBirthday()
    {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1980, Month.FEBRUARY, 23);

        LocalDate nextBDay = birthday.withYear(today.getYear());

//If your birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        Period p = Period.between(today, nextBDay);
        long p2 = ChronoUnit.DAYS.between(today, nextBDay);
        System.out.println("There are " + p.getMonths() + " months, and " +
                p.getDays() + " days until your next birthday. (" +
                p2 + " total)");
    }
}
