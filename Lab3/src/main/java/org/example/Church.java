package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EnumMap;
import java.util.Map;
//

public class Church extends Attraction implements Visitable {

    private Map<DayOfWeek, TimeInterval> timetable;
    public Church(String name, String description) {

        super(name, description);
        this.timetable = new EnumMap<>(DayOfWeek.class);//asociez pt fiecare zi din sapt un interval de timp

    }

    @Override
    public Map<DayOfWeek, TimeInterval> getTimetable() {
        return timetable;
    }

    @Override
    public LocalTime getOpeningHour(LocalDate date) {
        return Visitable.super.getOpeningHour(date);
    }

    @Override
    public int compareTo(Attraction o) {
        return 0;
    }

    public void addTimeInterval(DayOfWeek dayOfWeek, LocalTime openingTime, LocalTime closingTime){
        TimeInterval interval = new TimeInterval(openingTime, closingTime);
        timetable.put(dayOfWeek,interval);
    }
}
