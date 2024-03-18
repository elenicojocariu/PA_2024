package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.Map;
//
public class Concert extends Attraction implements Visitable, Payable {
    private Map<DayOfWeek, TimeInterval> timetable;
    private double ticketPrice;

    public Concert(String name, String description, double ticketPrice) {
        super(name, description);
        this.ticketPrice = ticketPrice;
        this.timetable = new EnumMap<>(DayOfWeek.class); //?????

    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public Map<DayOfWeek, TimeInterval> getTimetable() {
        return timetable;
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
