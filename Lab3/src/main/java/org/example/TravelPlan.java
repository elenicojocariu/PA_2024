package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class TravelPlan {

    private Map<Attraction, LocalDate> plan;

    public TravelPlan() {
        this.plan = new HashMap<>();
    }
    public void addAttraction(Attraction attraction, LocalDate visitDay){

        plan.put(attraction, visitDay);
    }
    public void printTravelPlan() {
        System.out.println("Travel Plan:");
        for (Map.Entry<Attraction, LocalDate> entry : plan.entrySet()) {
            Attraction attraction = entry.getKey();
            LocalDate visitDay = entry.getValue();
            if (attraction instanceof Visitable) {
                LocalTime openingHour = ((Visitable) attraction).getOpeningHour(visitDay);
                System.out.println("- " + attraction.getName() + ": " + visitDay + " - Opening hour: " + openingHour);
            }
            else
                System.out.println("- "+ attraction.getName() + ": " + visitDay + " - without timeinterval");

        }
    }

}
