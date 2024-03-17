package org.example;

import org.example.TimeInterval;
import org.example.Visitable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;


public class Church extends Attraction implements Visitable {
    public Church(String name, String description) {
        super(name, description);
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return null;
    }

    @Override
    public LocalTime getOpeningHour(LocalDate date) {
        return Visitable.super.getOpeningHour(date);
    }

    @Override
    public int compareTo(Attraction o) {
        return 0;
    }
}
