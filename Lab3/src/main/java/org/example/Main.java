package org.example;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Attraction> attractions = new ArrayList<>();
        attractions.add(new Statue("Statue1", "beautiful"));
        attractions.add(new Statue("Statue2", "wonderful"));
        attractions.add(new Concert("Concert1", "loud", 240.0));
        attractions.add(new Church("Church1", "divine"));

        LocalDate startDate = LocalDate.of(2024, 8, 20);
        LocalDate endDate = LocalDate.of(2024, 8, 27);
        Trip trip = new Trip("Athens", startDate, endDate, attractions);

        System.out.println("Trip Details: ");
        System.out.println("City: " + trip.getCity());
        System.out.println("Start date: " + trip.getStart());
        System.out.println("End date: " + trip.getEnd());
        System.out.println("Attractions:");
        //Map<LocalDate, TimeInterval> timetable = new HashMap<>();
        //timetable.put(LocalDate.of(2024, 3, 17), new TimeInterval(LocalTime.of(9, 0), LocalTime.of(17, 0)));

        Church church2 = new Church("Church2", "baroque");
        church2.addTimeInterval(DayOfWeek.TUESDAY, LocalTime.of(8,30), LocalTime.of(15,30));
        church2.addTimeInterval(DayOfWeek.THURSDAY, LocalTime.of(8,30), LocalTime.of(15,30));
        church2.addTimeInterval(DayOfWeek.SUNDAY, LocalTime.of(15,0), LocalTime.of(18,30));

        attractions.add(church2);

        Concert concert2 = new Concert("Concert2", "classical",100.0);
        concert2.addTimeInterval(DayOfWeek.FRIDAY, LocalTime.of(19,0), LocalTime.of(21,30));
        attractions.add(concert2);

        for (Attraction attraction : trip.getAttractions()) {
            System.out.println("- " + attraction.getName() + ": " + attraction.getDescription());

            if (attraction instanceof Payable){
                Payable payableAttraction = (Payable) attraction;
                double ticketPrice = payableAttraction.getTicketPrice();
                System.out.println("       Ticket price: "+ ticketPrice);
            }
            if (attraction instanceof Visitable){
                Visitable visitableAttraction = (Visitable) attraction;
                Map<DayOfWeek, TimeInterval> timetable = visitableAttraction.getTimetable();
                if(timetable != null && !timetable.isEmpty()){
                    System.out.println("         Timetable: ");
                    for(Map.Entry<DayOfWeek, TimeInterval> entry : timetable.entrySet()){
                        DayOfWeek dayOfWeek = entry.getKey();
                        TimeInterval timeInterval = entry.getValue();
                        System.out.println("        - "+ dayOfWeek + ": " + timeInterval.getFirst() + " - "+timeInterval.getSecond());

                    }
                }
                else
                    System.out.println("    No timetable ");
            }


        }







            //Statue statue1 = new Statue("Statue1", "beautiful");
        //Statue statue2 = new Statue("Statue2", "wonderful");
        //Concert concert1 = new Concert("Concert1", "loud", 240.0, (Map<LocalDate, TimeInterval>) timeInterval);
        //Church church1 = new Church("Church1", "divine");

        /*
        System.out.println("Statues: ");
        System.out.println("Name: " + statue1.getName());
        System.out.println("Description: " + statue1.getDescription());
        System.out.println("Name: " + statue2.getName());
        System.out.println("Description: " + statue2.getDescription());
        System.out.println("\nConcert: ");
        System.out.println("Name: " + concert1.getName());
        System.out.println("Description: " + concert1.getDescription());
        System.out.println("\nChurch: ");
        System.out.println("Name: " + church1.getName());
        System.out.println("Description: " + church1.getDescription());

        if (concert1 instanceof Payable) {
            Payable payableConcert = (Payable) concert1;
            System.out.println("Ticket price for " + concert1.getName() + " " + payableConcert.getTicketPrice());
        }
        if (concert1 instanceof Visitable){
            Visitable visitableConcert = (Visitable) concert1;
            LocalDate date = LocalDate.of(2024, 03, 17);
            System.out.println("Opening hour is: " + date + " " + visitableConcert.getOpeningHour(date));
        }
        if (church1 instanceof Visitable){
            Visitable visitableChurch = (Visitable) church1;
            LocalDate date = LocalDate.of(2024, 3, 23);
            System.out.println("fvre" + date + visitableChurch.getTimetable());
        }
*/

    }
}