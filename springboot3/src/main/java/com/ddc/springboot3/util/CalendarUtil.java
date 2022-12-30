package com.ddc.springboot3.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalendarUtil {

    public static int getCurrentStageNumber(String startDate) {
        String startYear = "0";
        String startMonth = "0";
        if (StringUtils.hasLength(startDate)) {
            startYear = startDate.substring(0, 4);
            startMonth = startDate.substring(4);
        }
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
        String dateString = date.format(formatter);
        String[] dateStringArray = dateString.split("-");
        String currentMonth = dateStringArray[0];
        String currentYear = dateStringArray[1];
        int currentStageNumber = 0;
        int yearDiff = Integer.parseInt(currentYear) - Integer.parseInt(startYear);
        if (yearDiff == 0) {
            currentStageNumber = Integer.parseInt(currentMonth) - Integer.parseInt(startMonth) + 1;
        } else {
            currentStageNumber = (yearDiff - 1) * 12 + Integer.parseInt(currentMonth) + (13 - Integer.parseInt(startMonth));
        }
        return currentStageNumber;
    }
}
