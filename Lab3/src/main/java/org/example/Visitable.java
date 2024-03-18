package org.example;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public interface Visitable {

    Map<DayOfWeek, TimeInterval> getTimetable();

    default LocalTime getOpeningHour(LocalDate date) {

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        TimeInterval timeInterval = getTimetable().get(dayOfWeek);
        if(timeInterval!=null)
            return timeInterval.getFirst();
        return null;
    }


}
