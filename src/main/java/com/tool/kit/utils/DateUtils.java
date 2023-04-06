package com.tool.kit.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DateUtils {

    public static LinkedList<LocalDate> getDatesBetweenTwoDays(LocalDate startDate, LocalDate endDate) {
        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate.plusDays(1));
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(startDate::plusDays)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public static long getMonthsBetweenTwoDays(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.MONTHS.between(startDate, endDate);
    }

}
