package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*TimeInterval timeInterval = new TimeInterval(LocalTime.of(8,0), LocalTime.of(16,0));
        System.out.println("Timeinterval: "+ timeInterval);
        Pair<String, Integer> pair = new Pair<>("Hey", 11);
        System.out.println("Pair: " + pair); */

        List<Attraction> attractions = new ArrayList<>();
        attractions.add(new Statue("Statue1", "beautiful"));
        attractions.add(new Statue("Statue2", "wonderful"));
        //attractions.add(new Concert("Concert1", "loud", 240.0, (Map<LocalDate, TimeInterval>) timeInterval));
        attractions.add(new Church("Church1", "divine"));

        LocalDate startDate = LocalDate.of(2024, 8, 20);
        LocalDate endDate = LocalDate.of(2024, 8, 27);
        Trip trip = new Trip("Athens", startDate, endDate, attractions);

        System.out.println("Trip Details: ");
        System.out.println("City: " + trip.getCity());
        System.out.println("Start date: " + trip.getStart());
        System.out.println("End date: " + trip.getEnd());
        System.out.println("Attractions:");
        for (Attraction attraction : trip.getAttractions()) {
            System.out.println("- " + attraction.getName() + ": " + attraction.getDescription());
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