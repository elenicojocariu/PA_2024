package org.example;

import java.time.LocalDate;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable {
    private Map<LocalDate, TimeInterval> timetable;
    private double ticketPrice;

    public Concert(String name, String description) {
        super(name, description);
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }

    @Override
    public int compareTo(Attraction o) {
        return 0;
    }
}
